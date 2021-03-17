package edu.mtc.egr283.project05;

public class ShoppingList {

	private SLL<String> theList;
	
	/**
	 * Constructor. Initialize the list.
	 */
	public ShoppingList() {
		this.theList = new SLL<String>();
	}// Ending bracket of constructor
	
	/**
	 * Method to get the current list size.
	 * @return integer size of the list.
	 */
	public int getSize() {
		return this.theList.size();
	}// Ending bracket of method getSize
	
	/**
	 * Method to add items to the list.
	 * @param newItem item to add.
	 * @param position position in the list to add it (starts at 1, NOT 0)
	 */
	public void addItem(String newItem, int position) {
		this.theList.add(newItem, (position - 1));
	}// Ending bracket of method addItem
	
	/**
	 * Method to add items to the top of the list.
	 * @param newItem item to add.
	 */
	public void addAtTop(String newItem) {
		this.theList.addAtHead(newItem);
	}// Ending bracket of method addItem

	/**
	 * Method to add items to the bottom of the list.
	 * @param newItem item to add.
	 */
	public void addAtBottom(String newItem) {
		this.addItem(newItem, this.getSize() + 1);
	}// Ending bracket of method addAtBottom
	
	/**
	 * Method to remove an item from the list by position.
	 * @param position the position of the item to remove.
	 * @throws ItemNotFoundException if an invalid position is given.
	 */
	public void remove(int position) throws ItemNotFoundException {
		if(position > this.getSize() || position < 1) {
			throw new ItemNotFoundException();
		}// Ending bracket of if
		this.theList.remove((position - 1));
	}// Ending bracket of method remove
	
	/**
	 * Method to remove an item from the list by data.
	 * @param targetData the data of the item to be removed.
	 * @throws ItemNotFoundException if the data is not in the list.
	 */
	public void removeData(String targetData) throws ItemNotFoundException { 
		boolean found = false;
		for(int i = 0; i < this.theList.size(); ++i) {
			if(targetData.equalsIgnoreCase(this.theList.getDataAtPosition(i))) {
				this.theList.removeData(targetData);
				found = true;
				break;
			}// Ending bracket of if
		}// Ending bracket of for loop
		if(!found) {
			throw new ItemNotFoundException();
		}// Ending bracket of if
	}// Ending bracket of method remove
	
	@Override
	/**
	 * Method to return the contents of the shopping list as a string. Includes 
	 * position number prior to each item for ease of use.
	 * @returns String form of the list.
	 */
	public String toString() {
		StringBuffer sb = new StringBuffer();
		
		for(int i = 0; i < this.getSize(); ++i) {
			sb.append(i + 1 + ": " + this.theList.getDataAtPosition(i) + "\n");
		}// Ending bracket of for loop
		
		return sb.toString();
	}// Ending bracket of method toString
	
}// Ending bracket of class ShoppingList
