package co.com.leantech.employee.controller.model.resolver;

import java.util.List;

import co.com.leantech.employee.controller.model.mapper.EmployeeMapper;
import co.com.leantech.employee.dto.GetEmployeesByPositionResponse;
import co.com.leantech.employee.persistence.entity.Employee;
import co.com.leantech.employee.persistence.entity.Position;

public class GetEmployeesByPositionResolver {
	
	public static GetEmployeesByPositionResponse resolveList(List<Employee> employee,Position position) {
		GetEmployeesByPositionResponse response = new GetEmployeesByPositionResponse();
		response.setId(position.getId());
		response.setName(position.getName());
		response.setEmployees(EmployeeMapper.toDtoList(employee));
		return response;
	}

}
