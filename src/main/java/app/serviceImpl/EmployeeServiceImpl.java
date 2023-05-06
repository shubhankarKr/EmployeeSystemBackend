package app.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.DAO.EmployeeDAO;
import app.model.EmployeeDTO;
import app.service.EmployeeService;
import jakarta.transaction.Transactional;
@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	EmployeeDAO employeeDAO;

	@Override
	public Integer createEmployee(EmployeeDTO employee) {
		return employeeDAO.createEmployee(employee);
	}

	@Override
	public EmployeeDTO getEmployee(Integer employeeId) {
		// TODO Auto-generated method stub
		return employeeDAO.getEmployee(employeeId);
	}

	@Override
	public List<EmployeeDTO> getEmployees() {
		// TODO Auto-generated method stub
		return employeeDAO.getEmployees();
	}

}
