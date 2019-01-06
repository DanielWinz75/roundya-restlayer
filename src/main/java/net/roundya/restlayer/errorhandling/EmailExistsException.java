package net.roundya.restlayer.errorhandling;

public class EmailExistsException extends Exception {

	private static final long serialVersionUID = -9079454849611061074L;

	public EmailExistsException() {
		super();
	}

	public EmailExistsException(final String message) {
		super(message);
	}

}