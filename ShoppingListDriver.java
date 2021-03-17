package edu.mtc.egr283.project05;

import java.util.Scanner;

public class ShoppingListDriver {
	
	private static ShoppingList list;

	public static void main(String[] args) {
		
		Scanner keyb = new Scanner(System.in);
		
		list = new ShoppingList();
		int option;
		
		do {
			option = ShoppingListDriver.promptUserInput(keyb);
			
			switch(option){
				case 1:
					ShoppingListDriver.remove(keyb);
					break;
				case 2: //option two and three are different versions of the same request
				case 3:
					ShoppingListDriver.add(keyb, option);
					break;
				case 4:
					System.out.println("SHOPPING LIST:\n" + list.toString());
					break;
			}// Ending bracket of switch
						
		//continue to display the list of options until the user wishes to exit	
		}while(option != 5); 
		
		System.out.println("Session terminated.");
		
	}// Ending bracket of method main
	
	// Method to display the menu and prompt input
	private static int promptUserInput(Scanner userInput) {
		int selection;
		
		do {
			//formatting
			for(int i = 0; i < 20; ++i) {
				System.out.print("^^");
			}// Ending bracket of for loop
			
			//the menu
			System.out.println("\n");
			System.out.println("Select any option [1-5]");
			System.out.println("1. Delete an item.");
			System.out.println("2. Add an item at a specific location.");
			System.out.println("3. Add an item at the end of the list.");
			System.out.println("4. Display shopping list.");
			System.out.println("5. Exit.\n");
			
			selection = userInput.nextInt();
			
		}while(selection > 5 || selection < 1); //simple validation
		
		return selection;	
	}// Ending bracket of method promptUserInput
	
	// Method for removing data.  Commented out portion gives option of removing data
	//	by position as opposed to data.
	private static void remove(Scanner userInput) {
		String targetData;
		
		if(list.getSize() !=0){
			System.out.println("What item would you like to delete?");
			targetData = userInput.next();
			try {
				list.removeData(targetData);
			}catch(ItemNotFoundException infe) {
				System.out.println(infe.getMessage());
			}// Ending bracket of try-catch block
			
//			System.out.println("What is the number of the item you wish to delete? 
//				[1 - " + list.getSize() + "]");
//			int selection = userInput.nextInt();
//			
//			try {
//				list.remove(selection);	
//			}catch(ItemNotFoundException infe) {
//				System.out.println(infe.getMessage());
//			}// Ending bracket of try-catch block
		}else {
			System.out.println("The list has no contents.");
		}// Ending bracket of if-else
	}// Ending bracket of method remove
	
	// Method for adding data to the list.  If no option is given, position desired is 
	//	assumed to be the bottom of the list.
	private static void add(Scanner userInput, int option) {
		int position = list.getSize() + 1; //set default to bottom of list
		String data;
		
		System.out.println("What is the item you would like to add?");
		data = userInput.next();
		
		//if user specified position, get position to add
		if(option == 2) {
			System.out.println("Where in the list would you like to place it ? [1 - " + 
					position + "]");
			position = userInput.nextInt();
		}// Ending bracket of if
		
		list.addItem(data, position);
	}// Ending bracket of method add
	
}// Ending bracket of class ShoppingListDriver
