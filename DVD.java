import java.util.Scanner;

public class DVD extends Resource {

	protected String type;
	
	public DVD() {
		
	}
	
	public boolean inputResource(Scanner in, MyDate today) {
		super.inputResource(in, today);
		//plus type
		return true;
	}
	
	public String toString() {
		return super.toString();//plus type
	}
}
