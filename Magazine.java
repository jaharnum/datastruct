import java.util.Scanner;

public class Magazine extends Resource {
	
	protected MyDate edition;
	
	public Magazine() {
		
	}
	
	public boolean inputResource(Scanner in, MyDate today) {
		
		super.inputResource(in, today);
		//plus edition
		return true;
		
	}
	
	public String toString() {
		return super.toString(); //plus edition
	}

}
