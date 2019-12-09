package customChecked;

public class AgeLimitException extends Exception {
	
	String msg="Age should be greater than 17";

	public AgeLimitException(String msg) {
		super();
		this.msg = msg;
	}
	
	public AgeLimitException(){
		
	}
	 public String getMessage(){
		 return msg;
		
	}

}
