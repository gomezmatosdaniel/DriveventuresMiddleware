package DBCUtils;

public class BusinessException extends DriveventuresException {
	
	public BusinessException() {
		super();
	}
	
	public BusinessException(String message) {
		this(message,null);		
	}
	

	public BusinessException(Throwable cause) {
		this(null,cause);		
	}
	
	public BusinessException(String message, Throwable cause) {
		super(message,cause);		
	}
}
