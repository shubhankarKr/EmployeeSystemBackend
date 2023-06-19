package app.DAO;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import app.exception.employee.EmployeeNotFoundException;
import app.model.EmployeeDTO;

public interface EmployeeDAO {
	public String createEmployee(EmployeeDTO employee);
	public EmployeeDTO getEmployeeById(Integer employeeId) throws EmployeeNotFoundException;
	public List<EmployeeDTO> getEmployees();
	public Map<String, Integer> validateEmployee(String email, String password);
	public Boolean findEmployeeByEmail(String email);
	public String updateEmployee(EmployeeDTO employee) throws Exception;
}
