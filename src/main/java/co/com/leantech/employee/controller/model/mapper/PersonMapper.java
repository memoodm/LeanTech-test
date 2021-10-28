package co.com.leantech.employee.controller.model.mapper;

import java.util.List;
import java.util.stream.Collectors;

import co.com.leantech.employee.dto.PersonDto;
import co.com.leantech.employee.persistence.entity.Person;

public class PersonMapper {

	public static PersonDto toDto(Person entity) {
		PersonDto dto = new PersonDto();
		dto.setName(entity.getName());
		dto.setLastNam2(entity.getLastName());
		dto.setCityName(entity.getCityName());
		dto.setAddress(entity.getAddress());
		dto.setCellphone(entity.getCellphone());
		return dto;
	}
	
	public static Person toEntity(PersonDto dto) {
		Person person = new Person();
		person.setName(dto.getName());
		person.setLastName(dto.getLastNam2());
		person.setAddress(dto.getAddress());
		person.setCityName(dto.getCityName());
		person.setCellphone(dto.getCellphone());
		return person;
	}
	
	public static List<PersonDto> toDtoList(List<Person> entities){
		return entities.stream().map(e->toDto(e)).collect(Collectors.toList());
	}
}
