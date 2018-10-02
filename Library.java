import java.util.Scanner;

public class Library {
	
	private Resource[] resourcesBorrowed;
	private int numResources;
	private int max;
	
	public Library(int max) {
		
		this.max = max;
		resourcesBorrowed = new Resource[max];
		//initializes array but does *not* allocate memory to the resources, only to the references *to* resources that have yet to be created
	}
	
	public boolean inputResource(Scanner in, MyDate today) {
		
		boolean typeSelected = false;
		
		do {
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
			if(numResources<max) {
				numResources++;
			} else {
				//TODO: handle resources exceeding the max
			}
		}
		
		//resourcesBorrowed[numResources] = new ((Resource));
		//resourcesBorrowed[numResources].inputResource(in, today);
		//if that = true, then numResources ++ as long as its not greater than the max num of resources
		return true;
	}
	
	public String toString() {
		//how many resources are currently being borrowed out of the max number
		//loop toString for all resources?
		return "a string representation of the library data";
	}
	
	public String resourcesOverDue(MyDate today) {
		//what resources are overdue today?
		return "list of overdue resources";
	}
	
	public void deleteResource(MyDate today) {
		//display a numbered list of resources currently in the resourcesBorrowed array
		//prompt user for a number to delete
		//will need to copy array to a new array with one less item in order to "remove" the item?
	}

}
