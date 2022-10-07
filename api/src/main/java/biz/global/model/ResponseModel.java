package biz.global.model;

public class ResponseModel {
	private int status;
	private String message;
	private String token;
	private Object object;
	
	public ResponseModel() {
		
	}
	
	public ResponseModel(int status, String message, String token, Object object) {
		this.status = status;
		this.message = message;
		this.token = token;
		this.object = object;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public Object getObject() {
		return object;
	}
	public void setObject(Object object) {
		this.object = object;
	}

}
