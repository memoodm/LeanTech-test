package co.com.leantech.employee.persistence.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "employee")
public @Data class Employee {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "salary")
	private Double salary;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "person_id", referencedColumnName = "id")
	private Person person;
	
	@ManyToOne()
    @JoinColumn(name = "position_id", referencedColumnName = "id")
	private Position position;
	
	public void updateValues(Employee employee) {
		this.salary = employee.getSalary();
		this.person.updateValues(employee.getPerson());
	}
}
