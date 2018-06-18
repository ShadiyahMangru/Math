import java.util.*;
import java.io.*;
/**
* Fibonacci class launches an application that gives the user the option of 
* (i) calculating and printing the nth term of the Fibonacci sequence
* (ii) calculating and printing the first n terms of the Fibonacci sequence
* (iii) exiting the program
*
* *calculations are accurate for n <= 92.
*
* The Fibonacci Sequence is: 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, ...  
* Each number in the sequence (starting from the third term) is the sum of the two preceding numbers
*/
public class Fibonacci{

	private BufferedReader reader;
	private int nVal;
	
	Fibonacci(){
		loadFibMenu();	
	}
	
	/**
	* method to get nth term of Fibonacci sequence
	* @param nth number in Fibonacci sequence user wishes to calculate
	* @return long nth number in Fibonacci sequence
	*/
	public long nthFibCalc(int nth){
		if(nth==1){
			return 1;
		}
		else if(nth==2){
			return 1;	
		}
		else if(nth>=3){
			Long fibNew = 0L;
			int i = 3;
			ArrayList<Long> fibs = new ArrayList<Long>();
			fibs.add(1L);
			fibs.add(1L);
			while(i <= nth){
				fibNew = fibs.get(i-2) + fibs.get(i-3);
				fibs.add(fibNew);
				i++;
			}
			return fibNew;
		}
		return -1;
	}	
	
	/**
	* method to get first n terms of Fibonacci sequence
	* @param n the number of terms (1, ..., n) to calculate in the Fibonacci sequence
	* @return ArrayList the first n terms of the Fibonacci sequence
	*/
	public ArrayList<Long> firstNFibsCalc(long n){
		ArrayList<Long> nFibs = new ArrayList<Long>();
		for (int i = 1 ; i<= n ; i++){
			nFibs.add(nthFibCalc(i));
		}
		return nFibs;
	}
	
	
	/**
	* a method that presents a Calculate Fibonacci Numbers menu of options to the user.
	*/
	public void loadFibMenu(){
		System.out.println("\n*********  CALCULATE FIBONACCI NUMBERS  *********");
		System.out.println("\nThe Fibonacci Sequence is: 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, ...   ");
		System.out.println("Each number in the sequence (starting from the third term) "+
			"is the sum of the two preceding numbers.");
		System.out.println("\nMake a choice:\n1.) Find the nth term of the Fibonacci Sequence"+
			"\n2.) Print the first n terms of the Fibonacci Sequence\n\n3.) Exit");
		System.out.println("\n*********************************************");
		
		try{
			reader = new BufferedReader(new InputStreamReader(System.in));
			System.out.print("Enter selection: ");
			int userChoice = Integer.parseInt(reader.readLine());	
				switch(userChoice){
					case 1: System.out.println("You selected: Find the nth term of the Fibonacci Sequence");
						getNVal();
						System.out.println("The Fibonacci Sequence term at position " + nVal + " is: " + nthFibCalc(nVal));
						loadFibMenu();
						break;
					case 2: System.out.println("You selected: Print the first n terms of the Fibonacci Sequence");
						getNVal();
						System.out.println("The first " + nVal + " terms of the Fibonacci sequence are: " + firstNFibsCalc(nVal).toString());
						loadFibMenu();
						break;
					case 3: System.out.print("You selected: EXIT");
						System.exit(0);
						break;
					default: loadFibMenu(); //reload menu bc invalid selection
						break;	
				}
		}
		catch(IOException e){
			System.out.println("oh noz, there is an IOException: " + e + "\nTry again!");
			loadFibMenu();
		}
		catch(Exception e){
		System.out.println("oh noz, there is an Exception: " + e + "\nTry again!");
		loadFibMenu();
		}
	}
	
	/**
	* a method that sets the value of n for the current Fibonacci sequence calculation
	*/
	public void setNVal(){
		try{
			System.out.print("Enter a natural number value of n: ");
			nVal = Integer.parseInt(reader.readLine());
			if(nVal > 92){
				System.out.println("CAUTION: Accurate results available for n <= 92");
				setNVal();
			}
		}
		catch(IOException e){
			System.out.println("oh noz, there is an IOException: " + e + "\nTry again!");
			setNVal();
		}
		catch(Exception e){
			System.out.println("oh noz, there is an Exception: " + e + "\nTry again!");
			setNVal();
		}
	}
	
	/**
	* a method that returns the value of n for the current Fibonacci sequence calculation
	* @return int n value for current Fibonacci sequence calculation 
	*/
	public int getNVal(){
		setNVal();
		return nVal;
	}
	
	
	/**
	* the main method launches the application
	* @param args command line arguments
	*/
	public static void main(String[] args){
		Fibonacci CalcN = new Fibonacci();
	}
}