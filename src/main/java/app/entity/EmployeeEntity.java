package app.entity;

import app.model.EmployeeDTO;

public class EmployeeEntity {
	Integer id;
	String firstName;
	String lastName;
	String street;
	String city;
	Short pinCode;

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

	public Short getPinCode() {
		return pinCode;
	}

	public void setPinCode(Short pinCode) {
		this.pinCode = pinCode;
	}
	
	public EmployeeDTO createEmployeeDTO(EmployeeEntity employeeEntity) {
		EmployeeDTO employeeDTO=null;
		if(employeeEntity != null) {
			employeeDTO=new EmployeeDTO();
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
