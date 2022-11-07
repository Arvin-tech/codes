package Problem1;
import java.util.*;

public class carlysEventPriceWithMethods {
	private static int numGuests;
	private static int price;
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[]args) {	
		promptUser(); //prompt user for number of guests
		displayMotto(); //method that displays the company motto 
		computePrice(numGuests, price);
	}
	
	public static void promptUser() {
		boolean valid = false;
		do{
			System.out.println("Number of Guests: ");
			numGuests = sc.nextInt();
			if(numGuests > 50) {
				System.out.println("Maximum Guests is 50 only. Please enter again!");
				valid = false;
			}else {
				valid = true;
			}		
		}while(valid!=true);
	}
	
	public static void displayMotto() {
		System.out.println("THIS IS A COMPANY MOTTO!");
	}
	
	public static void computePrice(int numGuests, int price) {
		//computes price of event
		Event event = new Event();
		event.setGuests(numGuests, price);
		price = event.getPrice();
		System.out.println("Price: "+price); //display price
		
		//to determine whether event is large
		if(numGuests == 50) 
			System.out.println("It is a LARGE event!"); 
		else
			System.out.println("It is a SMALL event!");
	
	}
}
