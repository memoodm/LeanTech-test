package co.com.leantech.employee.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class EmployeeDto implements Serializable{
	
	private Long id;
	private Double salary;
	private PersonDto person;
	
}
