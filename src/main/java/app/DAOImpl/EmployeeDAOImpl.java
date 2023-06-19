package app.DAOImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import app.DAO.EmployeeDAO;
import app.DAO.SkillDAO;
import app.entity.EmployeeEntity;
import app.entity.SkillEntity;
import app.exception.employee.EmployeeNotFoundException;
import app.model.EmployeeDTO;
import app.model.SkillDTO;
import jakarta.annotation.Resource;
import jakarta.persistence.EntityManager;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO{
	
	@Autowired
	EntityManager entityManager;
	
	@Resource
	SkillDAO skillDAO;

	@Override
	public String createEmployee(EmployeeDTO employeeDTO) {
		EmployeeEntity employeeEntity= employeeDTO.createEmployeeEntity(employeeDTO);
		entityManager.persist(employeeEntity);
		List<SkillDTO> skillDTOs=  employeeDTO.getSkills();
		if(skillDTOs !=null ) {
			SkillEntity skillEntity=null;
			for (SkillDTO skill : skillDTOs) {
				skillEntity=new SkillEntity();
				skillEntity.setEmpId(employeeEntity.getId());
				skillEntity.setSkillName(skill.getSkillName());
				entityManager.persist(skillEntity);
			}
		}
		return "Employee created successfully with ID: "+employeeEntity.getId();
	}

	@Override
	public EmployeeDTO getEmployeeById(Integer employeeId) throws EmployeeNotFoundException {
		try {
			EmployeeEntity employeeEntity = entityManager.find(EmployeeEntity.class, employeeId);
			return employeeEntity.createEmployeeDTO(employeeEntity);
		} catch (Exception e) {
			throw new EmployeeNotFoundException("Employee does not exist");
		}
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

	@Override
	public Boolean findEmployeeByEmail(String email) {		
		try {
			Query query= (Query) entityManager.createQuery("select e from EmployeeEntity e where e.email = :email");
			query.setParameter("email", email);
			EmployeeEntity employeeEntity=(EmployeeEntity) query.getSingleResult();
			if(employeeEntity != null) {
				return true;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return false;		
	}

	@Override
	public EmployeeDTO updateEmployee(EmployeeDTO employeeDTO) throws Exception {
		EmployeeDTO dto=null;
		try {
			String email=employeeDTO.getEmail();
			Query query= (Query) entityManager.createQuery("select e from EmployeeEntity e where e.email = :email");
			query.setParameter("email", email);
			EmployeeEntity employeeEntity=(EmployeeEntity) query.getSingleResult();
			if(employeeEntity != null) {
				employeeEntity.setCity(employeeDTO.getCity());
				employeeEntity.setFirstName(employeeDTO.getFirstName());
				employeeEntity.setLastName(employeeDTO.getLastName());
				employeeEntity.setPinCode(employeeDTO.getPinCode());
				employeeEntity.setStreet(employeeDTO.getStreet());
				employeeEntity.setGender(employeeDTO.getGender());
				employeeEntity.setDesignation(employeeDTO.getDesignation());
				skillDAO.updateSkillForEmployee(employeeEntity.getId(), employeeDTO.getSkills());
				dto=employeeEntity.createEmployeeDTO(employeeEntity);
			}
		} catch (Exception e) {
			throw new Exception("EMPLOYEE_NOT_FOUND");
		}
		return dto;
	}

	@Override
	public Boolean deleteEmployee(String email) throws Exception {
		try {
			Query query= (Query) entityManager.createQuery("select e from EmployeeEntity e where e.email = :email");
			query.setParameter("email", email);
			EmployeeEntity employeeEntity=(EmployeeEntity) query.getSingleResult();
			if(employeeEntity!=null) {
				entityManager.remove(employeeEntity);
			}
		} catch (Exception e) {
			throw new Exception("EMPLOYEE_NOT_FOUND");
		}
		return true;
	}
}
