package stockex.exceptions;

public class InvalidCodeException extends Throwable {

  private static final long serialVersionUID = 1L;

  public InvalidCodeException() {
		super("Invalid stock code");
	}

  public InvalidCodeException(Throwable err) {
		super(err);
	}

}
