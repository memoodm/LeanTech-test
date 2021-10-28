package co.com.leantech.employee.persistence.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "person")
public @Data class Person {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "cellphone")
	private String cellphone;
	
	@Column(name = "city_name")
	private String cityName;
	
	public void updateValues(Person person) {
		this.name = person.getName();
		this.lastName = person.getLastName();
		this.address = person.getAddress();
		this.cellphone = person.getCellphone();
		this.cityName = person.getCityName();
	}
	
}
