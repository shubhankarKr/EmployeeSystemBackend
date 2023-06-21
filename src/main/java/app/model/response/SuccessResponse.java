package app.model.response;

public class SuccessResponse {
	private Integer statusCode;
	private Object response;

	public Integer getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(Integer statusCode) {
		this.statusCode = statusCode;
	}

	public Object getResponse() {
		return response;
	}

	public void setResponse(Object response) {
		this.response = response;
	}

	public SuccessResponse(Integer statusCode, Object response) {
		super();
		this.statusCode = statusCode;
		this.response = response;
	}

}
