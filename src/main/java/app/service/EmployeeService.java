package app.service;


import app.model.EmployeeDTO;

public interface EmployeeService {
	public Integer createEmployee(EmployeeDTO employee);
	public EmployeeDTO getEmployee(Integer employeeId);
}
