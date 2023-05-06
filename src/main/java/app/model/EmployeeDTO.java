package app.model;

import app.entity.EmployeeEntity;

public class EmployeeDTO {
	Integer id;
	String firstName;
	String lastName;
	String street;
	String city;
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
		}
		return employeeEntity;
	}
}
