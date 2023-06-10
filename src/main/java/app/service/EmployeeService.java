package app.service;


import java.util.List;
import java.util.Map;

import app.model.EmployeeDTO;

public interface EmployeeService {
	public EmployeeDTO createEmployee(EmployeeDTO employee);
	public EmployeeDTO getEmployee(Integer employeeId);
	public List<EmployeeDTO> getEmployees();
	public Map<String, Integer> loginEmployee(String email, String password);
	public Boolean deleteEmployee(EmployeeDTO employee);
	public EmployeeDTO updateEmployee(EmployeeDTO employee);
	public List<EmployeeDTO> searchEmployeeByName(String name);
}
