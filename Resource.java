import java.util.Scanner;

public class Resource {
	
	protected String title;
	protected String borrower;
	protected MyDate dueDate;
	protected float overdueCost;
	
	public Resource() {
		//TODO what should be in this constructor? by default, perhaps, there is no borrower, due date, or overdue cost, but it must have a title to exist?
	}
	
	public boolean inputResource(Scanner in, MyDate today) {
		//to add new resources being taken out of the library
		
		
		this.dueDate = new MyDate();
		this.dueDate = today.calcDueDate(); //due two weeks from today
		
		
		return true;
		
	}
	
	public String toString() {
		return "String representation of the title, borrower, dueDate, overdueCost";
	}

	public boolean isOverDue(MyDate today) {
		return true; //TODO if today isGreaterThan(dueDate);
	}
	
	public String displayOverDue(MyDate today) {
		if (this.isOverDue(today)) {
			
			int numDays = 0; //number of days between today and due date
			//multiply by overdueCost TODO
			
			return "This resource is overdue by " + numDays + ". Overdue fees are: " + overdueCost;
			
		} else {
			
			return "This resource is not overdue yet";
		}
	}
}
