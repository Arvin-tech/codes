
/**
 * Write a description of class ArrayOfEmployees here.
 *
 * 
 * @version Midterm Activity 2
 */
import java.util.*;
public class ArrayOfEmployees
{
    static Scanner kb = new Scanner (System.in);
    static int numcounter = 0;
    public static void main ( ) {

        final int SIZE = 100;
        
        String [ ] empID = new String [SIZE];             //array of employee's id
        String [ ] empName = new String [SIZE];           //array of employee's name
        double [ ] empSal = new double [SIZE];            //array of employee's salary
        double sal = 9000;
        int response = 0;

        System.out.println ("\fInput " + SIZE + " of Employees' Records");
        System.out.print("Enter number of employees to check: ");
        numcounter = kb.nextInt();
        accept (empID, empName, empSal);

        System.out.println("\nUnsorted lists output: ");
        displayAllEmp (empID, empName, empSal);

        do {
            System.out.println ("\nEmployee ID is found in location " + searchByID (empID, empName, empSal));           
            System.out.println ("\nThere are " + countEmpSalary (empSal, sal) + "  whose salary is above " + sal);
            System.out.println ("\nReapeat? Press [0] to stop. >>> ");
            response = kb.nextInt();
        }while (response != 0);

        sortBySalaryInDescending (empID, empName, empSal);                  
        System.out.println ("\nSorted lists output by Employee's Salary in Descending Order");
        displayAllEmp (empID, empName, empSal);

        sortByEmpNameInAscending (empID, empName, empSal);
        System.out.println ("\nSorted lists output by Employee's Name in Ascending Order");
        displayAllEmp (empID, empName, empSal);

        do {
            System.out.println ("\nEmployee's name is found in location " + searchByName (empID, empName, empSal));                  
            System.out.println ("\nThere are " + countEmpSalary (empSal, sal) + "  whose salary is above " + sal);
            deleteSpecificEmpByID (empID, empName, empSal);
            System.out.println ("\nReapeat? Press [0] to stop. >>> ");
            response = kb.nextInt();
        }while (response != 0);    
        
        //closing prompt
        System.out.println("Program closing...");
    }//End of method main
    
    //Method Descriptions 
    public static void accept (String empID[], String empName[], double empSal[]){ 
        String tempID = " ";
        System.out.print("\nInput "+numcounter+" of employees record: ");
        for(int i = 0; i < numcounter; i++){
            System.out.print("\n"+"["+i+"] Enter name of Employee: ");
            empName[i] = kb.next();
            
            do{
                System.out.print("[" + i + "] Enter ID Number (8-Digits): ");
                tempID = kb.next();
                if(tempID.length() == 8){
                    empID[i] = tempID;
                }
                else{
                    System.out.println("Invalid ID!");
                }
            }
            while(!(tempID.length()==8));
            
            System.out.print("["+ i + "]Input employee salary ");
            empSal[i] = kb.nextDouble();

        }
    }

    public static void displayAllEmp (String empID[], String empName[], double empSal[]){    
        System.out.print("\nList of Employees' Records ");
        for(int i = 0; i < numcounter; i++){
            System.out.println("\nName: " + empName[i]);
            System.out.println("\nID Number: "+empID[i]); 
            System.out.println("\nSalary: "+empSal[i]);
        }
    }

    public static int searchByID (String empID[], String empName[], double empSal[]){     
        String tempID; 
        System.out.print("Enter Employee ID Number to Search: ");
        tempID = kb.next();
        for(int i = 0; i < numcounter; i++){
            if(empID[i].equalsIgnoreCase(tempID)){
                System.out.println("Employee ID number found.");
                System.out.println("\nName: " + empName[i]);
                System.out.println("\nID Number: "+empID[i]); 
                System.out.println("\nSalary: "+empSal[i]);
                return i;
            }
        }
        System.out.println("\nID number not found!");//prompt
        return -1;		
    }

    public static int searchByName (String empID[], String empName[], double empSal[]){   
        int begin = 0; //index 0
        int end = numcounter; 
        System.out.print("\nSearch Employee Name: ");
        String tempName = kb.next();
        while( begin <= end){
            int mid = (begin + end)/ 2; 
            int temp = tempName.compareTo(empName[mid]);
            if(temp == 0){
                System.out.println("Employee name found: "); //found prompt
                System.out.println("\nName: "+empName[begin]);
                System.out.println("\nID Number: "+empID[mid]);
                System.out.println("\nSalary: "+empSal[mid]);
                return mid;
            }
            else if(temp > 0){
                begin = mid + 1;
            }
            else{
                end = mid - 1;
            }
        }
        return -99;   
    }

    public static double countEmpSalary (double empSal[], double sal){ // – 5 points
        int count = 0;
        for(int i  = 0; i < empSal.length; i++){
            if(empSal[i] >= sal){
                count++; //count employee salary
            }
        }
        return count;
    }
    

    public static void sortBySalaryInDescending (String empID[], String empName[], double empSal[]){    
        int val,x,y;
        for(int i = 0; i < numcounter; i++){
            val = i;
            for(int  j = 0; j < numcounter; j++){
                if(empSal[val] > empSal[j]){
                    val = j;
                }
                double temp = empSal[i];
                String tempS = empID[i];
                String tempS1 = empName[i];

                empSal[i] = empSal[val];
                empID[i] = empID[val];
                empName[i] = empName[val];

                empSal[val] = temp;
                empID[val] = tempS;
                empName[val] = tempS1;
            }
        }
    }

    public static void sortByEmpNameInAscending (String empID[], String empName[], double empSal[]){ 
        boolean flag;
        do {
            flag = false;
            for (int i = 0; i < numcounter - 1; i++){
                if (empName[i].compareTo (empName[i + 1]) > 0){
                    String tempName = empName[i];
                    empName[i] = empName[i + 1];
                    empName[i+1]=tempName;

                    String tempID = empID[i];
                    empID[i] = empID[i + 1];
                    empID[i+1] = tempID;

                    double tempSal = empSal[i];
                    empSal[i] = empSal[i + 1];
                    empSal[i + 1] = tempSal;
                    flag=true;
                }   
            }            
        }while(flag);
        
    }

    public static void deleteSpecificEmpByID (String empID[], String empName[], double empSal[]){ 
        String tempID;
        boolean found=false;
        System.out.print("\nDelete Employee ID Number: ");
        tempID = kb.next();
        for (int i = 0; i < numcounter; i++) {
            if (empID[i].equalsIgnoreCase(tempID)){
                System.out.println("Employee ID number found: ");//found prompt
                System.out.print("\nName: " +empName[i]+ "\nID number: " +empID[i]+ "\nSalary: "+empSal[i]+
                    "\nSuccessfully removed in employee records!");
                found = true;
                
                empName[i] = "";
                empID[i] = "";
                empSal[i] = 0.0;
            }
        }
        numcounter--;
        if (!found){
            System.out.println("\nID number not found!"); //prompt
        }  
    }
    

}

