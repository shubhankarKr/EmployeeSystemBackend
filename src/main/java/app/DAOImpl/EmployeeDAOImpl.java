package app.DAOImpl;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import app.DAO.EmployeeDAO;
import app.entity.EmployeeEntity;
import app.entity.SkillEntity;
import app.model.EmployeeDTO;
import app.model.SkillDTO;
import jakarta.persistence.EntityManager;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO{
	
	@Autowired
	EntityManager entityManager;

	@Override
	public EmployeeDTO createEmployee(EmployeeDTO employeeDTO) {
		EmployeeEntity employeeEntity= null;
		
		employeeEntity=new EmployeeEntity();
		employeeEntity.setCity(employeeDTO.getCity());
		employeeEntity.setFirstName(employeeDTO.getFirstName());
		employeeEntity.setId(employeeDTO.getId());
		employeeEntity.setLastName(employeeDTO.getLastName());
		employeeEntity.setPinCode(employeeDTO.getPinCode());
		employeeEntity.setStreet(employeeDTO.getStreet());
		employeeEntity.setGender(employeeDTO.getGender());
		employeeEntity.setEmail(employeeDTO.getEmail());
		employeeEntity.setPassword(employeeDTO.getPassword());
		employeeEntity.setDesignation(employeeDTO.getDesignation());
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
//		employeeEntity.setSkill((List<SkillEntity>) entityManager.find(SkillEntity.class, employeeEntity.getId()));
		return employeeEntity.createEmployeeDTO(employeeEntity);
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
