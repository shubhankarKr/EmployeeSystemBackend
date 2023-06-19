package app.exception.employee;

public class EmployeeAlreadyExistsException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4190197375080611070L;

	public EmployeeAlreadyExistsException(String message) {
		super(message);
	}
}
