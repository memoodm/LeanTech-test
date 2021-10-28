package co.com.leantech.employee.persistence.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import co.com.leantech.employee.persistence.entity.Person;

public interface PersonRepository extends CrudRepository<Person,Long>{
	List<Person> findByName(String name);
}
