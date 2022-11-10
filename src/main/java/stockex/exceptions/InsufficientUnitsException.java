package stockex.exceptions;

public class InsufficientUnitsException extends Throwable {
	
	private static final long serialVersionUID = 1L;

	public InsufficientUnitsException() {
		super("Insufficient units available");
	}

	public InsufficientUnitsException(Throwable err) {
		super(err);
	}
}
