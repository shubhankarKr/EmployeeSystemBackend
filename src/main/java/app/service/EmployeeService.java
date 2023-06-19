package app.service;


import java.util.List;
import java.util.Map;


import app.exception.employee.EmployeeAlreadyExistsException;
import app.exception.employee.EmployeeNotFoundException;
import app.model.EmployeeDTO;

public interface EmployeeService {
	public String createEmployee(EmployeeDTO employee) throws EmployeeAlreadyExistsException;
	public EmployeeDTO getEmployeeById(Integer employeeId) throws EmployeeNotFoundException ;
	public List<EmployeeDTO> getEmployees();
	public Map<String, Integer> loginEmployee(String email, String password);
	public String deleteEmployee(String email) throws Exception;;
	public EmployeeDTO updateEmployee(EmployeeDTO employee) throws Exception;
	public List<EmployeeDTO> searchEmployeeByName(String name);
}
