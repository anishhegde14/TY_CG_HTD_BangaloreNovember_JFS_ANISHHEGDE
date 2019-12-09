package customexception;

public class DayLimitException extends RuntimeException {
	
	String msg;

	public DayLimitException(String msg) {
		super();
		this.msg = msg;
	}
	
	public DayLimitException(){
		
	}
	 public String getMessage(){
		 return msg;
		
	}

}
