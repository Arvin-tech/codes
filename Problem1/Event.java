package Problem1;

public class Event {
	public final static int Price_Per_Guest = 35;
	public final static int MAX_GUESTS = 50;
	private String eventNum = "M312";
	private int numOfGuests;
	private int price;
	
	public void setEventNumber(String eventNum) {
		this.eventNum = eventNum;
	}
	
	public void setGuests(int numOfGuests,int price) {
		this.numOfGuests = numOfGuests;
		price =  numOfGuests * Price_Per_Guest;
		this.price = price;
	}
	
	public String getEventNumber() {
		return eventNum;
	}
	
	public int getGuests() {
		return numOfGuests;
	}
	
	public int getPrice() {
		return price;
	}
}
