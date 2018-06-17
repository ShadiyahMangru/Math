import java.util.*;
import java.io.*;
/**
* Fibonacci class contains methods to calculate the Fibonacci sequence.
*
* The Fibonacci Sequence is: 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, ...
* Each number in the sequence (starting from the third term) is the sum of the two preceding numbers
*/
public class Fibonacci{

	/**
	* method to get nth term of Fibonacci sequence
	* @param nth number in Fibonacci sequence user wished to calculate
	* @return long nth number in Fibonacci sequence
	*/
	public static long nthFibCalc(int nth){
		if(nth==1){
			return 1;
		}
		else if(nth==2){
			return 2;	
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
	public static ArrayList<Long> firstNFibsCalc(long n){
		ArrayList<Long> nFibs = new ArrayList<Long>();
		for (int i = 1 ; i<= n ; i++){
			nFibs.add(nthFibCalc(i));
		}
		return nFibs;
	}
	
	
	/**
	* a method that presents a Calculate Fibonacci Numbers menu of options to the user.
	*/
	public static void loadFibMenu(){
		System.out.println("\n*********  CALCULATE FIBONACCI NUMBERS  *********");
		System.out.println("\nThe Fibonacci Sequence is: 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, ...   ");
		System.out.println("Each number in the sequence (starting from the third term) "+
			"is the sum of the two preceding numbers.");
		System.out.println("\nMake a choice:\n1.) Find the nth term of the Fibonacci Sequence"+
			"\n2.) Print the first n terms of the Fibonacci Sequence\n\n3.) Exit");
		System.out.println("\n*********************************************");
		
		try{
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			System.out.print("Enter selection: ");
			int userChoice = Integer.parseInt(reader.readLine());	
			int nVal = 0;
				switch(userChoice){
					case 1: System.out.println("You selected: Find the nth term of the Fibonacci Sequence");
						System.out.println("Enter a natural number value of n");
						nVal = Integer.parseInt(reader.readLine());
						System.out.println("The " + nVal + "th term of the Fibonacci Sequence is: " + nthFibCalc(nVal));
						loadFibMenu();
						break;
					case 2: System.out.println("You selected: Print the first n terms of the Fibonacci Sequence");
						System.out.println("Enter a natural number value of n");
						nVal = Integer.parseInt(reader.readLine());
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
		catch(Exception e){
		System.out.println("oh noz, there is an Exception: " + e + "\nTry again!");
		loadFibMenu();
		}
	}
	
	
	/**
	* the main method launches the application
	* @param args command line arguments
	*/
	public static void main(String[] args){
		loadFibMenu();
	}
}