package app.serviceImpl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import app.DAO.EmployeeDAO;
import app.exception.employee.EmployeeAlreadyExistsException;
import app.model.EmployeeDTO;
import app.service.EmployeeService;
import jakarta.transaction.Transactional;
@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	EmployeeDAO employeeDAO;

	@Override
	public String createEmployee(EmployeeDTO employee) throws Exception {
		Boolean employeeInDB= employeeDAO.findEmployeeByEmail(employee.getEmail());
		if(employeeInDB ==true) {
			throw new EmployeeAlreadyExistsException("Employee already exists Please login!");
		}
		return employeeDAO.createEmployee(employee);
			
	}

	@Override
	public EmployeeDTO getEmployee(Integer employeeId){
		// TODO Auto-generated method stub
		return employeeDAO.getEmployee(employeeId);
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
