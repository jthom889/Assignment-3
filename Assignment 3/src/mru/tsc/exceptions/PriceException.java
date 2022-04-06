package mru.tsc.exceptions;

public class PriceException extends Exception {
	/**
	 * @param message
	 */
	public PriceException() {
		super("Price is not a positive number");
	}
}