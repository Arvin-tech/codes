import java.util.Scanner;

class Bank {
    private String accno;
    private String name;
    private long balance;

    Scanner KB = new Scanner(System.in);

    //method to open an account
    void openAccount() {
        System.out.print("Enter Account No: ");
        accno = KB.next();
        System.out.print("Enter Name: ");
        name = KB.next();
        System.out.print("Enter Balance: ");
        balance = KB.nextLong();
    }

    //method to display account details
    void showAccount() {
        System.out.println(accno + "," + name + "," + balance);
    }

    //method to deposit money
    void deposit() {
        long amt;
        System.out.println("Enter Amount U Want to Deposit : ");
        amt = KB.nextLong();
        balance = balance + amt;
    }

    //method to withdraw money
    void withdrawal() {
        long amt;
        System.out.println("Enter Amount U Want to withdraw : ");
        amt = KB.nextLong();
        if (balance >= amt) {
            balance = balance - amt;
        } else {
            System.out.println("Less Balance..Transaction Failed..");
        }
    }

    //method to search an account number
    boolean search(String acn) {
        if (accno.equals(acn)) {
            showAccount();
            return (true);
        }
        return (false);
    }
}

public class ExBank {
    public static void main(String arg[]) {
        Scanner KB = new Scanner(System.in);

        //create initial accounts
        System.out.print("How Many Customer U Want to Input : ");
        int n = KB.nextInt();
        Bank C[] = new Bank[n];
        for (int i = 0; i < C.length; i++) {
            C[i] = new Bank();
            C[i].openAccount();
        }

        //run loop until menu 5 is not pressed
        int ch;
        do {
            System.out.println("Main Menu\n1. Display All\n 2. Search By Account\n 3. Deposit\n 4. Withdrawal\n 5.E xit ");
                System.out.println("Ur Choice :"); ch = KB.nextInt();
                switch (ch) {
                    case 1:
                        for (int i = 0; i < C.length; i++) {
                            C[i].showAccount();
                        }
                        break;

                    case 2:
                        System.out.print("Enter Account No U Want to Search...: ");
                        String acn = KB.next();
                        boolean found = false;
                        for (int i = 0; i < C.length; i++) {
                            found = C[i].search(acn);
                            if (found) {
                                break;
                            }
                        }
                        if (!found) {
                            System.out.println("Search Failed..Account Not Exist..");
                        }
                        break;

                    case 3:
                        System.out.print("Enter Account No : ");
                        acn = KB.next();
                        found = false;
                        for (int i = 0; i < C.length; i++) {
                            found = C[i].search(acn);
                            if (found) {
                                C[i].deposit();
                                break;
                            }
                        }
                        if (!found) {
                            System.out.println("Search Failed..Account Not Exist..");
                        }
                        break;

                    case 4:
                        System.out.print("Enter Account No : ");
                        acn = KB.next();
                        found = false;
                        for (int i = 0; i < C.length; i++) {
                            found = C[i].search(acn);
                            if (found) {
                                C[i].withdrawal();
                                break;
                            }
                        }
                        if (!found) {
                            System.out.println("Search Failed..Account Not Exist..");
                        }
                        break;

                    case 5:
                        System.out.println("Good Bye..");
                        break;
                }
            }
            while (ch != 5);
        }
    }
	
	
===================================================

public class Main
{
    public static void main(String[]args){
        BankAccSystem bank = new BankAccSystem();
        bank.mainmenu();
    }
}


/**
 * Write a description of class BankAccSystem here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.*;
import java.time.LocalDate; //for transaction date
public class BankAccSystem
{
    static Scanner input = new Scanner(System.in);
    private Accounts[] accounts;
    private int numAccounts;
    
    public void BankAccountCreation(){
        numAccounts = 0;
        accounts = new Accounts[100]; //total account limits
    }
    
    public void main(){
        int choice; // do while
        
        do{
            System.out.println("\f\tMenu");
            System.out.println("[1] New Account\n[2] Deposit");
            System.out.println("[3] Withdrawal\n[4] Inquiry by Account No.");
            System.out.println("[5] Inquiry by LastName\n[6] Update Record");
            System.out.println("[7] Show All Accounts\n[8] Exit\n Enter number of choice: ");
            choice = input.nextInt();

            switch(choice){

                case 1: newAccount();
                        break;
                case 2: deposit();
                        break;
                case 3: withdrawal();
                        break;
                case 4: inquirybyAccountNo();
                        break;
                case 5: inquirybyLastName();
                        break;
                case 6: updateRecord();
                        break;
                case 7: showAllAccounts();
                        break;
                case 8: System.out.print("Closing Program..");
                        break;

            }
			
        }while(choice != 8);
    }
    
    public void newAccount(){
        
        int accountNum;
        String lastName, firstName, address, middleInitial, telephone, mobile;
        double opBalance;
        String date,status;
        //String date = LocalDate.now().toString();
        int digit = 5; //account number digit
        int mobiledigit = 11;

        //input & validation
        if(numAccounts > 100){
            System.out.print("Account limit reached - 100 accounts already exist.");
        }
        
        accounts[numAccounts] = new Accounts();
        
        do{
            System.out.print("Enter account number (5-digits): ");
            accountNum = input.nextInt();
        }while(digit < 5 || digit != 5);
        
        System.out.print("\nEnter Last Name: ");
        lastName = input.nextLine();
        System.out.print("\nEnter First Name: ");
        firstName = input.nextLine();
        System.out.print("\nEnter Middle Initial: ");
        middleInitial = input.nextLine();
        System.out.print("\nEnter Home Address: ");
        address = input.nextLine();
        System.out.print("\nEnter Telephone No. : ");
        telephone = input.nextLine();
        do{
            System.out.print("\nEnter Mobile No. : ");
            mobile = input.nextLine();
        }while(mobiledigit < 0 || mobiledigit > 11); //if mobile number input is negative and greater than 11
        
        do{
            System.out.print("\nEnter Opening Balance (2000 Mininum) : ");
            opBalance = input.nextDouble();
        }while(opBalance < 2000); //minimum
        
        System.out.print("\nEnter Opening Date (mm-dd-yy) : ");
        date = input.nextLine();
        
        accounts[numAccounts].setAccountNum(accountNum);
        accounts[numAccounts].setLastName(lastName);
        accounts[numAccounts].setFirstName(firstName);
        accounts[numAccounts].setMiddleInitial(middleInitial);
        accounts[numAccounts].setAddress(address);
        accounts[numAccounts].setTelephone(telephone);
        accounts[numAccounts].setMobile(mobile);
        accounts[numAccounts].setOpeningBalance(opBalance);
        accounts[numAccounts].setOpeningDate(date);
        //status block
        
        showAccounts(numAccounts);
        numAccounts++;
        
             
    }

    public void deposit(){
    }

    public void withdrawal(){
    }

    public void inquirybyAccountNo(){
    }

    public void inquirybyLastName(){
    }

    public void updateRecord(){
    }

    public void showAllAccounts(){
    }
    
    private void showAccounts(int number){ //shows the account created where, int number == account created
        System.out.println("Account Information:\n");
        System.out.println("Account Number: "+accounts[number].getAccountNum());
        System.out.println("Account Holder's Last Name: "+accounts[number].getLastName());
        System.out.println("Account Holder's First Name: "+accounts[number].getFirstName());
        System.out.println("Account Holder's Middle Initial: "+accounts[number].getMiddleInitial());
        System.out.println("Home Address: "+accounts[number].getAddress());
        System.out.println("Telephone Number: "+accounts[number].getTelephone());
        System.out.println("Mobile Number: "+accounts[number].getMobile());
        System.out.println("Opening Balance: "+accounts[number].getOpeningBalance());
        System.out.println("Opening Date: "+accounts[number].getOpeningDate());
        
    }
}


public class Accounts
{
    private int accountNum, counter;
    private String lastName, firstName, address, middleInitial, telephone, mobile, date, status;
    private double opBalance;
       
    //getters & setters
    public void setAccountNum(int accountNum){
        this.accountNum = accountNum;
    }
    
    public int getAccountNum(){
        return this.accountNum;
    }
    
    public void setLastName(String lastName){
        this.lastName = lastName;
    }
    
    public String getLastName(){
        return this.lastName;
    }
    
    public void setFirstName(String firstName){
        this.firstName = firstName;
    }
    
    public String getFirstName(){
        return this.firstName;
    }
    
    public void setMiddleInitial(String middleInitial){
        this.middleInitial = middleInitial;
    }
    
    public String getMiddleInitial(){
        return this.middleInitial;
    }
    
    public void setAddress(String address){
        this.address = address;
    }
    
    public String getAddress(){
        return this.address;
    }
    
    public void setTelephone(String telephone){
        this.telephone = telephone;
    }
    
    public String getTelephone(){
        return this.telephone;
    }
    
    public void setMobile(String mobile){
        this.mobile = mobile;
    }
    
    public String getMobile(){
        return this.mobile;
    }
    
    public void setOpeningBalance(double opBalance){
        this.opBalance = opBalance;
    }
    
    public double getOpeningBalance(){
        return this.opBalance;
    }
    
    public void setOpeningDate(String date){
        this.date = date;
    }
    
    public String getOpeningDate(){
        return this.date;
    }
    
}


===================


 if(input.hasNextInt()){
                accountNum = input.nextInt();
                check = true;
            }
            else{
                System.out.print("Please dont enter a string!");
                check = false;
                input.next();
				
				
===============================================================				
	
        //inputs and validations
        do{

            try{
                System.out.print("Enter account number (5-digits): ");
                accountNum = input.nextInt();
                check = true;
  
            }
            catch (InputMismatchException nfeRef){ //mismatch if string input
                System.out.println("> Exception: " + nfeRef.toString()+ " Your account number must be an integer! Please try again!");
                input.nextLine();
                break;
            } 
            catch (Exception e){
                System.out.println("> Exception:  " + e.toString()+ " Your account number must be an integer! Please try again!");
            }

        }while(!check);
		
		
=========================
 int i = input.nextInt();
        int length = String.valueOf(i).length();
        while(length > accountNum_digit){
            i = input.nextInt();
            length = String.valueOf(i).length();
        }
        input.nextLine();
		
		
		
=========================================
//CREATE NEW ACCOUNT CODE


AccGetSet account = new AccGetSet();
        boolean inputCell = false;
        int AccNum;
        String lastName, firstName, address, telNum, mobNum, accStatus, dateOpened;
        char midInitial = 0;
        double balance;
        int kin = 0;
        AccNum = makeAccNum();
        System.out.println("\f\n\t\t\t\tCreate New Account\n");
        System.out.println("Account Number : " + AccNum);
        sc.nextLine();
        System.out.print("Last Name      : ");
        lastName = sc.nextLine();
        System.out.print("First Name     : ");
        firstName = sc.nextLine(); 
        System.out.print("Input Middle Name?\n Press any Positive Integers to continue"+
        "\ntype /0/ if none...");
        kin = sc.nextInt();
        do{
        if (kin == 0){
            break;
        }
        else {
            System.out.print("Middle Initial : ");
            midInitial = sc.next().charAt(0);
            break;
        }
        }while(kin == 0);
        System.out.print("Address        : ");
        sc.nextLine();
        address = sc.nextLine();
        System.out.print("\nexample 1.(xxx-xxx-xxxx) \nexample 2.(xxx-xxxx)"+
        "\nexample 3.(x-xxxx)");
        System.out.print("Telephone No.  : ");
        telNum = sc.nextLine();      
        do {  
           if (telNum.matches("[0-9]{3}[-]{1}[0-9]{3}[-]{1}[0-9]{4}")|| telNum.matches("[0-9]{3}[-]{1}[0-9]{4}")|| telNum.matches("[0-9]{1}[-]{1}[0-9]{4}")){
                    inputCell = true;
                    break;
                }
                else{
                System.out.println("pls input a proper Telephone number:");
                System.out.print("Phone number:");
                telNum = sc.nextLine();
               }
         }while(true);    
        System.out.print("Mobile No.     : ");
        mobNum = sc.nextLine();
        do {
            if (mobNum.charAt(0) == '0' && mobNum.charAt(1) == '9' && mobNum.length() == 11){
                inputCell = true;
                break;
            }
            else{
                System.out.println("Pls input a proper Phone number:");
                System.out.println("Starts with [0-9] & 11 digits:");
                System.out.print("Phone number:");
                mobNum = sc.nextLine();
           }
         }while(true);    
        do
        {
            System.out.print("Opening Balance: ");
            balance = sc.nextDouble();
            if(balance < 0)
                System.out.println("Opening balance cannot be negative.");
        }while(balance < 0);
        System.out.print("Opening Date   : ");
        sc.nextLine();
        dateOpened = sc.nextLine();
        System.out.print("Account Status : ");
        accStatus = sc.nextLine();
        System.out.println("Press any key to gack to the Main...");
        sc.nextLine();
        
        account.setAccNum(AccNum);
        account.setLastName(lastName);
        account.setFirstName(firstName);
        account.setMidInitial(midInitial);
        account.setAddress(address);
        account.setTelNum(telNum);
        account.setMobNum(mobNum);
        account.setBalance(balance);
        account.setDateOpened(dateOpened);
        account.setAccStatus(accStatus);

        if(head == null)
        {
            head = account;
        }
        else
        {
            AccGetSet temp = head;
            while(temp.next != null)
                temp = temp.next;
            
            temp.next = account;
        }
    }
    ================================================
	
	     //INQUIRY BY ACCOUNT NUMBER!!!
        System.out.printf("\n\n[ALL TRANSACTIONS]");
        System.out.print("\n\tAccount No.\t\tLastName\t\tFirstName\tM.I\tAccount Balance\t\tStatus\n");
        for(int a = 0; a < numOfAccounts; a++){
            System.out.printf("\n\t%-23d %-24s %-15s %-9c %.2f\t\t%-9s\n",accountRecords[i].getAccountNum(),accountRecords[i].getLastName(), accountRecords[i].getFirstName(), 
                accountRecords[i].getMiddleInitial(),accountRecords[i].getBalance(), accountRecords[i].getStatus());
        }

private void summaryOfAccount(){
        int accountNum = 12345;
        int i;

        do{
            System.out.print("Enter Account Number [5-digits]: ");
            if(input.hasNextInt()){ //reject string input
                accountNum = input.nextInt();
                check = true;

                i = search(accountNum);
                if(i == -1){
                    System.out.print("Error: Account number doesn't exist! Continue transaction?");
                    System.out.print("\n[1] Re-enter Account No. & Proceed \n[0] Quit Transaction: ");
                    int response = input.nextInt();

                    //if response is 1
                    if(response == 1){
                        check = false;
                    }

                    if(response == 0){
                        return; //back to menu
                    }
                }
                else{
                    break;
                }

                if(accountNum < 0){
                    System.out.print("Account Number cannot be negative!\n");
                    check = false;
                }
            }
            else{
                System.out.print("Invalid account number! Please enter again: \n");
                check = false;
                input.next();
            }

        }while(true);

        System.out.println("Account Holder's Last Name: "+accountRecords[numOfAccounts].getLastName());
        System.out.println("Account Holder's First Name: "+accountRecords[numOfAccounts].getFirstName());
        System.out.println("Account Holder's Middle Initial: "+accountRecords[numOfAccounts].getMiddleInitial());
        System.out.println("Home Address: "+accountRecords[numOfAccounts].getAddress());
        System.out.println("Telephone Number: "+accountRecords[numOfAccounts].getTelephone());
        System.out.println("Mobile Number: "+accountRecords[numOfAccounts].getMobile());
        System.out.println("Opening Balance: "+accountRecords[numOfAccounts].getBalance());
        System.out.println("Opening Date: "+accountRecords[numOfAccounts].getDate());
        System.out.println("Account Status: "+accountRecords[numOfAccounts].getStatus()); 
        continueTransaction();
    }

    private void allTransactions(){
        int accountNum = 12345;
        int i;

        do{
            System.out.print("Enter Account Number [5-digits]: ");
            if(input.hasNextInt()){ //reject string input
                accountNum = input.nextInt();
                check = true;

                i = search(accountNum);
                if(i == -1){
                    System.out.print("Error: Account number doesn't exist! Continue transaction?");
                    System.out.print("\n[1] Re-enter Account No. & Proceed \n[0] Quit Transaction: ");
                    int response = input.nextInt();

                    //if response is 1
                    if(response == 1){
                        check = false;
                    }

                    if(response == 0){
                        return; //back to menu
                    }
                }
                else{
                    break;
                }

                if(accountNum < 0){
                    System.out.print("Account Number cannot be negative!\n");
                    check = false;
                }
            }
            else{
                System.out.print("Invalid account number! Please enter again: \n");
                check = false;
                input.next();
            }

        }while(true);

        System.out.printf("Name: %-16s %-20s %-9c",accountRecords[numOfAccounts].getLastName(),accountRecords[numOfAccounts].getFirstName(),
            accountRecords[numOfAccounts].getMiddleInitial());
        System.out.printf("Account Balance: %.2f",accountRecords[numOfAccounts].getBalance());
        continueTransaction();
    }