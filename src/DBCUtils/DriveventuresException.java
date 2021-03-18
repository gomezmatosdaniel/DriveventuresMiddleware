package DBCUtils;

import java.io.PrintStream;
import java.io.PrintWriter;

public class DriveventuresException extends Exception {
	
	private String errorCode = null;
	
	public DriveventuresException() {
		super();
	}
	
	public DriveventuresException(String message) {
		this(message, null);		
	}
	
	public DriveventuresException(Throwable cause) {
		this(null,cause);		
	}
	
	public DriveventuresException(String message, Throwable cause) {
		super(message,cause);		
	}			
	
	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public void printStackTrace() {
		if (getCause()!=null) {
			getCause().printStackTrace();
		} else {
			super.printStackTrace();
		}
	}
	

	public void printStackTrace(PrintStream s) {
		if (getCause()!=null) {
			getCause().printStackTrace(s);
		} else {
			super.printStackTrace(s);
		}
	}	
	
	public void printStackTrace(PrintWriter w) {
		if (getCause()!=null) {
			getCause().printStackTrace(w);
		} else {
			super.printStackTrace(w);
		}
	}	

}
