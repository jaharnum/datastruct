import java.util.Scanner;

public class Book extends Resource {
	
	protected String author;
	
	public Book() {
		
	}
	
	public boolean inputResource(Scanner in, MyDate today) {
		super.inputResource(in, today);
		//+ input author
		return true;
	}
	
	public String toString() {
		
		return super.toString(); //+author
	}

}
