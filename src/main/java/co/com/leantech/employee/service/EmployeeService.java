package co.com.leantech.employee.service;

import java.util.List;

import co.com.leantech.employee.dto.EmployeeFilter;
import co.com.leantech.employee.dto.GetEmployeesByPositionResponse;
import co.com.leantech.employee.dto.GetEmployeesResponse;
import co.com.leantech.employee.dto.SetEmployeeDto;

public interface EmployeeService {

	List<GetEmployeesResponse> getAll(EmployeeFilter filter);
	List<GetEmployeesByPositionResponse> getAllByPosition();
	GetEmployeesResponse create(SetEmployeeDto employeeDto);
	GetEmployeesResponse update(SetEmployeeDto employeeDto);
	void delete(Long employeeId);
	
}
