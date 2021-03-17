package edu.mtc.egr283.project05;

public class ItemNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;

	/**
	 * Constructor.  Calls the parent Exception class.
	 * @param newMessage The message to display.
	 */
	public ItemNotFoundException(String newMessage) {
		super(newMessage);
	}// Ending bracket of constructor
	
	/**
	 * Default constructor. Sets default message to read "Item is not in the list".
	 */
	public ItemNotFoundException() {
		this("Item is not in the list.");
	}// Ending bracket of default constructor
	
}// Ending bracket of class ItemNotFoundException
