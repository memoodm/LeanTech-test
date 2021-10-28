package co.com.leantech.employee.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class EmployeeFilter implements Serializable{
	
	private PositionEnum position;
	private String name;
	
	private Integer page;
	private Integer resultsByPage;
	
	public String getPosition() {
		return position != null && !position.getValue().isEmpty() ? position.getValue() : null;
	}
	
	public boolean haveValues() {
		return (position != null && !position.getValue().isEmpty()) 
			|| (name != null && !name.isBlank());
	}
	
}
