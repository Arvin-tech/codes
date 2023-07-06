/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.payroll;

/**
 *
 * @author Acer
 */
public class EmployeeRecords {
   String empID, empLastName, empFirstName, empDepartment;
   char empGender;
   double empHrsWorked, empRatePerHr, empSSSDeduction, empTaxDeduction, empOtherDeductions, empBasicPay, empNetPay;
    private double empRateperHr;
    
   public EmployeeRecords(){ //constructor initialize
       empID = " ";
       empLastName = " ";
       empFirstName = " ";
       empDepartment = " ";
       empGender = ' ';
       empHrsWorked = 0.0;
       empRatePerHr = 0.0;
       empSSSDeduction = 0.0; 
       empTaxDeduction = 0.0;
       empOtherDeductions = 0.0;
       empBasicPay = 0.0;
       empNetPay = 0.0;
       
   }
    //getters and setters
    public void setID(String empID){
        this.empID = empID;
    }
    
    public String getID(){
        return empID;
    }
    
    public void setLast(String empLastName){
        this.empLastName = empLastName; 
    }
    public String getLast(){
        return empLastName; 
    }
 
    public void setFirst(String empFirstName){
        this.empFirstName = empFirstName; 
    }
    public String getFirst(){
        return empFirstName; 
    }
    
    public void setDept(String empDepartment){
        this.empDepartment = empDepartment; 
    }
    public String getDept(){
        return empDepartment; 
    }

    public void setGender(char empGender){
        this.empGender = empGender; 
    }
    public char getGender(){
        return empGender; 
    }
    
    public void setHours(double empHrsWorked){
        this.empHrsWorked = empHrsWorked; 
    }
    public double getHrsWorked(){
        return empHrsWorked; 
    } 
    
    public void setRate (double empRateperHr){
        this.empRateperHr = empRateperHr; 
    }
    public double getRate(){
        return empRateperHr; 
    } 
    
    public void setSSS(double empSSSDeduction){
        this.empSSSDeduction = empSSSDeduction; 
    }
    public double getSSS(){
        return empSSSDeduction; 
    }
    
    public void setTax(double empTaxDeduction){
        this.empTaxDeduction = empTaxDeduction; 
    }
    public double getTax(){
        return empTaxDeduction; 
    }
    
    public void setOtherDeductions(double empOtherDeductions){
        this.empOtherDeductions = empOtherDeductions; 
    }
    public double getOtherDeductions(){
        return empOtherDeductions; 
    }
    
    public void setBasic(double empBasicPay){
        this.empBasicPay = empBasicPay; 
    }
    public double getBasic(){
        return empBasicPay; 
    }
    
    //Net Pay
    public void setNet(double empNetPay){
        this.empNetPay = empNetPay; 
    }
    public double getNet(){
        return empNetPay; 
    }
    
    //Check Numbers
    public static boolean checkNumber(String ID) {
        for (int x = 0; x < ID.length(); x++) {
            char ch = ID.charAt(x);
            if (Character.isLetter(ch)) {
                return true;
            }
        }
        return false;
    }
    
    //Check Duplicate
    public static boolean checkDuplicate(String ID) {
        for (int x = 0; x < MainSystem.index; x++) {
            if (MainSystem.size[x].getID().equals(ID)) {
                return true;
            }
        }
        return false;
    }
    
    //Check Letters
    public static boolean checkLetters(String str) {
        boolean flag = false;
        for (int x = 0; x < str.length(); x++) {
            char ch = str.charAt(x);
            if (Character.isDigit(ch)) {
                flag = true;
            } else {
                flag = false;
            }
        }
        return flag;
    }
    
    //Search ID Number
    public static int searchIDNumber(String str) {
        for (int x = 0; x < MainSystem.index; x++) {
            if (MainSystem.size[x].getID().equals(str)) {
                return x;
            }
        }
        return -1;
    }
    
    //Sort Last Name and First Name
    public static void sortLastandFirstName(){
        for (int i = 0; i < MainSystem.index; i++) {
            for (int j = i + 1; j < MainSystem.index; j++){
                if (MainSystem.size[i].getLast().compareTo(MainSystem.size[j].getLast()) > 0){
                    
                    EmployeeRecords temp = MainSystem.size[i];
                    MainSystem.size[i] = MainSystem.size[j];
                    MainSystem.size[j] = temp;         
                }
            }
        }
        for (int i = 0; i < MainSystem.index; i++){
            for (int j = i + 1; j < MainSystem.index; j++){
                if (MainSystem.size[i].getLast().equals(MainSystem.size[j].getLast())){
                    if (MainSystem.size[i].getFirst().compareTo(MainSystem.size[j].getFirst()) > 0){
                        
                        EmployeeRecords temp = MainSystem.size[i];
                        MainSystem.size[i] = MainSystem.size[j];
                        MainSystem.size[j] = temp;
                    }
                }
            }
        }
    }
    
    //Sort Highest Pay
    public static void sortHighestPay(){
        for (int i = 0; i < MainSystem.index; i++) {
            for (int j = i + 1; j < MainSystem.index; j++){
                if (MainSystem.size[i].getNet() < MainSystem.size[j].getNet()){
                    
                    EmployeeRecords temp = MainSystem.size[i];
                    MainSystem.size[i] = MainSystem.size[j];
                    MainSystem.size[j] = temp;         
                }
            }
        }
    }
    
    //Sort Lowest Pay
    public static void sortLowestPay(){
        for (int i = 0; i < MainSystem.index; i++) {
            for (int j = i + 1; j < MainSystem.index; j++){
                if (MainSystem.size[i].getNet() > MainSystem.size[j].getNet()){
                    
                    EmployeeRecords temp = MainSystem.size[i];
                    MainSystem.size[i] = MainSystem.size[j];
                    MainSystem.size[j] = temp;         
                }
            }
        }
    }
}
