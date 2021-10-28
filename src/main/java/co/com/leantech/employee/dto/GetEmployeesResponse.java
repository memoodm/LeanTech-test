package co.com.leantech.employee.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class GetEmployeesResponse implements Serializable{
	
	private EmployeeDto employee;
	private PositionDto position;
	
}
