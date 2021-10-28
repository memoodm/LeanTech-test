package co.com.leantech.employee.controller.model.mapper;

import java.util.List;
import java.util.stream.Collectors;

import co.com.leantech.employee.dto.EmployeeDto;
import co.com.leantech.employee.persistence.entity.Employee;

public class EmployeeMapper {
	
	public static EmployeeDto toDto(Employee entity) {
		EmployeeDto dto = new EmployeeDto();
		dto.setId(entity.getId());
		dto.setSalary(entity.getSalary());
		dto.setPerson(PersonMapper.toDto(entity.getPerson()));
		return dto;
	}
	
	public static Employee toEntity(EmployeeDto dto) {
		Employee entity = new Employee();
		entity.setId(dto.getId());
		entity.setSalary(dto.getSalary());
		entity.setPerson(PersonMapper.toEntity(dto.getPerson()));
		return entity;
	}
	
	public static List<EmployeeDto> toDtoList(List<Employee> entities){
		return entities.stream().map(e->toDto(e)).collect(Collectors.toList());
	}

}
