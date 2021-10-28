package co.com.leantech.employee;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import co.com.leantech.employee.service.EmployeeServiceImpl;

@SpringBootTest
class LeanTechEmployeeApplicationTests {

	@Autowired
	private EmployeeServiceImpl employeeService;
	
	@Test
	void contextLoads() {
		assertThat(employeeService).isNotNull();
	}

}
