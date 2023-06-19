package app.serviceImpl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import app.DAO.EmployeeDAO;
import app.exception.employee.EmployeeAlreadyExistsException;
import app.exception.employee.EmployeeNotFoundException;
import app.model.EmployeeDTO;
import app.service.EmployeeService;
import jakarta.transaction.Transactional;
@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	EmployeeDAO employeeDAO;

	@Override
	public String createEmployee(EmployeeDTO employee) throws EmployeeAlreadyExistsException {
		Boolean employeeInDB= employeeDAO.findEmployeeByEmail(employee.getEmail());
		if(employeeInDB ==true) {
			throw new EmployeeAlreadyExistsException("Employee already exists Please login!");
		}
		return employeeDAO.createEmployee(employee);
			
	}

	@Override
	public EmployeeDTO getEmployeeById(Integer employeeId) throws EmployeeNotFoundException{
		// TODO Auto-generated method stub
		return employeeDAO.getEmployeeById(employeeId);
	}

	@Override
	public List<EmployeeDTO> getEmployees(){
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
	public String updateEmployee(EmployeeDTO employee) throws Exception{
		// TODO Auto-generated method stub
		return employeeDAO.updateEmployee(employee);
	}

	@Override
	public List<EmployeeDTO> searchEmployeeByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

}
