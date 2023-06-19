package app.exception.employee;

public class EmployeeAlreadyExistsException extends Exception {
	private static final long serialVersionUID = 1L;
	private String message;
	public EmployeeAlreadyExistsException(String message) {
		super(message);
		this.message=message;
	}
}
