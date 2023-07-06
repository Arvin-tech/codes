public class ListOperations
{
    Node head, tail;    
    ListOperations () {
        head = tail = null;
    }
    public void insertBeginning (String id, String name, String course) {
        head = new Node (id, name, course, head);        
    }
    public void deleteById (String id) {
        Node del = head;
        if (head != null) {
        for (Node temp=head; temp!=null; del = temp, temp=temp.link) {
            if (temp.id.equals(id))
            {
                del.link = temp.link; //delete statement
                
            }
        }
    }
    }
    public void insertEnd (String id, String name, String course) {
        Node temp;
        if (head != null)
        {
            //check if there is only one node in the list
            if (head.link == null) {
                head.link = new Node (id, name, course, null);
            }
            else {
            //traverse until the last node is found
            for (temp=head; temp.link != null; temp=temp.link);
            //insert new node at the end
            temp.link = new Node (id, name, course, null);
            }
        }
    }

    public void insertEndWithTail (String id, String name, String course) {
        if (head == null)
            head = tail = new Node (id, name, course, null);
        else {
            tail.link = new Node (id, name, course, null);        
            tail = tail.link;
        }
    }
    
    public boolean isElement (String id) {
        if (head == null)
            return false;
        else  {
        for (Node temp=head; temp!=null; temp=temp.link) {
            if (temp.id.equals(id))
                return true;
        }
    }
        return false;
    }    
    public void deleteBeginning () {
        if (head != null) {
            System.out.println ("One value deleted> " + head.id);
            head = head.link;
            
        }
        else
            System.out.println ("\nList is empty.");
    }
    public void deleteEnd () {
        Node temp;
        if (head != null)
        {
            //check if there is only one node in the list
            if (head.link == null) {
                head = tail = head.link;
            }
            else {
            //traverse until second to the last node
            for (temp=head; temp.link != tail; temp=temp.link);
            
            //after reaching the second to the last node
            //perform the delete at the end of the list
            temp.link = null;
            tail = temp;
            }
        }
    }
    public void displayAll () {
        Node temp;
        System.out.println ("\nList values:");
        for (temp=head; temp!=null; temp=temp.link) {
            System.out.printf ("\n%-7s%-15s%-5s", temp.id, temp.name, temp.course);
        }
    }
    public boolean isEmpty () {
        return head == null;
    }
}

-----------------------------------------------------
import java.util.*;
public class MainList{
    public static void main (){
        Scanner sc = new Scanner (System.in);
        ListOperations linkedOperations = new ListOperations();
        String id, name, course;
        int operations;
        do{    
            System.out.println("\f\tMenu" +
            "\n1.) Insert String in the Beginning"+
            "\n2.) Delete by ID"+
            "\n3.) Insert at End"+
            "\n4.) Insert End With Tail"+
            "\n5.) Is an Element"+
            "\n6.) Inquiry by Status"+
            "\n7.) Show All Accounts"+
            "\n8.) Change Account Status"+
            "\n9.) Exit\n Your choice: ");
            
            operations = sc.nextInt();
            switch(operations){
                case 1: System.out.println("Insert at the beginning");
                        System.out.print("Enter id: ");
                        id = sc.next();
                        sc.nextLine();
                         
                        System.out.print("Enter the name: ");
                        name = sc.nextLine();
                        System.out.print("Enter the course: ");
                        course = sc.nextLine();
                        linkedOperations.insertBeginning(id, name, course);
                        
                        System.out.print("Press any key to continue");
                        sc.nextLine();
                    break;
                case 2: System.out.println("Deleting by ID");
                        System.out.print("Enter id: ");
                        id = sc.next();
                        linkedOperations.deleteById(id);
                        
                        System.out.print("Press any key to continue");
                        sc.nextLine();
                        sc.nextLine();
                    break;
                case 3: System.out.println("Insert at the end");
                        System.out.print("Enter id: ");
                        id = sc.next();
                        sc.nextLine();
                        
                        System.out.print("Enter name: ");
                        name = sc.nextLine();
                        System.out.print("Enter course: ");
                        course = sc.nextLine();
                        linkedOperations.insertEnd(id, name, course);
                        
                        System.out.print("Press any key to continue");
                        sc.nextLine();
                    break;
                case 4: System.out.println("-Insert end with tail");
                        System.out.print("Enter id: ");
                        id = sc.next();
                        sc.nextLine();
                        
                        System.out.print("Enter name: ");
                        name = sc.nextLine();
                        System.out.print("Enter course: ");
                        course = sc.nextLine();
                        linkedOperations.insertEndWithTail(id, name, course);
                        
                        System.out.print("Press any key to continue");
                        sc.nextLine();
                        sc.nextLine();
                    break;
                case 5: System.out.println("Check if ID exists"); 
                        System.out.print("Enter id: ");
                        id = sc.next();
                        
                        if(linkedOperations.isElement(id)){
                            System.out.println("\n\n\t-ID exists-");
                        }else{
                            System.out.println("Sorry! ID does not exist");
                        }
                        
                        System.out.print("Press any key to continue");
                        sc.nextLine();
                        sc.nextLine();
                    break;
                case 6: System.out.println("Deleting the first node");
                        linkedOperations.deleteBeginning();
                        
                        System.out.print("Press any key to continue");
                        sc.nextLine();
                        sc.nextLine();
                    break;
                case 7: System.out.println("Deleting the last node");
                        linkedOperations.deleteEnd();
                        
                        System.out.print("Press any key to continue");
                        sc.nextLine();
                        sc.nextLine();
                    break;
                case 8: System.out.println("Displaying all");
                        linkedOperations.displayAll();
                        
                        System.out.print("Press any key to continue");
                        sc.nextLine();
                        sc.nextLine();
                    break;
                case 9: System.out.println("Checking if the list is empty or not");
                        if(linkedOperations.isEmpty()){
                            System.out.println("List is empty");
                        }else{
                            System.out.println("List is not empty");
                        }
                        
                        System.out.print("Press any key to continue");
                        sc.nextLine();
                        sc.nextLine();
                    break;
                case 10: System.out.println("End of Program");
                    break;
            }
        }while(operations!= 10);
    }
}

---------------------------------------------------------------
/**
 * class Node declares the data and operations of the list.
 *
 * @author (Data Structure)
 * @version (July 7, 2020)
 */

public class Node{
    String id;
    String name;
    String course;
    Node link;
    Node () {
        id = name = course = "";
        link = null;
    }
    Node (String id, String name, String course, Node link) {
        this.id = id;
        this.name = name;
        this.course = course;
        this.link = link;
    }
}






-----------------------------------------------------------------
/** ARRAY ASSIGNMENT
* This program will allow the user to:
* - Insert number at the beginning
* - Insert number at the end
* - Delete number at the beginning
* - Delete number at the end
* - Display all numbers
* NEW UPDATE ADDED!:
* - will insert a number in a given location
* - delete a number in any location
* - delete a given number if it is in the array
*
* @author (J. S. Ugang)-----Improved (J.A. Coronel)
* @version (June 24, 2020)
*/
import java.util.Scanner;
public class Array {
      static Scanner kb = new Scanner (System.in);
        public static void main() {
            int [] num = new int [100];
            int[] arraycopy = new int[101];/*newly added variable*/
            int counter=0;
            int choice=0;
            int numCount=0;
            int value, arrayIndex, element;/*newly added variables*/
                
            System.out.println ("\f");        
            do {
                System.out.print ("\nMenu \n1-Input \n2-Display" +
                                      "\n3-Insert Beginning" +
                                      "\n4-Delete at the End" +
                                      "\n5-Delete at the Beginning" +
                                      "\n6-Insert a number in a given location"+
                                      "\n7-Delete a number in any location"+
                                      "\n8-Delete a given number if it is in the array"+
                                      "\n0-Exit"+
                                    "\nEnter your choice: ");
                choice = kb.nextInt();
                switch (choice) {
                        case 1: System.out.print ("\nEnter how many numbers: ");
                                numCount = kb.nextInt();
                                System.out.println ("\nPlease enter " + numCount + " integers.");
                                for (int k=0; k<numCount; k++)
                                   num[counter++]=kb.nextInt();
                            break;
                        case 2: System.out.println ("\nNumbers in the array: ");
                                for (int k=0; k<counter; k++) 
                                    System.out.println ("[" + k + "]: " + num[k]); 
                            break;
                        case 3:  System.out.println ("\nThis will insert at the beginning" +
                                                     "\nInput number: ");
                                 for (int k=counter; k > 0; k--)
                                      num[k]=num[k-1];
                                 num[0] = kb.nextInt(); 
                            break;
                        case 4: System.out.println ("\nLast number deleted - " +
                                                    num[counter-1]);
                                                    num[counter--]=0;
                            break;
                        case 5: System.out.println ("\nBeginning number deleted - " +
                                                    num[0]);
                                for (int k=0; k<counter; k++)     
                                     num[k]=num[k+1];
                                num[--counter]=0;
                            break;
                        case 6:
                                System.out.println("Enter the number to be inserted: ");
                                value = kb.nextInt();
                                System.out.println("Enter the location: ");
                                arrayIndex = kb.nextInt();
                                for(int k= 0; k < counter; k++) {
                                    if(num[k] != 0) {
                                        numCount++;
                                    }
                                }
                                if(numCount == 100) {
                                    System.out.println("Memory is already full!");
                                } else {
                                    for(int i = 0; i < counter; i++) {
                                        arraycopy[i] = num[i];
                                    }
                                    for(int j = counter; j > arrayIndex; j--) {
                                        arraycopy[j] = arraycopy[j-1];
                                    }
                                    arraycopy[arrayIndex] = value;
                                    for(int i = 0; i < num.length; i++) {
                                        num[i] = arraycopy[i];
                                    }
                                }
                                numCount = 0;
                                break;
                        case 7:
                                System.out.println("Enter the location: ");
                                arrayIndex = kb.nextInt();
                                if(arrayIndex == num.length) {
                                    num[arrayIndex] = 0;
                                } else {
                                    for(int i = 0; i < num.length; i++) {
                                        arraycopy[i] = num[i];
                                    }
                                    for(int j = arrayIndex; j < num.length; j++) {
                                        arraycopy[j] = arraycopy[j+1];
                                    }
                                    for(int i = 0; i < num.length; i++) {
                                        num[i] = arraycopy[i];
                                    }
                                } 
                                break;
                        case 8:
                                System.out.print("Enter the value to be deleted in the array : ");
                                element=kb.nextInt();
                                for(int i = 0; i < num.length; i++){
                                    if(num[i]==element){
                                        for(int j = i; j < num.length - 1; j++){
                                               num[j] = num[j+1];
                                        }
                                        break;
                                    }
                                }
                                break;
                }
            }while (choice !=0);       
            System.out.print ("\nEnd of the program.");
       }
}
/*Juano Antonio Coronel - Array Sample Program Menu Driven.txt
*Displaying Juano Antonio Coronel - Array Sample Program Menu Driven.txt.*/



--------------------------------------------------------------------------------------
/**  ARRAY QUIZ
 * Write a Java program that can store 500 integers in a single dimensional array.
 * Be able to perform the following operations.
 * A. Insert - This operation will insert the number at the beginning if the number is divisible by 3. 
 *             It will insert at the end if the number is divisible by 5. Otherwise, it will insert the number in the given location.
 * B. Delete Target - The user will input a number to be deleted. If the number is found, delete all occurrences of the number. 
 *                    Otherwise, display an error message.
 * C. Delete Range - The user will input a range of value (make sure that first value is lesser than the second). 
 *                   Your program should delete all values within the specified range. If no match is found, display an error message.
 * D. Search Target - The user will input a number to be searched. If found, display all the locations of the given number.
 *                    If no match is found, display an error message.
 * E. Count Odd/Even/Prime - This will display how many are odd numbers, even numbers and prime numbers found in the array. 
 * F. Exit - This will terminate the program
 * 
 * Note: Numbers should be stored continuously, meaning, there is no gap in between elements. 
 * Display necessary messages such as, "array is empty", "end of the program", and some others.
 * @author (M. V. Cane)
 * @version (June 29, 2020)
 */
import java.util.Scanner;

public class ArrayQuiz_June292020
{
    public static void main(String[] args)
    {
        Scanner kb = new Scanner(System.in);
        
        int[] inputs = new int[500];
        int input, location, counter = 0;
        char choice;
        boolean isFound;
        
        System.out.print("\f");
        
        do
        {
            isFound = false;
            
            System.out.println("\nMenu");
            System.out.println("a. Insert" + "\nb. Delete Target");
            System.out.println("c. Delete Range" + "\nd. Search Target");
            System.out.println("e. Count Odd/Even/Prime" + "\nf. Exit ");
            System.out.print("Your choice: ");
            choice = kb.next().charAt(0);
            System.out.println();
            
            switch(choice)
            {
                case 'A':
                case 'a':
                        System.out.print("Insert a number: ");
                        input = kb.nextInt();
                        
                        if(input % 3 != 0)
                        {
                            for(int i = counter++; i > 0; i--)
                                inputs[i] = inputs[i-1];

                            inputs[0] = input;
                        }
                        else if(input % 5 == 0)
                        {    
                            inputs[counter++] = input;
                        }
                        else
                        {
                            do
                            {
                            System.out.print("Select a location to insert the value: ");
                            location = kb.nextInt();
                            
                            if(location > counter+1)
                                System.out.println("\n[Error]The location must be between the first and last elements.\n");
                            }while(location > counter+1);
                            
                            for(int i = counter++; i > location-1; i--)
                                inputs[i] = inputs[i-1];
                            
                            inputs[location-1] = input;    
                        }
                    break;  
                case 'B': 
                case 'b':        
                        if(counter == 0)
                        {
                            System.out.println("\n[Error] Array is empty");
                            break;
                        }
                        
                        System.out.print("Delete a number: ");
                        input = kb.nextInt();
                        
                        for(int i = 0; i < counter; i++)
                        {
                            if(inputs[i] == input)
                            {
                                for(int k = i; k < counter; k++)
                                    inputs[k] = inputs[k+1];
                                
                                counter--;
                                i--;
                                isFound = true;
                            }
                        }
                        
                        if(!isFound)
                            System.out.println("\n[Error] No match found");
                    break;
                case 'C': 
                case 'c':
                        int min, max;

                        if(counter == 0)
                        {
                            System.out.println("\n[Error] Array is empty");
                            break;
                        }
                       
                        do
                        {
                            System.out.println("Delete a range of values: ");
                            System.out.print(" Minimum value: ");
                            min = kb.nextInt();
                            System.out.print(" Maximum value: ");
                            max = kb.nextInt();
                            
                            if(min > max)
                                System.out.println("The minimum value must be lesser than the maximum value.");
                        }while(min > max);
                        
                        for(int i = 0; i < counter; i++)
                        {
                            if(inputs[i] >= min && inputs[i] <= max)
                            {
                                for(int k = i; k < counter; k++)
                                    inputs[k] = inputs[k+1];
                                
                                counter--;
                                i--;
                                isFound = true;
                            }
                        }
                        
                        if(!isFound)
                            System.out.println("\n[Error] No match found");
                    break;
                case 'D': 
                case 'd':
                        if(counter == 0)
                        {
                            System.out.println("\n[Error] Array is empty");
                            break;
                        }
                        
                        System.out.print("Search Target: ");
                        input = kb.nextInt();
                        
                        System.out.println("Locations of the value: ");
                        for(int i = 0; i < counter; i++)
                        {
                            if(inputs[i] == input)
                            {
                                System.out.println("Location " + (i+1));
                                
                                isFound = true;
                            }    
                        }
                        
                        if(!isFound)
                            System.out.println("\n[Error] No match found");
                    break;
                case 'E':
                case 'e':
                        int odd = 0, even = 0, prime = 0;
                        boolean isPrime;
                        
                        if(counter == 0)
                        {
                            System.out.println("\n[Error] Array is empty");
                            break;
                        }
                        
                        System.out.println("Count Odd/Even/Prime:");
                        for(int i = 0; i < counter; i++)
                        {
                            isPrime = true;
                            
                            if(inputs[i] % 2 == 0)
                                even++;
                            else
                                odd++; 
                            
                            if(inputs[i] <= 1)
                                continue;
                            for(int k = 2; k <= inputs[i]/2; k++)
                            {
                                if(inputs[i] % k == 0)
                                {
                                    isPrime = false;
                                    break;
                                }
                            }
                            
                            if(isPrime)
                                prime++;
                        }
                        System.out.println("Odd numbers: " + odd + "\nEven numbers: " + even + "\nPrime numbers: " + prime);
                        
                    break;
                case 'F':
                case 'f':
                    break;        
                default: System.out.println("[Error] Invalid choice");
            }
        }while(choice != 'f');
        
        System.out.print("\n====End of program====");
    }
}
