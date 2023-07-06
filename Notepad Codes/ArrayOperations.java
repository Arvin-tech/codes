/**
 * This program will perform the insert, delete, search, and modify operations.
 */
import java.util.Scanner;
public class ArrayOperations {
    static Scanner kb = new Scanner (System.in);
    public static void main () {
        int [] num = new int [5];
        int response;
        int count = 0; //this will count the number of values stored in the array
        System.out.println ("\f");
        do {
            System.out.println ("Menu\n1. insert beginning\n2. insert end" 
                                +"\n3. delete beginning\n4. delete end"
                                +"\n5. search value\n6. modify"
                                +"\n0. Exit\n7. display all" +
                    "\n0. Exit\nEnter your choice: ");
            response = kb.nextInt ();
            
            switch (response) {
            case 1: count = insertBeginning (num, count); //method call
                    displayAll (num, count);    //method call
                    break;
            case 2: count = insertAtEnd (num, count); //method call
                    displayAll (num, count);    //method call
                    break;       
            case 3: count = deleteBeginning (num, count); //method call
                    displayAll (num, count);    //method call
                    break;       
            case 4: count = deleteAtEnd (num, count); //method call
                    displayAll (num, count);    //method call
                    break;  
            case 5: if (searchByValue (num, count)) {
                        System.out.println ("\nSearched value is in the array...");
                    }
                    else {
                        System.out.println ("\nValue is not found...");
                    }
                    break;
            case 6: modifyValue (num, count);
                    displayAll (num, count);    //method call
                    break;
            case 0: System.out.println ("Program ended normally.");
            }
        }while (response != 0);
    }
        //method definitions
        public static void  modifyValue (int []num, int count) {
            int tempNum;
            boolean found=false;
            System.out.println ("\nEnter value to be modified: ");
            tempNum = kb.nextInt ();
            
            //to perform the search, you must traverse from the beginning to the end elements of the array
            for (int index=0; index < count; index++) {
                if (tempNum == num[index]){ //search part
                    System.out.println ("\nNew value: ");
                    int newVal = kb.nextInt();
                    num[index] = newVal;
                    found = true;
                }
            }//end for loop  
            if (!found)
                System.out.println ("\nCannot modify. Value is not found.");
        }
        public static int insertBeginning (int[] num, int count) {
            System.out.println ("\nEnter a number: ");
            int tempNum = kb.nextInt ();
            
            if (count == num.length) // if true, this is the first value
                System.out.println ("\nArray is already full...");
            else if (count == 0) // if true, this is the first value
                num [count++] = tempNum;
            else {
                //shift the values in the array 1 element to the right
                for (int index=count; index > 0; index--)
                    num[index] = num[index-1];
                //at the end of for loop
                //copy the new value to the first element
                num [0] = tempNum;
                count++;    //increment array counter by 1
            }
            return count;
        }//end of insertBeginning method
        
        public static int insertAtEnd (int[] num, int count) {
            System.out.println ("\nEnter a number: ");
            int tempNum = kb.nextInt ();
            
            if (count == num.length) // if true, this is the first value
                System.out.println ("\nArray is already full...");
            else {
                num[count++]=tempNum;    //store the value & increment array counter by 1
            }
            return count;
        }//end of insertAtEnd method
        
        public static int deleteBeginning (int[] num, int count) {
            
            if (count==0)
                System.out.println ("\nArray is empty. Cannot delete.");
            else {
            for (int index = 0; index < count-1; index++) 
               num[index] = num[index+1];  //move array values one element to the left  
            //set the last index with value to zero
            num[--count]=0;
            }
           return count;
        }
        public static int deleteAtEnd (int[] num, int count) {
            if (count==0)
                System.out.println ("\nArray is empty. Cannot delete.");
            else {
                num[--count]=0;    
            }
            return count;
                
        }
        public static boolean searchByValue (int[] num, int count) {
            int tempNum;
            
            System.out.println ("\nEnter value to be searched: ");
            tempNum = kb.nextInt ();
            
            //to perform the search, you must traverse from the beginning to the end elements of the array
            for (int index=0; index < count; index++) {
                if (tempNum == num[index]) //search part
                    return true;
            }//end for loop
            //value is not found if the loop exits normally            
            return false;
        }
        public static void displayAll (int[] num, int count) {
            System.out.println ("\nArray values are:");
            for (int index = 0; index < count; index++) {
                System.out.println ("[" + index + "]: " +
                                    num [index]); 
            }
        }
    
}