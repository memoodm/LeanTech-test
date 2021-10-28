package co.com.leantech.employee.dto;

import lombok.Data;

@Data
public class SetEmployeeDto {
	
	private EmployeeDto employee;
	private PositionDto position;
	
}
