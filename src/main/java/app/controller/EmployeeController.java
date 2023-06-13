package app.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
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
@CrossOrigin(origins = "*",allowedHeaders = "*")
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;
	
	@PostMapping("/create")
	public EmployeeDTO createEmployee(@RequestBody EmployeeDTO employee) {
		return employeeService.createEmployee(employee);
	}
	
	@GetMapping("/getEmployeeById/{id}")
	public EmployeeDTO getEmployee(@PathVariable("id") Integer employeeId) {
		return employeeService.getEmployee(employeeId);
	}
	
	@GetMapping("/getAllEmployee")
	public List<EmployeeDTO> getEmployees(){
		return employeeService.getEmployees();
	}
	
	@PostMapping(value="/login",produces = "application/json")
	public Map<String, Integer> loginEmployee(@RequestBody EmployeeDTO employeeDTO) {
		return employeeService.loginEmployee(employeeDTO.getEmail(),employeeDTO.getPassword());
	}
}
