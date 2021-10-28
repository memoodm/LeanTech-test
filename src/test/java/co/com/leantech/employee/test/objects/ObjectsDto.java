package co.com.leantech.employee.test.objects;

import java.util.ArrayList;
import java.util.List;

import co.com.leantech.employee.dto.EmployeeDto;
import co.com.leantech.employee.dto.EmployeeFilter;
import co.com.leantech.employee.dto.GetEmployeesByPositionResponse;
import co.com.leantech.employee.dto.GetEmployeesResponse;
import co.com.leantech.employee.dto.PersonDto;
import co.com.leantech.employee.dto.PositionDto;
import co.com.leantech.employee.dto.PositionEnum;
import co.com.leantech.employee.dto.SetEmployeeDto;
import co.com.leantech.employee.persistence.entity.Employee;
import co.com.leantech.employee.persistence.entity.Person;
import co.com.leantech.employee.persistence.entity.Position;

public class ObjectsDto {

	public static EmployeeFilter getEmployeeFilter() {
		EmployeeFilter employeeFilter = new EmployeeFilter();
		employeeFilter.setName(null);
		employeeFilter.setPosition(null);
		employeeFilter.setPage(0);
		employeeFilter.setResultsByPage(100);
		return employeeFilter;
	}
	
	public static List<GetEmployeesResponse> getGetEmployeesResponse(){
		List<GetEmployeesResponse> response = new ArrayList<>();
		GetEmployeesResponse element = new GetEmployeesResponse();
		PersonDto person = new PersonDto();
		person.setName("Mario");
		person.setLastNam2("Bross");
		person.setCityName("Bogota");
		person.setCellphone("3002003040");
		person.setAddress("av calle 127 #17-4 c");
		EmployeeDto employee = new EmployeeDto();
		employee.setId(1L);
		employee.setSalary(999D);
		employee.setPerson(person);
		PositionDto position = new PositionDto();
		position.setId(1);
		position.setName(PositionEnum.DEVELOPER);
		element.setEmployee(employee);
		element.setPosition(position);
		response.add(element);
		return response;
	}
	
	public static List<GetEmployeesByPositionResponse> getGetEmployeesByPositionResponse(){
		List<GetEmployeesByPositionResponse> response = new ArrayList<>();
		GetEmployeesByPositionResponse element = new GetEmployeesByPositionResponse();
		List<EmployeeDto> employees = new ArrayList<>();
		PersonDto person = new PersonDto();
		person.setName("Mario");
		person.setLastNam2("Bross");
		person.setCityName("Bogota");
		person.setCellphone("3002003040");
		person.setAddress("av calle 127 #17-4 c");
		EmployeeDto employee = new EmployeeDto();
		employee.setId(1L);
		employee.setSalary(999D);
		employee.setPerson(person);
		employees.add(employee);
		element.setId(1);
		element.setName("DEVELOPER");
		element.setEmployees(employees);
		response.add(element);
		return response;
	}
	
	public static SetEmployeeDto getSetEmployeeDto() {
		SetEmployeeDto dto = new SetEmployeeDto();
		PersonDto person = new PersonDto();
		person.setName("Mario");
		person.setLastNam2("Bross");
		person.setCityName("Bogota");
		person.setCellphone("3002003040");
		person.setAddress("av calle 127 #17-4 c");
		EmployeeDto employee = new EmployeeDto();
		employee.setId(1L);
		employee.setSalary(999D);
		employee.setPerson(person);
		PositionDto position = new PositionDto();
		position.setId(1);
		position.setName(PositionEnum.DEVELOPER);
		dto.setEmployee(employee);
		dto.setPosition(position);
		return dto;
	}
	
	public static Position getPositionEntity() {
		Position position = new Position();
		position.setId(1);
		position.setName("DEVELOPER");
		return position;
	}
	
	public static Employee getEmployeeEntity() {
		Person person = new Person();
		person.setId(1L);
		person.setName("Mario");
		person.setLastName("Bross");
		person.setCellphone("3002003040");
		person.setCityName("bogota");
		person.setAddress("Av calle 1");
		Employee employee = new Employee();
		employee.setId(1L);
		employee.setSalary(999D);
		employee.setPerson(person);
		return employee;
	}
	
	public static List<Employee> getEmployeesListEntity() {
		List<Employee> entities = new ArrayList<>();
		entities.add(getEmployeeEntity());
		return entities;
	}
}
