package app.model;

import java.util.ArrayList;
import java.util.List;

import app.entity.EmployeeEntity;
import app.entity.SkillEntity;

public class EmployeeDTO {
	private Integer id;
	private String firstName;
	private String lastName;
	private String street;
	private String city;
	private Integer pinCode;
	private Character gender;
	private String email;
	private String password;
	private String designation;
	private List<SkillDTO> skills;

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


	public Character getGender() {
		return gender;
	}


	public void setGender(Character gender) {
		this.gender = gender;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getDesignation() {
		return designation;
	}


	public void setDesignation(String designation) {
		this.designation = designation;
	}


	public List<SkillDTO> getSkills() {
		return skills;
	}


	public void setSkills(List<SkillDTO> skills) {
		this.skills = skills;
	}


	public EmployeeEntity createEmployeeEntity(EmployeeDTO employeeDTO) {
		EmployeeEntity employeeEntity=null;
		if(employeeDTO != null) {
			employeeEntity=new EmployeeEntity();
			employeeEntity.setCity(employeeDTO.getCity());
			employeeEntity.setFirstName(employeeDTO.getFirstName());
			employeeEntity.setId(employeeDTO.getId());
			employeeEntity.setLastName(employeeDTO.getLastName());
			employeeEntity.setPinCode(employeeDTO.getPinCode());
			employeeEntity.setStreet(employeeDTO.getStreet());
			employeeEntity.setGender(employeeDTO.gender);
			employeeEntity.setEmail(employeeDTO.getEmail());
			employeeEntity.setPassword(employeeDTO.getPassword());
			employeeEntity.setDesignation(employeeDTO.getDesignation());
			List<SkillDTO> skillDTOs=employeeDTO.getSkills();
			if(skillDTOs != null) {
				List<SkillEntity> skillEntities=new ArrayList<>();
				for (SkillDTO skillDTO : skillDTOs) {
					SkillEntity skillEntity=new SkillEntity();
					skillEntity.setEmpId(skillDTO.getEmpId());
					skillEntity.setSkillName(skillDTO.getSkillName());
					skillEntities.add(skillEntity);
				}
				employeeEntity.setSkill(skillEntities);
			}
		}
		return employeeEntity;
	}
}
