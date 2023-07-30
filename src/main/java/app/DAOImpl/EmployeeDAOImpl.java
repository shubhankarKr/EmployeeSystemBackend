package app.DAOImpl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Repository;


import app.DAO.EmployeeDAO;
import app.DAO.GenericDAO;
import app.DAO.SkillDAO;
import app.entity.EmployeeEntity;
import app.entity.SkillEntity;
import app.exception.employee.EmployeeNotFoundException;
import app.model.CityDropdownDTO;
import app.model.EmployeeDTO;
import app.model.GeneralConstant;
import app.model.SkillDTO;
import app.model.entity.CityDropdown;
import jakarta.annotation.Resource;
import jakarta.persistence.EntityManager;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO{
	
	@Autowired
	EntityManager entityManager;
	
	@Resource
	SkillDAO skillDAO;
	
	@Autowired
	Environment environment;
	
	@Autowired
	GenericDAO genericDAO;
	
	Logger logger=LogManager.getLogger(this.getClass());

	@Override
	public String createEmployee(EmployeeDTO employeeDTO) {
		EmployeeEntity employeeEntity= employeeDTO.createEmployeeEntity(employeeDTO);
		entityManager.persist(employeeEntity);
		String url="http://"+environment.getProperty("HOST_NAME")+"/employee/getEmployeeById/"+employeeEntity.getId();
		employeeEntity.setUrl(url);
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
			throw new EmployeeNotFoundException(environment.getProperty("EMPLOYEE_NOT_FOUND"));
		}
	}

	@Override
	public List<EmployeeDTO> getEmployees() {
		// TODO Auto-generated method stub
		Query query= (Query) entityManager.createQuery("select e from EmployeeEntity e");
		List<EmployeeEntity> entities =  query.getResultList();
		List<EmployeeDTO> employees=new ArrayList<>();
		for (EmployeeEntity employeeEntity : entities) {
			employees.add(employeeEntity.createEmployeeDTO(employeeEntity));
//			String url="http://"+environment.getProperty("HOST_NAME")+"/employee/getEmployeeById/"+employeeEntity.getId();
//			employeeEntity.setUrl(url);
		}
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
			logger.error(e.getMessage());
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
//				employeeEntity.setCity(employeeDTO.getCity());
				employeeEntity.setFirstName(employeeDTO.getFirstName());
				employeeEntity.setLastName(employeeDTO.getLastName());
				employeeEntity.setPinCode(employeeDTO.getPinCode());
				employeeEntity.setStreet(employeeDTO.getStreet());
				employeeEntity.setGender(employeeDTO.getGender());
				employeeEntity.setDesignation(employeeDTO.getDesignation());
				skillDAO.deleteSkillForEmployee(employeeEntity.getId());
				List<SkillDTO> skillDTOs= skillDAO.addSkillForEmployee(employeeEntity.getId(), employeeDTO.getSkills());
				dto=employeeEntity.createEmployeeDTO(employeeEntity);
				dto.setSkills(skillDTOs);
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw new Exception(environment.getProperty("EMPLOYEE_NOT_FOUND"));
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
			logger.error(e.getMessage());
			throw new Exception(environment.getProperty("EMPLOYEE_NOT_FOUND"));
		}
		return true;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Set<EmployeeDTO> searchEmployee(String searchValue) throws Exception {
		Set<EmployeeEntity> entities=new HashSet<>();
		Set<EmployeeDTO> employeeDTOs=new HashSet<>();
		String s="select e from EmployeeEntity e where e.email like \":searchValue%\"";
		try {
			Query query=(Query) entityManager.createQuery("select e from EmployeeEntity e where e.email like '%"+searchValue+"%' "
					+"OR e.firstName like '%"+searchValue+"%'"
					+"OR e.city like '%"+searchValue+"%'"
					+"OR e.designation like '%"+searchValue+"%'"
					+"OR e.lastName like '%"+searchValue+"%'"
					);
			List<EmployeeEntity> list=(List<EmployeeEntity>) query.getResultList();
			for (EmployeeEntity employeeEntity : list) {
				entities.add(employeeEntity);
			}
			if(entities.size() == 0)
				throw new Exception(environment.getProperty("NO_RECORD_FOUND_WIHT_THE_GIVEN_SERCH_VALUE"));
			for (EmployeeEntity entity : entities) {
				employeeDTOs.add(entity.createEmployeeDTO(entity));
			}
			return employeeDTOs;
		} catch (Exception e) {
			logger.error(environment.getProperty(e.getMessage()));
			throw e;
		}
	}

	@Override
	public Boolean generateData(Short count) {
		genericDAO.addCities();
		List<CityDropdownDTO> cityDropdownDTOs= genericDAO.getAllCities();
		try {
			EmployeeEntity e= null;
			for (int i = 0; i < count; i++) {
				e=new EmployeeEntity();
				// set city
				
				CityDropdownDTO cityDTO= cityDropdownDTOs.get(new Random().nextInt(cityDropdownDTOs.size()));
				
				
//				e.setCity();
				e.setDesignation(randomStringFromArray(GeneralConstant.DESIGNATION_ARRAY));
				e.setEmail(randomString(20)+randomStringFromArray(GeneralConstant.MAIL_EXTENSTION));
				e.setGender(generateGender()+"");
				e.setPinCode(randomNumber(100000, 999999));
				e.setStreet(randomString(13));
				e.setCreationDateTime(LocalDateTime.now());
				setName(e);
				
				entityManager.persist(e);
//				CityDropdownDTO cityDTO= cityDropdownDTOs.get(new Random().nextInt(cityDropdownDTOs.size()));
				CityDropdown cityEntity=entityManager.find(CityDropdown.class, cityDTO.getCityId());
				e.setCity(cityEntity);
				String url="http://"+environment.getProperty("HOST_NAME")+"/employee/getEmployeeById/"+e.getId();
				e.setUrl(url);
				int skillCount=randomNumber(1, 5);
				int startingPoint=randomNumber(0, GeneralConstant.SKILL_ARRAY.length-1); 
					
				SkillEntity skillEntity=null;
				for (int j = startingPoint; j < (startingPoint + skillCount) ; j++) {
					if(j<GeneralConstant.SKILL_ARRAY.length) {
						skillEntity=new SkillEntity();
							skillEntity.setEmpId(e.getId());
							skillEntity.setSkillName(GeneralConstant.SKILL_ARRAY[j]);
							entityManager.persist(skillEntity);
					}
				}
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return null;
	}
	

	private void setName(EmployeeEntity e) {
		String[] name =GeneralConstant.NAME_ARRAY[new Random().nextInt(GeneralConstant.NAME_ARRAY.length)];
		if(name.length ==1) {
			e.setFirstName(name[0]);
		}
		else if(name.length>1) {
			e.setFirstName(name[0]);
			e.setLastName(name[1]);
		}
	}

	String randomString(int stringCount) {
		int leftLimit = 97; 
	    int rightLimit = 122;
	    Random random = new Random();

	    String generatedString = random.ints(leftLimit, rightLimit + 1)
	      .limit(stringCount)
	      .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
	      .toString();
	    
	    return generatedString;
	}
	
	int randomNumber(int min,int max) {
		return (int)Math.floor(Math.random() * (max - min + 1) + min);
	}
	
	String randomStringFromArray(String[] array) {
		return array[new Random().nextInt(array.length)];
	}
	
	char generateGender() {
		char[] charArray= {
				'M','F'
		};
		int randomIndex = (int) (Math.random() * charArray.length);  
		return charArray[randomIndex];
	}
}
