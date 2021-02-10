package com.springboot.cruddemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.springboot.cruddemo.dto.EmployeeResponseDto;
import com.springboot.cruddemo.entity.Employee;
import com.springboot.cruddemo.repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	public void addEmployee(Employee employee) {
		employeeRepository.save(employee);
	}
	
	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}
	
	public Employee getEmployeeById(int id) {
		Optional<Employee> emp = employeeRepository.findById(id);
		
		if(emp.isPresent()) {
			return emp.get();
		}
		
		return null;
	}
	
	public String updateEmployee(int id,Employee employee) {
		Optional<Employee> emp = employeeRepository.findById(id);
		if(emp.isPresent()) {
			employeeRepository.save(employee);
			return "Employee Details Updated";
		}	
		else return "Employee Id not found";
	}
	
	public Employee getEmployeeByNameAndAge(String name,int age) {
		return employeeRepository.getEmployeeByNameAndAge(name, age);
	}
	
	public List<EmployeeResponseDto> getCustomEmployee(String name) {
		return employeeRepository.getCustomEmployee(name);
	}
	
	public Employee findEmployeeByNameAndAge(String name,int age) {
		return employeeRepository.findByNameAndAge(name, age);
	}
	
	public List<Employee> getEmployeeByNameOrAge(String name,int age) {
		return employeeRepository.findByNameOrAge(name, age);
	}
	
	public List<Employee> getEmployeeByNameContains(String name) {
		return employeeRepository.findByNameContains(name);
	}

	public void deleteEmployeeById(int id){
		employeeRepository.deleteById(id);
	}
}
