package co.com.leantech.employee.utils;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class CustomErrorException extends RuntimeException{

	private static final long serialVersionUID = -5266331095789475633L;
	
	private HttpStatus status;
    private Object data;
    
    public CustomErrorException() {
        super();
    }

    public CustomErrorException(String message) { 
        super(message,null,false,false);
    }

    public CustomErrorException(HttpStatus status,String message) {
        this(message);
        this.status = status;
    }
}
