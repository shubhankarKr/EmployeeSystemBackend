package app.DAOImpl;

import java.util.List;

import org.hibernate.query.Query;
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
		EmployeeEntity employeeEntity= employee.createEmployeeEntity(employee);
		entityManager.persist(employeeEntity);
		return employeeEntity.getId();
	}

	@Override
	public EmployeeDTO getEmployee(Integer employeeId) {
		EmployeeEntity employeeEntity = entityManager.find(EmployeeEntity.class, employeeId);
		return employeeEntity.createEmployeeDTO(employeeEntity);
	}

	@Override
	public List<EmployeeDTO> getEmployees() {
		// TODO Auto-generated method stub
		Query query= (Query) entityManager.createQuery("select e from EmployeeEntity e");
		List<EmployeeDTO> employees =  query.getResultList();
		return employees;
	}
	
}
