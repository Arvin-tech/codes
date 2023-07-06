//Node definition
 public class Node
 {
   int num;      //instance variable
   Node next;    //refence to the next Node
   Node (int num, Node next) {
     this.num=num; this.next=next;  
   }
 }
 
 public class ListOperations
 {
   Node head;    //first node reference
   Node tail;    //last node reference
   ListOperations () {
     head=tail=null;  
   }
   //method to add new number to the list
   public void addNew (int num) {
     //add num at the beginning
     if (head==null) {
       head=tail=new Node (num, null);
     }
     else {
       head = new Node (num, head);
     }
   } //end of addNew method
   //method to add new number at the end of the list
   public void addLast (int num) {
     if (head==null) {
       head=tail=new Node (num, null);
     }
     else {
       tail.next = new Node (num, null);
       tail = tail.next;
     }
   }
   //search for a specific number
   public boolean isCheck(int num) {
     for (Node temp=head; temp!=null; temp=temp.next) {
        if (num == temp.num)
          return true;
     }  
     //outside for
     return false;
   } //end of isCheck method
   //count occurences of a particular number
   public int countNumbers (int num) {
     int count=0;
     for (Node temp=head; temp!=null; temp=temp.next) {
        if (num == temp.num)
          count++;
     }  
     return count;
   } //end of countNumbers method
   //display all method
   public void displayAll () {
     System.out.println ("List of values:");
     for (Node temp=head; temp!=null; temp=temp.next)
       System.out.print (" " + temp.num);
   }
 }
 
 
 import java.util.*;
 public class Practicer_LinkedLists
 {
   static Scanner kb = new Scanner (System.in);
   public static void main () {
     int num;
     ListOperations list = new ListOperations ();
      System.out.print ("\f");
     do {
       System.out.print ("Input number: ");
       num = kb.nextInt();
       if (num == 0)
        break;
       //if false, call addNew method
       //list.addNew (num);
       //if false, call addLast
       list.addLast(num);
     } while (true);
     //call displayAll method
     list.displayAll();
     System.out.print ("\n\nEnter number to search: ");
     num = kb.nextInt();
     if (list.isCheck(num))
       System.out.print ("Number found...");
     else
       System.out.print ("Number NOT found...");
       
     System.out.println ("\n\nNumber " + num + 
           " occured " + list.countNumbers(num) + " times.");
   }
 }
 
 //delete at the end
   public void deleteEnd () {
     //check if list is empty
     if (head==null)
        System.out.println ("\nCannot delete. List is empty...");
     else if (head.next==null) //only one node is in the list
        head = tail = null;
     else {
        Node temp;
        //traverse in the list until you reach the 2nd to the last node...  
        for (temp=head; temp.next.next!=null; temp=temp.next); //bodyless for loop...
           //System.out.println ("\nLast two values in the list: " + temp.num + " " + temp.next.num);
           temp.next = null;
           tail = temp;
     }
     
   }
   
  
--------------------------------------

SCRATCH...

   if (head==null) {
      head=tail=new Node (num, null);
    }
    else {
      tail.next = new Node (num, null);
      tail = tail.next;
    }

*****list is empty
 head=tail=new Node (num, null);

Step 1: Create new node
* 4000

Step 2: Execute the constructor (Assign values for num and next)
* (12, null)

Step 3: point head & tail to the newly created node

****list is  not empty
 tail.next = new Node (num, null);
 tail = tail.next;

Step 1: create new Node
* 2500
* 1700
* 1750

Step 2: Execute the constructor
* (23, null)
* (17, null)
* (45, null)

Step 3: assign the new node to tail.next

Step 4: poin tail node to the newly created node
===========================================================

 if (head==null) {
      head=tail=new Node (num, null);
    }
    else {
      head = new Node (num, head);
    }
  } //end of addNew method

*****list is empty
 head=tail=new Node (num, null);

Step 1: Create new node
* 1500

Step 2: Execute the constructor (Assign values for num and next)
* (12, null)

Step 3: point head & tail to the newly created node

* list is no longer empty
Step 1: Create new node
* 3200
* 1400
* 2200

Step 2: Execute the constructor
* (23, 1500)
* (17, 3200)
* (24, 1400)

Step 3: Point the head reference to the newly created node
  