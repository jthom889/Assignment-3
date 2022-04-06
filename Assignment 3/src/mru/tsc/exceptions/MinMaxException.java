package mru.tsc.exceptions;

public class MinMaxException extends Exception {
	/**
	 * @param message
	 */
	public MinMaxException() {
		super("Minimum players must be less than Maximum players");
	}
}