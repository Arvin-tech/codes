/**
 * -This class handles all the operation for the program.
 * -The user input will be taken by this class and probably there will be no exceptions or errors that will occur if the user inputs
 * the correct type of data regarding to the required input by the program.
 * -There is no exception handling implemented in this class thus be careful when inputting data.
 * -The accountNumber of each account is created uniquely using SecureRandom class alone. 
 * 
 * @author (Marc Vash Cane)
 * @version (July 6, 2020)
 */
import java.util.Scanner;
import java.time.LocalDate;
import java.security.SecureRandom;

public class Bank
{
    static Scanner sc = new Scanner(System.in);
    
    private int numberOfAccounts;
    private Account[] accounts;
    
    Bank()
    {
        numberOfAccounts = 0;
        accounts = new Account[888];
    }
    
    public void menu()
    {
        byte choice;
        
        do
        {    
            System.out.println("\f\tMenu");
            System.out.println("[1] Create new account\n[2] Deposit");
            System.out.println("[3] Withdrawal\n[4] Account Inquiry");
            System.out.println("[5] Account Inquiry by Date\n[6] Inquiry by Status");
            System.out.println("[7] Show All Accounts\n[8] Change Account Status");
            System.out.print("[9] Exit\n Your choice: ");
            choice = sc.nextByte();
            
            switch(choice)
            {
                case 1: createAccount();
                    break;
                case 2: deposit();
                    break;
                case 3: withdraw();
                    break;
                case 4: accountInquiryByNumber();
                    break;
                case 5: accountInquiryByDate();
                    break;
                case 6: accountInquiryByStatus();
                    break;
                case 7: showAllAccounts();
                    break;
                case 8: changeAccountStatus();
                    break;
                case 9: System.out.print("\f\n\n\n\t===== End of Program =====");
                    break;
            }
        }while(choice != 9);
    }
    
    public void createAccount()
    {
        if(numberOfAccounts >= 888)
        {
            System.out.println("\f\n\n[Error] Maximum number of accounts reached, cannot create more accounts.");
            return;
        }

        char gender;
        int accountNumber;
        double balance;
        String name, address;
        String now = LocalDate.now().toString();

        accounts[numberOfAccounts] = new Account(now);
        accountNumber = generateAccountNumber();
        
        System.out.println("\f\n\t\t\t\t---Create New Account---\n");
        System.out.print("Enter your name: ");
        sc.nextLine();
        name = sc.nextLine();
        System.out.print("Enter your gender (M / F): ");
        gender = sc.next().charAt(0);
        System.out.print("Enter your address: ");
        sc.nextLine();
        address = sc.nextLine();
        
        do
        {
            System.out.print("Enter your opening balance (500 minimum): ");
            balance = sc.nextDouble();
        }while(balance < 500);
        
        accounts[numberOfAccounts].setName(name);
        accounts[numberOfAccounts].setAddress(address);
        accounts[numberOfAccounts].setGender(gender);
        accounts[numberOfAccounts].setBalance(balance);
        accounts[numberOfAccounts].setAccountNumber(accountNumber);
        
        displayAccountDetails(numberOfAccounts);
        numberOfAccounts++;
        
        enterAnyKeyToContinue();
    }
    
    public void deposit()
    {
        int accountNumber, index;
        int [] depositDate = new int[3];
        double depositAmount;

        do
        {
            char choice;
            
            System.out.println("\f\n\t\t\t\t---Deposit---\n");
            System.out.print("Enter your bank account number: ");
            accountNumber = sc.nextInt();
            sc.nextLine();

            index = linearSearch(accountNumber);
            if(index == -1)
            {
                System.out.println("\f\n\t\t\t\t---Deposit---\n");
                System.out.print("[Error] The Account number you entered doesn't exist.\nWould you like to try again (y/n)? ");
                choice = sc.next().charAt(0);
                enterAnyKeyToContinue();
                
                if(choice == 'n' || choice == 'N')
                   return;
            }
            else 
                break;
        }while(true);
        
        if(!accounts[index].isActive())
        {
            System.out.println("\f\n\t\t\t\t---Deposit---\n");
            System.out.print("[Error] Your account is closed, cannot make transaction.");
            enterAnyKeyToContinue();
            return;
        }
        
        System.out.println("Please Enter deposit date (digits only)");
        System.out.print("Enter month: ");
        depositDate[0] = sc.nextInt();
        System.out.print("Enter day: ");
        depositDate[1] = sc.nextInt();
        System.out.print("Enter year: ");
        depositDate[2] = sc.nextInt();
        
        System.out.print("Enter the amount to deposit: ");
        depositAmount = sc.nextInt();
        
        accounts[index].setBalance(accounts[index].getBalance() + depositAmount);
        accounts[index].setTransactionDatesTypesAndAmounts(depositDate, "Deposit", depositAmount);
        
        System.out.println("\f\n\t\t---Updated Account Details---\n");
        System.out.println("Account number: " + accounts[index].getAccountNumber());
        System.out.println("Account owner: " + accounts[index].getName());
        System.out.println("Deposit date(mm/dd/yyyy): " + depositDate[0] + "/" + depositDate[1] + "/" + depositDate[2]);
        System.out.printf("Cash deposit amount: %.2f\n", depositAmount);
        System.out.printf("Updated account balance: %.2f\n", accounts[index].getBalance());
        System.out.println("Status: " + accounts[index].getStatus());
        enterAnyKeyToContinue();   
    }
    
    public void withdraw()
    {
        int accountNumber, index;
        double withdrawAmount;
        int[] withdrawDate = new int[3];

        do
        {
            char choice;
            
            System.out.println("\f\n\t\t\t\t---Withdrawal---\n");
            System.out.print("Enter your bank account number: ");
            accountNumber = sc.nextInt();
            sc.nextLine();

            index = linearSearch(accountNumber);
            if(index == -1)
            {
                System.out.println("\f\n\t\t\t\t---Withdrawal---\n");
                System.out.print("[Error] The Account number you entered doesn't exist.\nWould you like to try again (y/n)? ");
                choice = sc.next().charAt(0);
                enterAnyKeyToContinue();
                
                if(choice == 'n' || choice == 'N')
                   return;
            }
            else 
                break;
        }while(true);
        
        if(!accounts[index].isActive())
        {
            System.out.println("\f\n\t\t\t\t---Withdrawal---\n");
            System.out.print("[Error] Your account is closed, cannot make transaction.");
            enterAnyKeyToContinue();
            return;
        }
        
        System.out.println("Please enter withdrawal date (digits only)");
        System.out.println("Enter deposit date");
        System.out.print("Enter month: ");
        withdrawDate[0] = sc.nextInt();
        System.out.print("Enter day: ");
        withdrawDate[1] = sc.nextInt();
        System.out.print("Enter year: ");
        withdrawDate[2] = sc.nextInt();
        
        do
        {
            System.out.print("Enter the amount to withdraw: ");
            withdrawAmount = sc.nextDouble();
            
            if(withdrawAmount > accounts[index].getBalance())
                System.out.println("[!] Insufficient funds.");
                
        }while(accounts[index].getBalance() < withdrawAmount);
        
        accounts[index].setBalance(accounts[index].getBalance() - withdrawAmount);
        accounts[index].setTransactionDatesTypesAndAmounts(withdrawDate, "Withdrawal", withdrawAmount);
        
        if(accounts[index].getBalance() == 0)
            accounts[index].setStatus(false);

        System.out.println("\f\n\t\t---Updated Account Details---\n");
        System.out.println("Account number: " + accounts[index].getAccountNumber());
        System.out.println("Account owner: " + accounts[index].getName());
        System.out.println("Withdrawal date(mm/dd/yyyy): " + withdrawDate[0] + "/" + withdrawDate[1] + "/" + withdrawDate[2]);
        System.out.printf("Amount withdrawn: %.2f\n", withdrawAmount);
        System.out.printf("Updated account balance: %.2f\n", accounts[index].getBalance());
        System.out.println("Status: " + accounts[index].getStatus());
        enterAnyKeyToContinue();
    }
    
    public void accountInquiryByNumber()
    {
        int accountNumber, index;
        
        do
        {
            char choice;
            
            System.out.println("\f\n\t\t\t---Inquiry By Account Number---\n");
            System.out.print("Enter your bank account number: ");
            accountNumber = sc.nextInt();
            sc.nextLine();

            index = linearSearch(accountNumber);
            if(index == -1)
            {
                System.out.println("\f\n\t\t\t\t---Inquiry By Account Number---\n");
                System.out.print("[Error] The Account number you entered doesn't exist.\nWould you like to try again (y/n)? ");
                choice = sc.next().charAt(0);
                enterAnyKeyToContinue();
                
                if(choice == 'n' || choice == 'N')
                   return;
            }
            else 
                break;
        }while(true);
        
        displayAccountDetails(index);
        
        System.out.println("\n\t\t---Inquiry By Account Number---\n");
        if(accounts[index].getCounter() <= 0)
        {
            System.out.println("\t\t[Error] Your account has no transaction made yet");
            enterAnyKeyToContinue();
            return;
        }
        
        int[][] transactionDates = accounts[index].getTransactionDates();
        String[] transactionTypes = accounts[index].getTransactionTypes();
        double[] transactionAmounts = accounts[index].getTransactionAmounts();
        
        System.out.println("\n\n\t\t ---Account Details---\n");
        System.out.println("\n Transaction Date\t Transaction Type\t Amount");
        
        for(int i = 0; i < accounts[index].getCounter(); i++)
            System.out.printf("   %d/%d/%-21d %-20s %.2f\n", transactionDates[i][0], transactionDates[i][1], 
                              transactionDates[i][2], transactionTypes[i], transactionAmounts[i]);
        
        enterAnyKeyToContinue();
    }
    
    public void accountInquiryByDate()
    {
        int accountNumber, index;
        int[] startingDate = new int[3];
        int[] lastDate = new int[3];
        boolean isFound = false;
        
        do
        {
            char choice;
            
            System.out.println("\f\n\t\t\t\t---Account Inquiry By Date---\n");
            System.out.print("Enter your bank account number: ");
            accountNumber = sc.nextInt();
            sc.nextLine();

            index = linearSearch(accountNumber);
            if(index == -1)
            {
                System.out.println("\f\n\t\t\t\t---Account Inquiry By Date---\n");
                System.out.print("[Error] Your Account number doesn't exist.\nWould you like to try again (y/n)? ");
                choice = sc.next().charAt(0);
                enterAnyKeyToContinue();
                
                if(choice == 'n' || choice == 'N')
                   return;
            }
            else 
                break;
        }while(true);
        
        displayAccountDetails(index);
        
        System.out.println("\n\t\t\t---Account Inquiry By Date---\n");
        if(accounts[index].getCounter() <= 0)
        {
            System.out.println("\t\t[Error] Your account has no transaction made yet");
            enterAnyKeyToContinue();
            return;
        }
        
        System.out.println("Please enter the starting date and last date");
        System.out.print("Starting date month: ");
        startingDate[0] = sc.nextInt();
        System.out.print("Starting date day: ");
        startingDate[1] = sc.nextInt();
        System.out.print("Starting date year: ");
        startingDate[2] = sc.nextInt();
        System.out.print("Last date month: ");
        lastDate[0] = sc.nextInt();
        System.out.print("Last date day: ");
        lastDate[1] = sc.nextInt();
        System.out.print("Last date year: ");
        lastDate[2] = sc.nextInt();
        
        System.out.println("\n\t\t\t---Account Details---\n");
        System.out.println("\t\t---From: " + startingDate[0] + "/" + startingDate[1] + "/" + startingDate[2] + 
                            " to: " + lastDate[0] + "/" + lastDate[1] + "/" + lastDate[2] + "---");
        System.out.println("\n Transaction Date\t Transaction Type\t Amount");
        
        int[][] transactionDates = accounts[index].getTransactionDates();
        String[] transactionTypes = accounts[index].getTransactionTypes();
        double[] transactionAmounts = accounts[index].getTransactionAmounts();
        
       
        for(int i = 0; i < accounts[index].getCounter(); i++)
        {
            if((transactionDates[i][2] > startingDate[2] ||
               (transactionDates[i][2] == startingDate[2] &&
                transactionDates[i][0] > startingDate[0]) ||
               (transactionDates[i][2] == startingDate[2] &&
                transactionDates[i][0] >= startingDate[0] &&
                transactionDates[i][1] >= startingDate[1])) &&
               (transactionDates[i][2] < lastDate[2] ||
               (transactionDates[i][2] == lastDate[2] &&
                transactionDates[i][0] < lastDate[0]) ||
               (transactionDates[i][2] <= lastDate[2] &&
                transactionDates[i][0] <= lastDate[0] &&
                transactionDates[i][1] <= lastDate[1]))
              )
            {
                System.out.printf("   %d/%d/%-21d %-20s %.2f\n", transactionDates[i][0], transactionDates[i][1], 
                                    transactionDates[i][2], transactionTypes[i], transactionAmounts[i]);
                isFound = true;
            }
        }
        
        if(!isFound)
            System.out.println("\t [Error] There are no transaction found in the given dates."); 
        enterAnyKeyToContinue();
    }
    
    
    public void accountInquiryByStatus()
    {
        String status;
        byte choice;
        boolean isFound = false;
        
        System.out.println("\f\n\t\t\t---Account Inquiry By Status---\n");
        System.out.println("[1] Open\n[2] Closed");
        System.out.print("Select a status of an account to display: ");
        choice = sc.nextByte();
        
        status = choice == 1 ? "Open" : "Closed";

        System.out.println(" Account No.\t\tName\t\t\tAddress\t\t\tBalance");
        for(int i = 0; i < numberOfAccounts; i++)
        {
            if(accounts[i].getStatus().equalsIgnoreCase(status))
            {
                System.out.printf("   %-16d %-25s %-25s %.2f\n", accounts[i].getAccountNumber(), accounts[i].getName(), accounts[i].getAddress(), accounts[i].getBalance());
                isFound = true;
            }
        }
        
        if(!isFound)
            System.out.println("\t\t[Error] There are no " + status + " accounts.");   
        
        enterAnyKeyToContinue();
    }
    
    public void showAllAccounts()
    {
        System.out.println("\f\n\t\t\t\t---All Accounts---");
        
        if(numberOfAccounts <= 0)
        {
            System.out.printf("%54s" ,"[Error]No Accounts Created yet.");
            enterAnyKeyToContinue();
            return;
        }
        
        System.out.println(" Account No.\t\tName\t\t\tAddress\t\t\tBalance");
        for(int i = 0; i < numberOfAccounts; i++){
            System.out.printf("   %-16d %-25s %-25s %.2f\n", accounts[i].getAccountNumber(), accounts[i].getName(), accounts[i].getAddress(), accounts[i].getBalance());
        }
        enterAnyKeyToContinue();
    }
    
    public void changeAccountStatus()
    {
        int accountNumber, index;
        char choice;
        
        do
        {   
            System.out.println("\f\n\t\t\t\t---Change Account Status---\n");
            System.out.print("Enter your bank account number: ");
            accountNumber = sc.nextInt();
            sc.nextLine();

            index = linearSearch(accountNumber);
            if(index == -1)
            {
                System.out.println("\f\n\t\t\t\t---Change Account Status---\n");
                System.out.print("[Error] Your Account number doesn't exist.\nWould you like to try again (y/n)? ");
                choice = sc.next().charAt(0);
                enterAnyKeyToContinue();
                
                if(choice == 'n' || choice == 'N')
                   return;
            }
            else 
                break;
        }while(true);
        
        displayAccountDetails(index);
        
        if(accounts[index].isActive())
        {
            while(true)
            {
                System.out.print("\nYour account is currently open. Do you want to close it(y/n)? ");
                choice = sc.next().charAt(0);
                
                if(choice == 'y' || choice == 'Y')
                {
                    System.out.println("\n\t\t---Account successfuly closed---");
                    accounts[index].setStatus(false);
                    enterAnyKeyToContinue();
                    return;
                }
                else if(choice == 'n' || choice == 'N')
                {
                    enterAnyKeyToContinue();
                    return;
                }
            }
        }
        else
        {
            while(true)
            {
                System.out.print("\nYour account is currently closed. Do you want to open it(y/n)? ");
                choice = sc.next().charAt(0);
                
                if(choice == 'y' || choice == 'Y')
                {
                    System.out.println("\n\t\t---Account successfuly opened---");
                    accounts[index].setStatus(true);
                    enterAnyKeyToContinue();
                    return;
                }
                if(choice == 'n' || choice == 'N')
                {
                    enterAnyKeyToContinue();
                    return;
                }
            }
        }
    }
    
    private void displayAccountDetails(int index)
    {
        System.out.println("\f\n\t\t---Account Details---\n");
        System.out.println("Account number: " + accounts[index].getAccountNumber());
        System.out.println("Account owner: " + accounts[index].getName());
        System.out.println("Gender: " + accounts[index].getGender());
        System.out.println("Date account opened: " + accounts[index].getDateOpened());
        System.out.println("Address: " + accounts[index].getAddress());
        System.out.printf("Account balance: %.2f\n", accounts[index].getBalance());
        System.out.println("Status: " + accounts[index].getStatus());
    }

    private int generateAccountNumber()
    {
        SecureRandom secureRandomNumber = new SecureRandom();
        
        int max = 999;
        int min = 111;
        int randomNumber;
        boolean isNotUnique = true;
        
        do
        {
            randomNumber = (int)(secureRandomNumber.nextInt(max-min+1)+min);
            isNotUnique = binarySearch(randomNumber) == 1 ? true: false;
        }while(isNotUnique);
        
        return randomNumber;
    }
    
    private int binarySearch(int key)
    {
        int first = 0;
        int last = numberOfAccounts;
        int mid = (first + last) / 2;

        sortAscending();
        
        if(numberOfAccounts <= 1)
            return 0;
            
        while(first <= last)
        {
            if(accounts[mid].getAccountNumber() == key)
                return 1;
            else if(accounts[mid].getAccountNumber() < key)
                first = mid + 1;
            else
                last = mid - 1;
                
            mid = (first + last) / 2;
        }
        
        return 0;
    }
    
    private int linearSearch(int key)
    {
        for(int i = 0; i < numberOfAccounts; i++)
            if(accounts[i].getAccountNumber() == key)
                return i;
        
        return -1;
    }
    
    private void sortAscending()
    {
        if(numberOfAccounts <= 1)
            return;
        
        Account temp = new Account();
        boolean isFound = true;
        
        for(int i = 0; i < numberOfAccounts && isFound; i++)
        {
            isFound = false;

            for(int j = 0; j < numberOfAccounts; j++)
            {
                if(accounts[j].getAccountNumber() < accounts[j+1].getAccountNumber())
                {
                    temp = accounts[j];
                    accounts[j] = accounts[j+1];
                    accounts[j+1] = temp;
                    isFound = true;
                }    
            }
        }
    }
    
    private void enterAnyKeyToContinue()
    {
        System.out.printf("\n\n%54s", "Enter any key to continue");
        sc.nextLine();
        sc.nextLine();
    }
    
}