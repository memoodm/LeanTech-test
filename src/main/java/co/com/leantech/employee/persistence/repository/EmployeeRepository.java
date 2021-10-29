package co.com.leantech.employee.persistence.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import co.com.leantech.employee.persistence.entity.Employee;
import co.com.leantech.employee.persistence.entity.Position;

public interface EmployeeRepository extends PagingAndSortingRepository<Employee, Long>{
	List<Employee> findAllByPositionOrPersonNameIgnoreCase(Position position,String person,Pageable pageable);
	List<Employee> findAllByPositionOrderBySalaryDesc(Position position);
}
