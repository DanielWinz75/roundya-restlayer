package net.roundya.restlayer.errorhandling;

public class PlaceNotExistingException extends Exception {

	private static final long serialVersionUID = -9079454849611061074L;

	public PlaceNotExistingException() {
		super();
	}

	public PlaceNotExistingException(final String message) {
		super(message);
	}

}