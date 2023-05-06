package app.service;


import java.util.List;

import app.model.EmployeeDTO;

public interface EmployeeService {
	public Integer createEmployee(EmployeeDTO employee);
	public EmployeeDTO getEmployee(Integer employeeId);
	public List<EmployeeDTO> getEmployees();
}
