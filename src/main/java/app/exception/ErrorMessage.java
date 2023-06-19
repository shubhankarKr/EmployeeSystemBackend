package app.exception;

import java.time.LocalDateTime;

public class ErrorMessage{
	private Integer statusCode;
	private String message;
	private LocalDateTime date;
	public ErrorMessage(Integer statusCode, String message, LocalDateTime date) {
		this.statusCode = statusCode;
		this.message = message;
		this.date = date;
	}
	public Integer getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(Integer statusCode) {
		this.statusCode = statusCode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public LocalDateTime getDate() {
		return date;
	}
	public void setDate(LocalDateTime date) {
		this.date = date;
	}
}
