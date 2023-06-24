package app.model.response;

import java.time.LocalDateTime;

public class ErrorResponse{
	private Integer statusCode;
	private Object error;
	private Object argumentNotValidError;
	private LocalDateTime date;
	public Integer getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(Integer statusCode) {
		this.statusCode = statusCode;
	}
	public LocalDateTime getDate() {
		return date;
	}
	public void setDate(LocalDateTime date) {
		this.date = date;
	}
	public Object getError() {
		return error;
	}
	public void setError(Object error) {
		this.error = error;
	}
	public Object getArgumentNotValidError() {
		return argumentNotValidError;
	}
	public void setArgumentNotValidError(Object argumentNotValidError) {
		this.argumentNotValidError = argumentNotValidError;
	}
	public ErrorResponse(Integer statusCode, Object error, Object argumentNotValidError, LocalDateTime date) {
		super();
		this.statusCode = statusCode;
		this.error = error;
		this.argumentNotValidError = argumentNotValidError;
		this.date = date;
	}
	
	
}
