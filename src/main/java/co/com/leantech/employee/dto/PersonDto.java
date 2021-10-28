package co.com.leantech.employee.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class PersonDto implements Serializable{
	private String name;
	private String lastNam2;
	private String address;
	private String cellphone;
	private	String cityName;
}
