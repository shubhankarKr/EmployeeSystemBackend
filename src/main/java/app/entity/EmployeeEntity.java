package app.entity;


import java.util.ArrayList;
import java.util.List;

import app.model.EmployeeDTO;
import app.model.SkillDTO;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Employee")
public class EmployeeEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Integer id;

	@Column(name = "first_name")
	String firstName;

	@Column(name = "last_name")
	String lastName;
	String street;
	String city;

	@Column(name = "pin_code")
	Integer pinCode;
	
	Character gender;
	
	String email;
	
	String password;
	
	private String designation;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "emp_id")
	private List<SkillEntity> skill; 

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Character getGender() {
		return gender;
	}

	public void setGender(Character gender) {
		this.gender = gender;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Integer getPinCode() {
		return pinCode;
	}

	public void setPinCode(Integer pinCode) {
		this.pinCode = pinCode;
	}
	
	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}
	
	public List<SkillEntity> getSkill() {
		return skill;
	}

	public void setSkill(List<SkillEntity> skill) {
		this.skill = skill;
	}

	public EmployeeDTO createEmployeeDTO(EmployeeEntity employeeEntity) {
		EmployeeDTO employeeDTO = null;
		if (employeeEntity != null) {
			employeeDTO = new EmployeeDTO();
			employeeDTO.setCity(employeeEntity.getCity());
			employeeDTO.setFirstName(employeeEntity.getFirstName());
			employeeDTO.setId(employeeEntity.getId());
			employeeDTO.setLastName(employeeEntity.getLastName());
			employeeDTO.setPinCode(employeeEntity.getPinCode());
			employeeDTO.setStreet(employeeEntity.getStreet());
			employeeDTO.setGender(employeeEntity.getGender());
			employeeDTO.setEmail(employeeEntity.getEmail());
			employeeDTO.setPassword(employeeEntity.getPassword());
			employeeDTO.setDesignation(employeeEntity.getDesignation());
			List<SkillEntity> skillEntities =employeeEntity.getSkill();
			if (skillEntities != null) {
				List<SkillDTO> skillDTOs=new ArrayList<>();
				for (SkillEntity skillEntity : skillEntities) {
					SkillDTO skillDTO=new SkillDTO();
					skillDTO.setEmpId(skillEntity.getEmpId());
					skillDTO.setSkillName(skillEntity.getSkillName());
					skillDTOs.add(skillDTO);
				}
				employeeDTO.setSkills(skillDTOs);
			}
		}
		return employeeDTO;
	}
}
