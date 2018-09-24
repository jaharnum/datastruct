import java.util.Scanner;

public class Library {
	
	private Resource[] resourcesBorrowed;
	private int numResources;
	private int max;
	
	public Library() {
		//TODO: constructor
		//set max
	}
	
	public boolean inputResource(Scanner in, MyDate today) {
		//TODO: what kind of resource?
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
