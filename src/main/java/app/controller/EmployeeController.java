package app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import app.model.EmployeeDTO;
import app.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;
	
	@PostMapping("/create")
	public Integer createEmployee(@RequestBody EmployeeDTO employee) {
		return employeeService.createEmployee(employee);
	}
	
	@GetMapping("/get/{id}")
	public EmployeeDTO getEmployee(@PathVariable("id") Integer employeeId) {
		return employeeService.getEmployee(employeeId);
	}
	
	@GetMapping("/get")
	public List<EmployeeDTO> getEmployees(){
		return employeeService.getEmployees();
	}
}
