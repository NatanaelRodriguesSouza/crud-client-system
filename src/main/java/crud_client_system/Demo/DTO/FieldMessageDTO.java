package crud_client_system.Demo.DTO;

public class FieldMessageDTO {
	private String FieldMessage;
	private String message;
	public FieldMessageDTO(String fieldMessage, String message) {
		super();
		FieldMessage = fieldMessage;
		this.message = message;
	}
	public String getFieldMessage() {
		return FieldMessage;
	}
	public void setFieldMessage(String fieldMessage) {
		FieldMessage = fieldMessage;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
}
