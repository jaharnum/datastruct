import java.util.InputMismatchException;
import java.util.Scanner;

public class Assign1 {

	public static void main(String[] args) {
		
		MyDate todayDate = new MyDate();
		
		int option = 0;
		
		Library myLib = new Library(3); //initialize library right away with a provided max
		
		Scanner in = new Scanner(System.in);
		
		do { //menu
			
			
			System.out.println("Welcome to the library checkout system");
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
				
				System.out.println("Input integers only");
				in.next();//dump invalid input
				
			}
			
			if (option==1) {
				
				//add resource to borrow
				
			} else if (option==2) {
				
				//display overdue items
				
			} else if (option==3) {
				
				//display currently checked out resources (entire array)
			
			} else if (option==4) {
				
				//delete borrowed resource
				
			} else if (option==5) {
				
				//display today's date
				
			} else if (option!=6) {
				
				System.out.println("Invalid option, please try again");
				
			}
					
		} while (option!=6);
		
		in.close();
		System.out.println("Exiting program");
		
	}

}
