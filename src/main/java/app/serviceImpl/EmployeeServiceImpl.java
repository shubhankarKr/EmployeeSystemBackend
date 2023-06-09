package app.serviceImpl;

import java.util.List;
import java.util.Map;

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
	public String createEmployee(EmployeeDTO employee) {
		if(employee.getFirstName() != null) {
			 employeeDAO.createEmployee(employee);
			 return "Employee inserted successfully";
		}
		return "Please enter first name";
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

	@Override
	public Map<String, Integer> loginEmployee(String email, String password) {
		// TODO Auto-generated method stub
		return employeeDAO.validateEmployee(email,password);
	}

	@Override
	public Boolean deleteEmployee(EmployeeDTO employee) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EmployeeDTO updateEmployee(EmployeeDTO employee) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<EmployeeDTO> searchEmployeeByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

}
