package co.com.leantech.employee.persistence.repository;

import org.springframework.data.repository.CrudRepository;

import co.com.leantech.employee.persistence.entity.Position;

public interface PositionRepository extends CrudRepository<Position,Integer>{
	Position findByName(String name);
}
