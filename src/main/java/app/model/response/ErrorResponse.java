package app.model.response;

import java.time.LocalDateTime;

public class ErrorResponse{
	private Integer statusCode;
	private Object errorResponse;
	private Object argumentNotValidError;
	private LocalDateTime date;
	public Integer getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(Integer statusCode) {
		this.statusCode = statusCode;
	}
	public Object getErrorResponse() {
		return errorResponse;
	}
	public void setErrorResponse(Object errorResponse) {
		this.errorResponse = errorResponse;
	}
	public Object getArgumentNotValidError() {
		return argumentNotValidError;
	}
	public void setArgumentNotValidError(Object argumentNotValidError) {
		this.argumentNotValidError = argumentNotValidError;
	}
	public LocalDateTime getDate() {
		return date;
	}
	public void setDate(LocalDateTime date) {
		this.date = date;
	}
	public ErrorResponse(Integer statusCode, Object errorResponse, Object argumentNotValidError, LocalDateTime date) {
		super();
		this.statusCode = statusCode;
		this.errorResponse = errorResponse;
		this.argumentNotValidError = argumentNotValidError;
		this.date = date;
	}
}
