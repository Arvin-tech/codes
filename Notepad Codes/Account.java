
/**
 * -This class serves as an account object. The implementation of methods follows encapsulation.
 * -The number of transactions is pre-assumed to be at a maximum of 50. If ever the user exceeds the limit this program will encounter
 * an index out of bounds exception.
 * -The first constructor provide as a help for the specific method found in Bank class where a temporary Account object must be made.
 * -After creating an object of this class, the variables isOpen will be initialized to true, dateOpened to current date, 
 * status to "OP", and counter to 0.
 * -This class is mostly for setting it's own characteristics using setter and getter methods.
 * 
 * @author (Marc Vash Cane)
 * @version (July 6, 2020)
 */

public class Account
{
    private String name, address, status, dateOpened;
    private int accountNumber, counter;
    private boolean isOpen;
    private char gender;
    private double balance;
    private double[] transactionAmounts = new double[50];
    private int[][] transactionDates = new int[50][3];
    private String[] transactionTypes = new String[50];
    
    Account()
    {
        isOpen = true;
        status = "OP";
        counter = 0;
    }
    
    Account(String dateOpened)
    {
        this.dateOpened = dateOpened;
        isOpen = true;
        status = "OP";
        counter = 0;
    }
    
    public void setName(String name)
    {
        this.name = name;
    }
    
    public String getName()
    {
        return this.name.toUpperCase();
    }
    
    public void setAddress(String address)
    {
        this.address = address;
    }
    
    public String getAddress()
    {
        return this.address;
    }
    
    public void setGender(char gender)
    {
        this.gender = gender;
    }
    
    public String getGender()
    {
        return gender == 'm' || gender == 'M' ? "Male" : "Female";
    }
    
    public void setBalance(double balance)
    {
        this.balance = balance;
    }

    public double getBalance()
    {
        return this.balance;
    }
    
    public void setAccountNumber(int accountNumber)
    {
        this.accountNumber = accountNumber;
    }
    
    public int getAccountNumber()
    {
        return this.accountNumber;
    }

    public void setStatus(boolean isOpen)
    {
        status = isOpen ? "OP" : "CL"; 
        this.isOpen = isOpen;
    }
    
    public String getStatus()
    {
        return this.status.equals("OP") ? "Open" : "Closed";
    }
    
    public void setTransactionDatesTypesAndAmounts(int[] date, String type, double amount)
    {
        this.transactionDates[counter][0] = date[0];
        this.transactionDates[counter][1] = date[1];
        this.transactionDates[counter][2] = date[2];
        this.transactionTypes[counter] = type;
        this.transactionAmounts[counter] = amount; 
        this.counter++;
    }

    public int[][] getTransactionDates()
    {
        return this.transactionDates;
    }
    
    public String[] getTransactionTypes()
    {
        return this.transactionTypes;
    }
    
    public double[] getTransactionAmounts()
    {
        return this.transactionAmounts;
    }
    
    public int getCounter()
    {
        return this.counter;
    }
    
    public String getDateOpened()
    {
        return this.dateOpened;
    }

    public boolean isActive()
    {
        return this.isOpen;
    }

}
