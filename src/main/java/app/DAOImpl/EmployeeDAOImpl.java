package app.DAOImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import app.DAO.EmployeeDAO;
import app.entity.EmployeeEntity;
import app.model.EmployeeDTO;
import jakarta.persistence.EntityManager;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO{
	
	@Autowired
	EntityManager entityManager;

	@Override
	public Integer createEmployee(EmployeeDTO employee) {
		return null;
	}

	@Override
	public EmployeeDTO getEmployee(Integer employeeId) {
		EmployeeEntity employeeEntity = entityManager.find(EmployeeEntity.class, employeeId);
		return employeeEntity.createEmployeeDTO(employeeEntity);
	}
	
}
