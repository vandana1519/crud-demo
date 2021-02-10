package com.springboot.cruddemo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.springboot.cruddemo.dto.EmployeeResponseDto;
import com.springboot.cruddemo.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository <Employee, Integer>{
	
	Employee findByNameAndAge(@Param("name") String name, @Param("age") int age);
	
	List<Employee> findByNameOrAge(String name, int age);
	
	List<Employee> findByNameContains(String name);
	
	@Query("from Employee where name =:name and age=:age")
	public Employee getEmployeeByNameAndAge(@Param("name") String name, @Param("age") int age);
	
	
	@Query("select new com.springboot.cruddemo.dto.EmployeeResponseDto(name, count(*)) from Employee where name=:name")
	List<EmployeeResponseDto> getCustomEmployee(@Param("name") String name);

	
	
	
}
