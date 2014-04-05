package exceptions;

public class TooManyArgumentsException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public TooManyArgumentsException(String msg) {
		super(msg);
	}
}
