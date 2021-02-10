package com.springboot.cruddemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.cruddemo.dto.EmployeeResponseDto;
import com.springboot.cruddemo.entity.Employee;
import com.springboot.cruddemo.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@PostMapping("")
	public void addEmployee(@RequestBody Employee employee){
		employeeService.addEmployee(employee);
	}
	
	@GetMapping("/all")
	public List<Employee> getAllEmployees(){
		return employeeService.getAllEmployees();
	}
	
	@GetMapping("/{id}")
	public Employee getEmployeeById(@PathVariable int id){
		return employeeService.getEmployeeById(id);
	}
	
	@PutMapping("/{id}")
	public String updateEmployee(@PathVariable int id, @RequestBody Employee employee){
		return employeeService.updateEmployee(id,employee);
	}
		
	@GetMapping("/getEmployeeByNameAndAge")
	public Employee getEmployeeByNameAndAge(@RequestParam String name, @RequestParam int age) {
		return employeeService.getEmployeeByNameAndAge(name, age);
	}
	
	@GetMapping("/findEmployeeByNameOrAge")
	public List<Employee> getEmployeeByNameOrAge(@RequestParam String name, @RequestParam int age) {
		return employeeService.getEmployeeByNameOrAge(name, age);
	}
	
	@GetMapping("/findEmployeeByNameContains")
	public List<Employee> getEmployeeByNameContains(@RequestParam String name) {
		return employeeService.getEmployeeByNameContains(name);
	}
	
	@GetMapping("/getCustomEmployee")
	public List<EmployeeResponseDto> getCustomEmployee(@RequestParam String name) {
		return employeeService.getCustomEmployee(name);
	}
	
	@DeleteMapping("/{id}")
	public void deleteEmployeeById(@PathVariable int id){
		employeeService.deleteEmployeeById(id);		
	}
	
	
}
