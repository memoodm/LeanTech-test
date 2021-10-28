package co.com.leantech.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.leantech.employee.dto.EmployeeFilter;
import co.com.leantech.employee.dto.GetEmployeesByPositionResponse;
import co.com.leantech.employee.dto.GetEmployeesResponse;
import co.com.leantech.employee.dto.SetEmployeeDto;
import co.com.leantech.employee.service.EmployeeServiceImpl;

@RestController()
@RequestMapping("/api")
public class EmployeeController {
	
	@Autowired
	private EmployeeServiceImpl employeeService;

	@GetMapping("Check")
	public String check() {
		return "Ok";
	}
	
	@GetMapping()
	public ResponseEntity<List<GetEmployeesResponse>> getAll(@RequestBody EmployeeFilter employeeFilter){
		List<GetEmployeesResponse> response = employeeService.getAll(employeeFilter);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@GetMapping("/byPosition")
	public ResponseEntity<List<GetEmployeesByPositionResponse>> getAllByPosition(){
		List<GetEmployeesByPositionResponse> response = employeeService.getAllByPosition();
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@PostMapping()
	public ResponseEntity<GetEmployeesResponse> create(@RequestBody SetEmployeeDto setEmployeeDto){
		GetEmployeesResponse response = employeeService.create(setEmployeeDto);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@PutMapping()
	public ResponseEntity<GetEmployeesResponse> update(@RequestBody SetEmployeeDto setEmployeeDto){
		GetEmployeesResponse response = employeeService.update(setEmployeeDto);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@DeleteMapping("/{employeeId}")
	public ResponseEntity<?> delete(@PathVariable Long employeeId){
		employeeService.delete(employeeId);
		return new ResponseEntity<>(null, HttpStatus.OK);
	}
	
}
