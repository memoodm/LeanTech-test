package co.com.leantech.employee.controller.model.resolver;

import java.util.List;
import java.util.stream.Collectors;

import co.com.leantech.employee.controller.model.mapper.EmployeeMapper;
import co.com.leantech.employee.controller.model.mapper.PositionMapper;
import co.com.leantech.employee.dto.GetEmployeesResponse;
import co.com.leantech.employee.persistence.entity.Employee;

public class GetEmployeesResponseResolver {
	
	public static GetEmployeesResponse resolve(Employee entity) {
		GetEmployeesResponse dto = new GetEmployeesResponse();
		dto.setEmployee(EmployeeMapper.toDto(entity));
		dto.setPosition(PositionMapper.toDto(entity.getPosition()));
		return dto;
	}
	
	public static List<GetEmployeesResponse> resolveList(List<Employee> employee) {
		return employee.stream()
					   .map(e->GetEmployeesResponseResolver.resolve(e))
					   .collect(Collectors.toList());				   
	}
	
}
