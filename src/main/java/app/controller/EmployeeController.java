package app.controller;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import app.exception.employee.EmployeeAlreadyExistsException;
import app.exception.employee.EmployeeNotFoundException;
import app.model.EmployeeDTO;
import app.model.response.SuccessResponse;
import app.service.EmployeeService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/employee")
@CrossOrigin(origins = "*",allowedHeaders = "*")
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;
	
	@PostMapping("/create" )
	public ResponseEntity<SuccessResponse> createEmployee(@Valid @RequestBody EmployeeDTO employee) throws EmployeeAlreadyExistsException{
		String response=employeeService.createEmployee(employee);
		SuccessResponse data=new SuccessResponse(HttpStatus.CREATED.value(), response);
		return new ResponseEntity<>(data,HttpStatus.CREATED);
		
	}
	
	@GetMapping("/getEmployeeById/{id}")
	public EmployeeDTO getEmployeeById(@PathVariable("id") Integer employeeId) throws EmployeeNotFoundException {
		return employeeService.getEmployeeById(employeeId);
	}
	
	@GetMapping("/getAllEmployee")
	public List<EmployeeDTO> getEmployees(){
		return employeeService.getEmployees();
	}
	
	@PutMapping("/update")
	public EmployeeDTO updateEmployee(@RequestBody EmployeeDTO employeeDTO) throws Exception{
		return employeeService.updateEmployee(employeeDTO);
	}
	
	@PostMapping(value="/login",produces = "application/json")
	public Map<String, Integer> loginEmployee(@RequestBody EmployeeDTO employeeDTO) {
		return employeeService.loginEmployee(employeeDTO.getEmail(),employeeDTO.getPassword());
	}
	
	@DeleteMapping("/delete/{email}")
	public ResponseEntity<SuccessResponse> deleteEmployee(@PathVariable String email) throws Exception{
		String response=employeeService.deleteEmployee(email);
		SuccessResponse data=new SuccessResponse(HttpStatus.OK.value(), response);
		return new ResponseEntity<>(data,HttpStatus.OK);
	}
	
	@GetMapping("/search/{searchValue}")
	public Set<EmployeeDTO> searchEmployee(@PathVariable String searchValue) throws Exception{
		return employeeService.searchEmployee(searchValue);
	}
}
