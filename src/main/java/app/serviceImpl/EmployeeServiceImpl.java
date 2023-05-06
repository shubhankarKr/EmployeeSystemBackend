package app.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.DAO.EmployeeDAO;
import app.model.EmployeeDTO;
import app.service.EmployeeService;
@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	EmployeeDAO employeeDAO;

	@Override
	public Integer createEmployee(EmployeeDTO employee) {
		return null;
	}

	@Override
	public EmployeeDTO getEmployee(Integer employeeId) {
		// TODO Auto-generated method stub
		return employeeDAO.getEmployee(employeeId);
	}

}
