package app.model.response;

import java.time.LocalDateTime;

public class ErrorResponse{
	private Integer statusCode;
	private String error;
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
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	public ErrorResponse(Integer statusCode, String error, LocalDateTime date) {
		super();
		this.statusCode = statusCode;
		this.error = error;
		this.date = date;
	}
}
