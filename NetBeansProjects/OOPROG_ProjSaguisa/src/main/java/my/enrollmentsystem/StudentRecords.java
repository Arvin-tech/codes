/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.enrollmentsystem;

/**
 *
 * @author Acer
 */
public class StudentRecords {
    private static String[] IdNumber = new String[9999];
    private static String[] LastName = new String[9999];
    private static String[] FirstName = new String[9999];
    private static String[] MiddleInitial = new String[9999];
    private static String[] Course = new String[9999];
    private static String[] Year = new String[9999];
    private static String Status[] = new String[9999]; 
    
    private static int[] count = new int[9999];
    private static int StudentRecordCount = 0;

    //counters
    public static int setCount(){
        return StudentRecordCount;
    }
    
    public static void getCount(int num){
        StudentRecordCount = num;
    }
    
    public static int  setCount1(int i){
        return count[i];
    }
    
    public static void getCount1(int num, int i){
        count[num] = i;
    }
    //data
    
    public static String setID(int i){
        return IdNumber[i];
    }
    
    public static void getID(String s, int i){
        IdNumber[i] = s;
    }
    
    public static String setlastname(int i){
        return LastName[i];
    }
    
    public static void getlastname(String s, int i){
        LastName[i] = s;
    }
    
    public static String setfirstname(int i){
        return FirstName[i];
    }
    
    public static void getfirstname(String s, int i){
        FirstName[i] = s;
    }
    
    public static String setMiddle(int i){
        return MiddleInitial[i];
    }
    
    public static void getMiddle(String s, int i){
        MiddleInitial[i] = s;
    }
    
    public static String setCourse(int i){
        return Course[i];
        
    }
    
    public static void getCourse(String s, int i){
        Course[i] = s;
    }  
    
    public static String setYear(int i){
        return Year[i];
    }
    
    public static void getYear(String s, int i){
        Year[i] = s;
    }
    
    static String setStatus(int i){
       return Status[i];
    }
    
    static void getStatus(String status, int i){
        Status[i] = status;
    }
    
            
    //methods      
    public static boolean checkLetters(String letter) {
      for (int i = 0; i < letter.length(); i++) {
            char c = letter.charAt(i);
            if (Character.isDigit(c)) {
                return true;
            }
        }
        return false; //if user inputs a number
    }
    
    public static boolean checkNumber(String IdNum){
        for (int i = 0; i < IdNum.length(); i++) {
            char ch = IdNum.charAt(i);
            if (Character.isLetter(ch)) {
                return true;
            }
        }
        return false;
    }
    
    public static boolean checkIdNumber(String Id,int Counter){
        for (int i = 0; i < Counter; i++) {
            if (IdNumber[i] == null ? Id == null : IdNumber[i].equals(Id)) {
                return true;
            }
        }
        return false;
    }
    
    //search id num
    public static int SearchID(String s) {
        for (int i = 0; i < StudentRecordCount + 1; i++) {
            if (s.equals(IdNumber[i])) {
                return i;
            }
        }
        return -1;
    }
    
    public static int searchLastName(String str) {
        int j = 0;
        for (int i = 0; i < StudentRecordCount + 1; i++) {
            if (str.equals(LastName[i])) {
                j++;
            }
        }
        return j;
    }
    
    static String[] sortlastname = new String[9999];
    
    //sort 
    public static void sortlastname() {
        for (int i = 0; i < StudentRecordCount; i++) {
            comp1[i] = 0;
        }
        for (int i = 0; i < StudentRecordCount; i++) {
            sortlastname[i] = setlastname(i);
        }
        for (int i = 0; i < StudentRecordCount - 1; i++) {
            for (int j = i + 1; j < StudentRecordCount; j++) {
                if (sortlastname[i].compareTo(sortlastname[j]) > 0) { //swap
                    String temp = sortlastname[i];
                    sortlastname[i] = sortlastname[j];
                    sortlastname[j] = temp;
                }
            }
        }
    }
    
    public static void sortLastNameAndFirstName() {

      for (int i = 0; i < StudentRecordCount -1; i++){
          for (int y = i+1; y < StudentRecordCount; y++ ){
           if (LastName[i].compareTo(LastName[y])== 0){
               if(FirstName[i].compareTo(FirstName[y])>0){
                            String SwapLN = LastName[i];
                            String SwapFN = FirstName[i];
                            LastName[i]      = LastName[y];
                            FirstName[i]     = FirstName[y];
                            LastName[y]      = SwapLN;
                            FirstName[y]     = SwapFN;
                         }
                    }
            else 
               if ( LastName[i].compareTo( LastName[ y ] ) > 0){
                            String SwapLN = LastName[i];
                            String SwapFN = FirstName[i];
                            LastName[i]      = LastName[y];
                            FirstName[i]     = FirstName[y];
                            LastName[y]      = SwapLN;
                            FirstName[y]     = SwapFN;
               } 
         }

     }

}     
    //search
    static int[] comp1 = new int[9999];

    public static int SearchLN(int y) {

        for (int i = 0; i < StudentRecordCount; i++) {
            if (y > 0) {
                if (sortlastname[y].equalsIgnoreCase(setlastname(i))) {
                    if (comp1[i] == i) {

                    } else {
                        comp1[i] = i;
                        return i;
                    }
                }

            } else {
                if (sortlastname[y].equalsIgnoreCase(setlastname(i))) {
                    comp1[i] = i;
                    return i;
                }

            }

        }
        return -1;
    }
    
    public static int getIDNumber(String ID, int i) {
        int count = 0;

        for (int x = 0; x < StudentRecordCount + 1; x++) {
            if (ID.equalsIgnoreCase(LastName[x])) {
                if (count == i) {
                    return x;
                }
                count++;
            }
        }
        return -1;
    }
    
}
