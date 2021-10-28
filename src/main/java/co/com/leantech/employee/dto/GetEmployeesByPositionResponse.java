package co.com.leantech.employee.dto;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

@Data
public class GetEmployeesByPositionResponse implements Serializable{
	
	private Integer id;
	private String name;
	private List<EmployeeDto> employees;
	
}
