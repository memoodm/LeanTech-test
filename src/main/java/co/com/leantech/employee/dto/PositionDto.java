package co.com.leantech.employee.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class PositionDto implements Serializable{
	
	private Integer id;
	private PositionEnum name;

}
