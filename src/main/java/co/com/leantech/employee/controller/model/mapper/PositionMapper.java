package co.com.leantech.employee.controller.model.mapper;

import java.util.List;
import java.util.stream.Collectors;

import co.com.leantech.employee.dto.PositionDto;
import co.com.leantech.employee.dto.PositionEnum;
import co.com.leantech.employee.persistence.entity.Position;

public class PositionMapper {
	
	public static PositionDto toDto(Position entity) {
		PositionDto dto = new PositionDto();
		dto.setId(entity.getId());
		dto.setName(PositionEnum.internalValue(entity.getName()));
		return dto;
	}
	
	public static List<PositionDto> toDtoList(List<Position> entities){
		return entities.stream().map(e->toDto(e)).collect(Collectors.toList());
	}
	
}
