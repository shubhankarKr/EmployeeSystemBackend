package app.serviceImpl;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
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
	
	@Autowired
	Environment environment;

	@Override
	public String createEmployee(EmployeeDTO employee) throws EmployeeAlreadyExistsException {
		Boolean employeeInDB= employeeDAO.findEmployeeByEmail(employee.getEmail());
		if(employeeInDB ==true) {
			throw new EmployeeAlreadyExistsException(environment.getProperty("EMPLOYEE_ALREADY_EXISTS"));
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
	public String deleteEmployee(String email) throws Exception {
		if(employeeDAO.deleteEmployee(email) == true) {
			return "Employee deleted successfully";
		}
		return null;
	}

	@Override
	public EmployeeDTO updateEmployee(EmployeeDTO employee) throws Exception{
		// TODO Auto-generated method stub
		return employeeDAO.updateEmployee(employee);
	}

	@Override
	public Set<EmployeeDTO> searchEmployee(String searchValue) throws Exception{
		// TODO Auto-generated method stub
		return employeeDAO.searchEmployee(searchValue);
	}

	@Override
	public Boolean generateData(Short count) {
		// TODO Auto-generated method stub
		employeeDAO.generateData(count);
		return null;
	}

}
