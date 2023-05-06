package app.DAO;

import org.springframework.stereotype.Repository;

import app.model.EmployeeDTO;

@Repository
public interface EmployeeDAO {
	public Integer createEmployee(EmployeeDTO employee);
	public Integer getEmployee(Integer employeeId);
}
