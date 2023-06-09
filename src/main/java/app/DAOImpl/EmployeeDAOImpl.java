package app.DAOImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

	@Override
	public Map<String, Integer> validateEmployee(String email, String password) {
		Map<String, Integer> outMap=new HashMap<String, Integer>();
		outMap.put("code", -1);
		String passFromDB=null;
		try {
			Query query= (Query) entityManager.createQuery("select e.password from EmployeeEntity e where e.email = :email");
			query.setParameter("email", email);
			passFromDB=(String) query.getSingleResult();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			passFromDB="unSuccessful";
		}
		if(passFromDB.equals(password)) {
			outMap.put("code",1);
		}
		return outMap;
	}
	
}
