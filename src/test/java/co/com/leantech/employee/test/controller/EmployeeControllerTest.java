package co.com.leantech.employee.test.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.fasterxml.jackson.databind.ObjectMapper;

import co.com.leantech.employee.service.EmployeeServiceImpl;
import co.com.leantech.employee.test.objects.ObjectsDto;

@SpringBootTest
@AutoConfigureMockMvc
public class EmployeeControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	private ObjectMapper objectMapper;
	
	@MockBean
	private EmployeeServiceImpl service;
	
	@Test
	public void shouldReturnStatusOk() throws Exception {
		this.mockMvc.perform(get("/api/Check"))
				.andDo(print()).andExpect(status().isOk())
				.andExpect(content().string(containsString("Ok")));
	}
	
	@Test
	public void serviceGetAll() throws Exception {
		when(service.getAll(ObjectsDto.getEmployeeFilter())).thenReturn(ObjectsDto.getGetEmployeesResponse());
		MvcResult result = mockMvc.perform(get("/api")
				.content(objectMapper.writeValueAsString(ObjectsDto.getEmployeeFilter()))
			    .contentType("application/json"))
			    .andExpect(status().isOk())
			    .andReturn();
		String response = result.getResponse().getContentAsString();
		assertThat(response).isEqualToIgnoringWhitespace(
	              objectMapper.writeValueAsString(ObjectsDto.getGetEmployeesResponse()));
	}
	
	@Test
	public void serviceGetAllByPosition() throws Exception {
		when(service.getAllByPosition()).thenReturn(ObjectsDto.getGetEmployeesByPositionResponse());
		MvcResult result = mockMvc.perform(get("/api/byPosition")
				.content(objectMapper.writeValueAsString(ObjectsDto.getEmployeeFilter()))
			    .contentType("application/json"))
			    .andExpect(status().isOk())
			    .andReturn();
		String response = result.getResponse().getContentAsString();
		assertThat(response).isEqualToIgnoringWhitespace(
	              objectMapper.writeValueAsString(ObjectsDto.getGetEmployeesByPositionResponse()));
	}
	
	@Test
	public void serviceCreate() throws Exception {
		when(service.create(ObjectsDto.getSetEmployeeDto())).thenReturn(ObjectsDto.getGetEmployeesResponse().get(0));
		MvcResult result = mockMvc.perform(post("/api")
				.content(objectMapper.writeValueAsString(ObjectsDto.getSetEmployeeDto()))
			    .contentType("application/json"))
			    .andExpect(status().isOk())
			    .andReturn();
		String response = result.getResponse().getContentAsString();
		assertThat(response).isEqualToIgnoringWhitespace(
	              objectMapper.writeValueAsString(ObjectsDto.getGetEmployeesResponse().get(0)));
	}
	
	@Test
	public void serviceUpdate() throws Exception {
		when(service.update(ObjectsDto.getSetEmployeeDto())).thenReturn(ObjectsDto.getGetEmployeesResponse().get(0));
		MvcResult result = mockMvc.perform(put("/api")
				.content(objectMapper.writeValueAsString(ObjectsDto.getSetEmployeeDto()))
			    .contentType("application/json"))
			    .andExpect(status().isOk())
			    .andReturn();
		String response = result.getResponse().getContentAsString();
		assertThat(response).isEqualToIgnoringWhitespace(
	              objectMapper.writeValueAsString(ObjectsDto.getGetEmployeesResponse().get(0)));
	}
	
	@Test
	public void serviceDelete() throws Exception {
		mockMvc.perform(delete("/api/1")
			    .contentType("application/json"))
			    .andExpect(status().isOk());
	}
	
}
