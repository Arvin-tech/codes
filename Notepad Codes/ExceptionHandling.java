import java.util.*;

public class Ch12_PrExercise1
{
	static Scanner console = new Scanner(System.in);

	static final double CONVERSION = 2.54;
	static final int INCHES_PER_FOOT = 12;

	public static void main (String[] args){
		//declare variables
		int feet;
		int inches;
		int totalInches;
		double centimeter;
		
		System.out.println("­\f");
		feet = getNum("feet"); 			//feet = console.nextInt();
		inches = getNum("inches");		//inches = console.nextInt();

		System.out.println();

		System.out.println("The numbers you entered are "
		+ feet + " for feet " + "and "
		+ inches + " for inches. ");

		totalInches = INCHES_PER_FOOT * feet + inches;

		System.out.println()­;
		System.out.println("­The total number of inches = "+ totalInches);

		centimeter = totalInches * CONVERSION;

		System.out.println("­The number of centimeters = "+ centimeter);

	}

	public static int getNum(String str){
		int num = 0;
		boolean done = false;
	
		do
		{
			try 
			{
				System.out.print("En­ter the " + str + ": ");
				num = console.nextInt();
				System.out.println()­;
				
				if (num < 0){
				throw new Exception("Number cannot be negative");
				done = true;
				}
				catch (InputMismatchException nfeRef){
				console.nextLine();
				System.out.println("\nException " + nfeRef.toString());
				}
			
				catch (Exception e){
				System.out.println("\nException " + e.toString());
				}
			}
		}while(!done); 
		
		return num;
	}
}

---------------------------------------------------------
import java.io.*;

public class Ch12_PrExercise7
{
public static void main(String[] args)
{
ExtendedRoman num1 = new ExtendedRoman("XV");
ExtendedRoman num2 = new ExtendedRoman("XXV")­;

ExtendedRoman num3 = new ExtendedRoman("XXV")­;
ExtendedRoman num4 = new ExtendedRoman("XD");

System.out.println("­\fnum1: " + num1);
System.out.println("­num2: " + num2);

System.out.println("­num1.add(num2): " + num1.add(num2));

System.out.println("­num1: " + num1);
System.out.println("­num2: " + num2);

System.out.println("­num1.multiply(num2):­ " + num1.multiply(num2))­;

//Subtraction
try
{

System.out.println("­num3: " + num3);

System.out.println("­num4: " + num4);
System.out.println("­num3.subtract(num4):­ " + num3.subtract(num4))­;
}
catch (Exception e)
{
System.out.println(e­.toString());
}


//Division
try
{
num1.setRoman("XV");
num2.setRoman("III")­;

System.out.println("­num1: " + num1);

System.out.println("­num2: " + num2);
System.out.println("­num1.divide(num2): " + num1.divide(num2));
}
catch (Exception e)
{
System.out.println(e­.toString());
}
}
}

------------------------------------------------------
public class ExtendedRoman extends Roman
{

public ExtendedRoman()
{
super();
}

public ExtendedRoman(String­ rString)
{
super(rString);
}

public ExtendedRoman add(ExtendedRoman otherNum)
{
decimalNum = decimalNum + otherNum.decimalNum;

decimalToRoman();

return this;
}

public ExtendedRoman subtract(ExtendedRom­an otherNum) throws Exception
{
if (decimalNum <= otherNum.decimalNum)
throw new Exception("Because the first number is smaller than the "
+ "second, the numbers cannot be subtracted.");

decimalNum = decimalNum - otherNum.decimalNum;
decimalToRoman();

return this;
}

public ExtendedRoman multiply(ExtendedRom­an otherNum)
{
decimalNum = decimalNum * otherNum.decimalNum;

decimalToRoman();

return this;
}

public ExtendedRoman divide(ExtendedRoman­ otherNum) throws Exception
{
if (decimalNum < otherNum.decimalNum)

throw new Exception("Because the numerator is smaller than the "
+ "denominator, the numbers cannot be divided.");

decimalNum = decimalNum / otherNum.decimalNum;
decimalToRoman();

return this;
}

public String toString()
{
return super.toString();
}
}

---------------------------------------------------------
/**
* Write a description of class convertRomanToDecima­l here.
*
* @author (your name)
* @version (a version number or a date)
*/
import java.util.Scanner;

public class convertRomanToDecima­l {
static Scanner kb = new Scanner (System.in);
public static void main () {
Roman r;
String romanStr;

System.out.print ("\fInput roman numeral: ");
romanStr = kb.next();
r = new Roman (romanStr);

System.out.print ("\nDecimal equivalent: ");
r.printDecimal();
}
}
----------------------------
public class Roman
{
protected String romanNum;
protected int decimalNum;

public Roman()
{
romanNum = "I";
decimalNum = 1;
}

public Roman(String rString)
{
romanNum = rString;
romanToDecimal();
}

public void printDecimal()
{
System.out.println(d­ecimalNum);
}

public void printRoman()
{
System.out.println(r­omanNum);
}

public String toString()
{
return romanNum;
}

public void setRoman(String rString)
{
romanNum = rString;
romanToDecimal();
}

public void romanToDecimal()
{
int sum = 0;
int len = romanNum.length();
int i;

int previous = 1000;

for (i = 0; i < len; i++)
{
switch (romanNum.charAt(i))
{
case 'M':
sum += 1000;
if (previous < 1000)
sum -= 2 * previous;
previous = 1000;
break;

case 'D':
sum += 500;
if (previous < 500)
sum -= 2 * previous;
previous = 500;
break;

case 'C':
sum += 100;
if (previous < 100)
sum -= 2 * previous;
previous = 100;
break;

case 'L':
sum += 50;
if (previous < 50)
sum -= 2 * previous;
previous = 50;
break;

case 'X':
sum += 10;
if (previous < 10)
sum -= 2 * previous;
previous = 10;
break;

case 'V':
sum += 5;
if (previous < 5)
sum -= 2 * previous;
previous = 5;
break;

case 'I':
sum += 1;
previous = 1;
}
}

decimalNum = sum;
}

public void decimalToRoman()
{
int dnum;
int i = 0;

dnum = decimalNum;
romanNum = "";

while (dnum > 0)
{
if (dnum / 1000 > 0)
{
romanNum += 'M';
dnum = dnum - 1000;
}
else if (dnum / 500 > 0)
{
romanNum += 'D';
dnum = dnum - 500;
}
else if (dnum / 100 > 0)
{
romanNum += 'C';
dnum = dnum - 100;
}
else if (dnum / 50 > 0)
{
romanNum += 'L';
dnum = dnum - 50;
}
else if (dnum / 10 > 0)
{
romanNum += 'X';
dnum = dnum - 10;
}
else
switch (dnum)
{
case 9:
romanNum += "IX";
dnum = 0;
break;

case 8:
romanNum += "VIII";
dnum = 0;
break;

case 7:
romanNum += "VII";
dnum = 0;
break;

case 6:
romanNum += "VI";
dnum = 0;
break;

case 5:
romanNum += "V";
dnum = 0;
break;

case 4:
romanNum += "IV";
dnum = 0;
break;

case 3:
romanNum += "III";
dnum = 0;
break;

case 2:
romanNum += "II";
dnum = 0;
break;

case 1:
romanNum += 'I';
dnum = 0;
break;
}
}
}

}