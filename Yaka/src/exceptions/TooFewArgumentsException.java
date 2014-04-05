package exceptions;

public class TooFewArgumentsException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public TooFewArgumentsException(String msg) {
		super(msg);
	}
}
