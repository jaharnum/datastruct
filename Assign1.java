import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Purpose:  This class is the method main for Assignment 1
 * It contains the main menu options for the user.
 * @author Jamie Harnum
 * Course: CST8130
 * Lab Section: 313
 * Known Issues: There is no handling for spaces being input
 */
public class Assign1 {

	public static void main(String[] args) {
		
		MyDate todayDate = new MyDate();
		
		int option = 0;
		
		Library myLib = new Library(3); //initialize library right away with a provided max
		
		Scanner in = new Scanner(System.in);
		
		do { //menu until 6 is selected
			
			System.out.println("Library Checkout System Menu");
			System.out.println("---------------------------------");
			System.out.println("Enter 1 to add a resource to borrow");
			System.out.println("Enter 2 to display overdue items");
			System.out.println("Enter 3 to display currently checked out resources");
			System.out.println("Enter 4 to delete a borrowed resource when it is returned");
			System.out.println("Enter 5 to change today's date");
			System.out.println("Enter 6 to quit");
			
			System.out.println("Today's date is currently set to: " + todayDate.toString());
			
			try {
				
				option = in.nextInt();
			
			} catch (InputMismatchException e) {
				
				System.out.println("Invalid option, please input an integer");
				in.next();//dump invalid input
				
			}
			
			if (option==1) {
				
				//add resource to borrow
				if (myLib.inputResource(in, todayDate)) {
					System.out.println("Resource has been successfully added");
				} else {
					System.out.println("Something went wrong - resource has not been added.");
				}
	
			} else if (option==2) {
				
				//display overdue items
				System.out.println(myLib.resourcesOverdue(todayDate));
				
			} else if (option==3) {
				
				//display currently checked out resources (entire array)
				System.out.println(myLib.toString());
			
			} else if (option==4) {
				
				//display all items first
				System.out.println(myLib.toString());
				//delete borrowed resource
				myLib.deleteResource(in, todayDate);
			
				//display all items again to verify that it worked lol
				System.out.println(myLib.toString());
				
			} else if (option==5) {
				
				//change today's date
				System.out.println("Change today's date");
				todayDate.inputDate(in);
				
			} else if (option>6 || option<1) {
				
				System.out.println("Invalid option, please input a value between 1 and 6");
				
			}
			
			option=0; //reset option to 0 so that if user inputs a bad value on the next go around it won't automatically do whatever the last successful option was
			
		} while (option!=6); //continue to show menu until user selects 6
		
		in.close();
		System.out.println("Exiting program");
		
	}

}
