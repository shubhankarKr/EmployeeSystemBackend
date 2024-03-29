package app.entity;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import app.model.CityDropdownDTO;
import app.model.EmployeeDTO;
import app.model.SkillDTO;
import app.model.entity.CityDropdown;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "employee")
public class EmployeeEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Integer id;

	@Column(name = "first_name")
	String firstName;

	@Column(name = "last_name")
	String lastName;
	String street;

	@Column(name = "pin_code")
	Integer pinCode;
	
	String gender;
	
	String email;
	
	String password;
	
	private String designation;
	
	@Temporal(TemporalType.TIMESTAMP)
    LocalDateTime creationDateTime;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "emp_id")
	private List<SkillEntity> skill; 
	
	private String url;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="city_id")
	private CityDropdown city;
	
	public CityDropdown getCity() {
		return city;
	}

	public void setCity(CityDropdown city) {
		this.city = city;
	}

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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
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
	
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public LocalDateTime getCreationDateTime() {
		return creationDateTime;
	}

	public void setCreationDateTime(LocalDateTime creationDateTime) {
		this.creationDateTime = creationDateTime;
	}

	public EmployeeDTO createEmployeeDTO(EmployeeEntity employeeEntity) {
		EmployeeDTO employeeDTO = null;
		if (employeeEntity != null) {
			employeeDTO = new EmployeeDTO();
//			employeeDTO.setCity(employeeEntity.getCity());
			CityDropdown city=employeeEntity.getCity();
			if(city!=null) {
				CityDropdownDTO cityDto=new CityDropdownDTO();
				cityDto.setCityId(city.getCityId());
				cityDto.setCityName(city.getCityName());
				employeeDTO.setCity(cityDto);
			}
			employeeDTO.setFirstName(employeeEntity.getFirstName());
			employeeDTO.setId(employeeEntity.getId());
			employeeDTO.setLastName(employeeEntity.getLastName());
			employeeDTO.setPinCode(employeeEntity.getPinCode());
			employeeDTO.setStreet(employeeEntity.getStreet());
			employeeDTO.setGender(employeeEntity.getGender());
			employeeDTO.setEmail(employeeEntity.getEmail());
			employeeDTO.setPassword(employeeEntity.getPassword());
			employeeDTO.setDesignation(employeeEntity.getDesignation());
			employeeDTO.setUrl(employeeEntity.getUrl());
			employeeDTO.setCreationDateTime(employeeEntity.getCreationDateTime());
			List<SkillEntity> skillEntities =employeeEntity.getSkill();
			if (skillEntities != null) {
				List<SkillDTO> skillDTOs=new ArrayList<>();
				for (SkillEntity skillEntity : skillEntities) {
					SkillDTO skillDTO=new SkillDTO();
					skillDTO.setSkillId(skillEntity.getSkillId());
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
