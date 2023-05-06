package app.DAO;

import java.util.List;

import org.springframework.stereotype.Repository;

import app.model.EmployeeDTO;

public interface EmployeeDAO {
	public Integer createEmployee(EmployeeDTO employee);
	public EmployeeDTO getEmployee(Integer employeeId);
	public List<EmployeeDTO> getEmployees();
}
