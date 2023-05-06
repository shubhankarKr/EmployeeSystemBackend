package app.entity;

import app.model.EmployeeDTO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Employee")
public class EmployeeEntity {

	@Id
	Integer id;

	@Column(name = "first_name")
	String firstName;

	@Column(name = "last_name")
	String lastName;
	String street;
	String city;

	@Column(name = "pin_code")
	Integer pinCode;

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
		}
		return employeeDTO;
	}
}
