/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.payrollsystem;
/**
 *
 * @author Acer
 */
   
    class EmployeeRecs{
        
    private static String[] empID = new String[100];
    private static String[] empLastName = new String[100];
    private static String[] empFirstName = new String[100];
    private static String[] empDepartment = new String[100];
    private static char[] empGender = new char[100];
    private static double[] empHrsWorked = new double[100];
    private static double[] empRatePerHr = new double[100];
    private static double[] empSSSDeduction = new double[100];
    private static double[] empTaxDeduction = new double[100];
    private static double[] empOtherDeductions = new double[100];
    private static double[] empBasicPay = new double[100];
    private static double[] empNetPay = new double[100];
    
    private static int[] size = new int[100];
    private static int index = 0; //Employee Record Count
    
    public static int setSize(){
        return index;
    }
    
    public static void getSize(int num){
        index = num;
    }
    
    public static int  setSize1(int i){
        return size[i];
    }
    
    public static void getSize1(int num, int i){
        size[num] = i;
    }
    
     //data
    
    public static String setID(int i){
        return empID[i];
    }
    
    public static void getID(String s, int i){
        empID[i] = s;
    }
    
    public static String setlastname(int i){
        return empLastName[i];
    }
    
    public static void getlastname(String s, int i){
        empLastName[i] = s;
    }
    
    public static String setfirstname(int i){
        return empFirstName[i];
    }
    
    public static void getfirstname(String s, int i){
        empFirstName[i] = s;
    }
    
    public static char setGender(int i){
        return empGender[i];
    }
    
    public static void getGender(char g, int i){
        empGender[i] = g;
    }
    
    //department
    public static String setDepartment(int i){
        return empDepartment[i];
    }
    public static void getDepartment(String s, int i){
        empDepartment[i] = s;
    }  
    
    public static double setHoursWorked(int i){
        return empHrsWorked[i];
    }
    //hours worked
    public static void getHoursWorked(double hours, int i){
        empHrsWorked[i] = hours;
    }
    
    //rate per hour
    public static double setRate(int i){
        return empRatePerHr[i];
    }
    
    public static void getRate(double rate, int i){
        empRatePerHr[i] = i;
    }
    //SSS
    public static double setSSS(int i){
        return empSSSDeduction[i];
    }
    public static void getSSS(double sss, int i){
        empSSSDeduction[i] = sss;
    }
    //Tax
    public static double setTax(int i){
        return empTaxDeduction[i];
    }
    
    public static void getTax(double tax, int i){
        empTaxDeduction[i] = tax;
    }
    //basic pay
    public static double setBasic(int i) {
        return empBasicPay[i];
    }
    
    public static void getBasic(double basicpay, int i) {
        empBasicPay[i] = basicpay;
    }
    //net pay
    public static double setNet(int i) {
        return empNetPay[i];
    }
    public static void getNet(double net, int i) {
        empNetPay[i] = net;
    }
    //other deductions
    public static void getOther(double other, int i) {
        empOtherDeductions[i] = other;
    }

    public static double setOther(int i) {
        return empBasicPay[i];
    }
    
    //methods
    public static boolean checkNumber(String empIDNum){
        for (int i = 0; i < empIDNum.length(); i++) {
            char ch = empIDNum.charAt(i);
            if (Character.isLetter(ch)) {
                return true;
            }
        }
        return false;
    }
    
    //check for duplicate
    public static boolean checkempIDNumber(String Id, int Counter){
        for (int i = 0; i < Counter; i++) {
            if (empID[i] == null ? Id == null : empID[i].equals(Id)) {
                return true;
            }
        }
        return false;
    }
    
    public static boolean checkLetters(String letter) {
      for (int i = 0; i < letter.length(); i++) {
            char c = letter.charAt(i);
            if (Character.isDigit(c)) {
                return true;
            }
        }
        return false; //if user inputs a number
        
    }
    
    //search employee num
    public static int SearchID(String s) {
        for (int i = 0; i < index + 1; i++) {
            if (s.equals(empID[i])) {
                return i;
            }
        }
        return -1;
    }
    
    public static int SearchDept(String d){
         for (int i = 0; i < index + 1; i++) {
            if (d.equals(empDepartment[i])) {
                return i;
            }
        }
        return -1;
    }
    
    
}
    
    
    

