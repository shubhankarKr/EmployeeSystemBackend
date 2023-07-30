package app.DAO;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Repository;

import app.exception.employee.EmployeeNotFoundException;
import app.model.EmployeeDTO;

public interface EmployeeDAO {
	public String createEmployee(EmployeeDTO employee);
	public EmployeeDTO getEmployeeById(Integer employeeId) throws EmployeeNotFoundException;
	public List<EmployeeDTO> getEmployees();
	public Map<String, Integer> validateEmployee(String email, String password);
	public Boolean findEmployeeByEmail(String email);
	public EmployeeDTO updateEmployee(EmployeeDTO employee) throws Exception;
	public Boolean deleteEmployee(String email) throws Exception;
	public Set<EmployeeDTO> searchEmployee(String searchValue) throws Exception;
	public Boolean generateData(Short count);
}
