
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Purpose:  The Library class contains the array of Resources that have been borrowed. 
 * It handles adding and deleting new resources.
 * @author Jamie Harnum
 * Course: CST8130
 * Lab Section: 313
 * Data Members: resourcesBorrowed[]: Resource - main array of Resources for the Library
 * 				 copyResources[]: Resource - secondary array to use when deleting items or increasing the size of the array
 * 				 numResources: int - total current number of resources (starting at 0)
 * 				 max: int - The current size of the array
 * 
 * Methods: 	Library(int): default constructor, sets the max size and initializes the resourcesBorrowed array
 * 				inputResource(Scanner, MyDate): select resource type and test for input. This method also handles increasing the size of the array when needed (1 before reaching the max size)
 * 				toString(): a String representation of all items in the resourcesBorrowed array
 * 				resourcesOverdue(MyDate): a list of all resources overdue as of MyDate given
 * 				deleteResource(Scanner, MyDate): deletes a user selected resource from the array
 */
public class Library {
	
	private Resource[] resourcesBorrowed;
	private Resource[] copyResources;
	private int numResources;
	private int max;
	
	public Library(int max) {
		
		this.max = max;
		resourcesBorrowed = new Resource[max];
		//initializes array but does *not* allocate memory to the resources, only to the references *to* resources that have yet to be created
	}
	
	public boolean inputResource(Scanner in, MyDate today) {
		
		boolean typeSelected = false;
		
		do { //type selection and initialization
			System.out.println("What type of resource would you like to borrow?");
			System.out.println("Options: ");
			System.out.println("B for book");
			System.out.println("D for DVD");
			System.out.println("M for magazine");
			System.out.println("O for other");
			
			String resourceType = in.next();
			
			if (resourceType.equalsIgnoreCase("B")) {
				//book
				resourcesBorrowed[numResources] = new Book();
				typeSelected = true;
				
			} else if (resourceType.equalsIgnoreCase("D")) {
				//dvd
				resourcesBorrowed[numResources] = new DVD();
				typeSelected = true;
				
			} else if (resourceType.equalsIgnoreCase("M")) {
				//magazine
				resourcesBorrowed[numResources] = new Magazine();
				typeSelected = true;
				
			} else if (resourceType.equalsIgnoreCase("O")) {
				//other
				resourcesBorrowed[numResources] = new Resource();
				typeSelected = true;
				
			} else {
				System.out.println("Sorry, that's not a valid option");
				
			}
		} while (!typeSelected);
		
		if (resourcesBorrowed[numResources].inputResource(in, today)) {
			
			if(numResources==max-1) {
				copyResources = new Resource[max*2];
				
				for(int i = 0; i < numResources+1; i++) {
					copyResources[i] = resourcesBorrowed[i];
				}
				
				resourcesBorrowed = copyResources;
				max = max*2;
			
			} 
			
				System.out.println("New resource added: " + resourcesBorrowed[numResources].toString());
				numResources++;
			
			return true;
		} else {
		
		return false;
		}
	}
	
	public String toString() {
		//how many resources are currently being borrowed out of the max number
		//loop toString for all resources?
		if(numResources == 0) {
			return "There are not currently any resources checked out of the library";
		} else {
			String s = "Number of resources currently checked out: " + numResources;
			for(int i = 0; i<numResources; i++) {
				String temp = "\n[" + (i+1) + "] - " + resourcesBorrowed[i].toString();
				s = s+temp;
			}
			return s;
		}
		
	}
	
	public String resourcesOverdue(MyDate today) {
		//what resources are overdue today?
		int numOverdue = 0;
		
		for(int i = 0; i<numResources; i++) {
			if(resourcesBorrowed[i].isOverDue(today)) {
				System.out.println("[" + i + "] is overdue.");
				System.out.println("Overdue item info: " + resourcesBorrowed[i].toString());
				numOverdue++;
			}
			
		}
		return "Overdue items: " + numOverdue;
	}
	
	public void deleteResource(Scanner in, MyDate today) {

		int resourceNum = 0;
		
		do {
			
			System.out.println("What is the number of the resource you would like to remove from the list?");
			
				try {
				resourceNum = in.nextInt();
				} catch (InputMismatchException e) {
					System.out.println("Must be a number");
				}
				
				if(resourceNum > numResources || resourceNum < 1) {
					System.out.println("Sorry, there is no resource with that number");
					resourceNum=0;
				}
				
		} while (resourceNum==0);
			
			resourcesBorrowed[resourceNum-1] = resourcesBorrowed[numResources-1];
			this.numResources=numResources-1;
			//this isn't working properly and I don't know why... it works if I remove the last one in the list but not if i remove an earlier list item.
			
	}

}
