
public class MyDate {

	private int year;
	private int month;
	private int day;
	
	public MyDate() {
		//TODO constructor method
	}
	
	public String toString() {
		return "String representation of MyDate";
	}
	
	public void addOne() {
		//add an extra day & handle change in month/year as needed
	}
	
	public boolean isEqual(MyDate dueDate) {
		//compare two dates to see if they are equal
		return true;
	}
	
	public boolean isGreaterThan(MyDate dueDate) {
		//if today > dueDate, return true
		return true;
	}
}
