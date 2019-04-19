package util.lab.configs;

@SuppressWarnings("serial")
public class BusinessException extends RuntimeException {

	public BusinessException(String message, Throwable cause) {
		super(message, cause);
	}

	public BusinessException(String message) {
		super(message);
	}

}
