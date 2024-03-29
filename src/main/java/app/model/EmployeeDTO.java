package app.model;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

import app.entity.EmployeeEntity;
import app.model.entity.CityDropdown;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public class EmployeeDTO {
	private Integer id;
	@NotNull(message = "Please enter the first name")
	private String firstName;
	private String lastName;
	private String street;
	private Integer pinCode;
	@NotNull(message = "Please select gender")
	@Pattern(regexp =  "[MF]",message = "Gender should be either M or F")
	private String gender;
	@Email(message = "Please enter valid email")
	private String email;
	@NotNull(message = "Please enter password")
	private String password;
	private String designation;
	private List<SkillDTO> skills;
	private String url;
	private LocalDateTime creationDateTime;
	
	private CityDropdownDTO city;
	
	public LocalDateTime getCreationDateTime() {
		return creationDateTime;
	}


	public void setCreationDateTime(LocalDateTime creationDateTime) {
		this.creationDateTime = creationDateTime;
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


	public CityDropdownDTO getCity() {
		return city;
	}


	public void setCity(CityDropdownDTO city) {
		this.city = city;
	}


	public Integer getPinCode() {
		return pinCode;
	}


	public void setPinCode(Integer pinCode) {
		this.pinCode = pinCode;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
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
	
	public String getUrl() {
		return url;
	}


	public void setUrl(String url) {
		this.url = url;
	}

	public EmployeeEntity createEmployeeEntity(EmployeeDTO employeeDTO) {
		EmployeeEntity employeeEntity=null;
		if(employeeDTO != null) {
			employeeEntity=new EmployeeEntity();
//			employeeEntity.setCity(employeeDTO.getCity());
			employeeEntity.setFirstName(employeeDTO.getFirstName());
			employeeEntity.setLastName(employeeDTO.getLastName());
			employeeEntity.setPinCode(employeeDTO.getPinCode());
			employeeEntity.setStreet(employeeDTO.getStreet());
			employeeEntity.setGender(employeeDTO.gender);
			employeeEntity.setEmail(employeeDTO.getEmail());
			employeeEntity.setPassword(employeeDTO.getPassword());
			employeeEntity.setDesignation(employeeDTO.getDesignation());
		}
		return employeeEntity;
	}
}
