package co.com.leantech.employee.service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.com.leantech.employee.controller.model.mapper.EmployeeMapper;
import co.com.leantech.employee.controller.model.resolver.GetEmployeesByPositionResolver;
import co.com.leantech.employee.controller.model.resolver.GetEmployeesResponseResolver;
import co.com.leantech.employee.dto.EmployeeFilter;
import co.com.leantech.employee.dto.GetEmployeesByPositionResponse;
import co.com.leantech.employee.dto.GetEmployeesResponse;
import co.com.leantech.employee.dto.SetEmployeeDto;
import co.com.leantech.employee.persistence.entity.Employee;
import co.com.leantech.employee.persistence.entity.Position;
import co.com.leantech.employee.persistence.repository.EmployeeRepository;
import co.com.leantech.employee.persistence.repository.PositionRepository;
import co.com.leantech.employee.utils.CustomErrorException;


@Service
@Primary
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private PositionRepository positionRepository;
	
	@Override
	@Transactional(readOnly = true)
	public List<GetEmployeesResponse> getAll(EmployeeFilter filter) {
		List<Employee> employees = Collections.<Employee>emptyList();
		Pageable pagination = PageRequest.of(filter.getPage(), filter.getResultsByPage());
		if(filter.haveValues()) {
			Position position = positionRepository.findByName(filter.getPosition());
			String personName = filter.getName();
			employees = (List<Employee>) employeeRepository.findAllByPositionOrPersonNameIgnoreCase(position,personName,pagination);
		}
		else {
			Page<Employee> paginatedResult = employeeRepository.findAll(pagination);
			employees = paginatedResult.getContent();
		}
		return GetEmployeesResponseResolver.resolveList(employees);
	}
	
	@Override
	@Transactional(readOnly = true)
	public List<GetEmployeesByPositionResponse> getAllByPosition() {
		List<Position> positions = (List<Position>) positionRepository.findAll();
		return positions.stream()
				 .filter(e->!e.getEmployees().isEmpty())
				 .map(e->GetEmployeesByPositionResolver.resolveList(e.getEmployees(), e))
				 .peek(e->e.getEmployees().sort(Comparator.comparing(data -> data.getSalary())))
				 .peek(e->Collections.reverse(e.getEmployees()))
				 .collect(Collectors.toList());
	}

	@Override
	@Transactional
	public GetEmployeesResponse create(SetEmployeeDto employeeDto) {
		try {
			Position position = positionRepository.findByName(employeeDto.getPosition().getName().getValue());
			Employee employee = EmployeeMapper.toEntity(employeeDto.getEmployee());
			employee.setId(null);
			employee.setPosition(position);
			employee = employeeRepository.save(employee);
			return GetEmployeesResponseResolver.resolve(employee);
		}
		catch(Exception e) {
			throw new CustomErrorException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
	}

	@Override
	@Transactional
	public GetEmployeesResponse update(SetEmployeeDto employeeDto) {
		try {
			Employee employee = employeeRepository.findById(employeeDto.getEmployee().getId()).orElseThrow();
			Position position = positionRepository.findByName(employeeDto.getPosition().getName().getValue());
			employee.updateValues(EmployeeMapper.toEntity(employeeDto.getEmployee()));
			employee.setPosition(position);
			employee = employeeRepository.save(employee);
			return GetEmployeesResponseResolver.resolve(employee);
		}
		catch(Exception e) {
			throw new CustomErrorException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
	}
	
	@Override
	@Transactional
	public void delete(Long employeeId) {
		try {
			employeeRepository.deleteById(employeeId);
		}
		catch(Exception e) {
			throw new CustomErrorException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
	}

}
