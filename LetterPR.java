import java.util.*;
import java.io.*;
/**
* LetterPR class calculates total number of letter permutations (no repeated letters) / 
* rearrangements (repeated letter(s)) for each word entered by the user.    
*
* @author Shadiyah Mangru
* @version 1.0
* @since June 2018
*/


public class LetterPR{

	private String word;
	private BufferedReader reader;
	private boolean hasRepeats;
	private ArrayList<Integer> repeats;
	private long letterprs;
	
	/**
	* No-argument constructor
	*/
	public LetterPR(){
		reader = new BufferedReader(new InputStreamReader(System.in));
		mainMenu();
	}
	
	/**
	* a method to ask user for a word
	*/
	public void setWord(){
		try{
			System.out.print("Enter a word: ");
			word = reader.readLine().toUpperCase();
		}
		catch(IOException e){
			System.out.println("IOException: " + e);	
		}
		catch(Exception e){
			System.out.println("Exception: " + e);
		}
	}
	
	/**
	* a method to return the word input by the user
	* @return String user's word
	*/
	public String getWord(){
		return word;	
	}
	

	/**
	* a method to determine if user's word contains repeated letters.
	* if duplicates exist, this method determines number of repeats per repeated letter
	*/
	public void setRepeats(){
		repeats = new ArrayList<Integer>();
		ArrayList<String> ltrRpts = new ArrayList<String>();
		Integer rptCnt = 0;
		for(int i=0; i<getWord().length(); i++){
			String checkRpt = getWord().valueOf(getWord().charAt(i));
			if(getWord().substring(i+1, getWord().length()).contains(checkRpt)){
				try{
					if(ltrRpts.contains(checkRpt)==false){ 
						ltrRpts.add(checkRpt); 
						rptCnt++;
						for(int g = 0;  g < getWord().substring(i, getWord().length()).length() -1; g++){
							if(checkRpt.charAt(0) == getWord().charAt(g+i+1)){
								rptCnt++;
							}
						}
					}	
				}
				catch(Exception e){
					System.out.println("Exception: " + e);
				}
			}
			if(rptCnt>1){
				try{
					getRepeats().add(rptCnt);
					rptCnt=0;
				}
				catch(Exception e){
					System.out.println("Exception: " + e);	
				}
			}
		}
		if(repeats.size()>0){
			hasRepeats = true;	
		}
	}
	
	/**
	* a method that returns the numeric frequency of each repeated letter in the user's word
	* @return ArrayList numeric frequency of each repeated letter
	*/
	public ArrayList<Integer> getRepeats(){
		return repeats;	
	}

	/**
	* a method to determine total letter permutations of user's word (if each letter is unique).
	* a method to determine total letter rearrangements of user's word (if word contains duplicate letter(s))
	*/
	public void setPR(){
		long numerator = factorial(getWord().length());
		try{
			if(hasRepeats){
				long denominator = 1;
				for(int i = 0; i<getRepeats().size();i++){
					denominator *= factorial(getRepeats().get(i)); 	
				}
				letterprs = numerator/denominator;
			}
			else{
				letterprs = numerator;	
			}
		}
		catch(Exception e){
			System.out.println("Exception: " + e);
		}
	}
	
	/**
	* a method that returns the total letter permutations/rearrangements of the user's word
	* @return long total letter permutations/rearragements
	*/
	public long getPR(){
		return letterprs;	
	}
	
	/**
	* a method that formats and outputs permutations/rearrangements calculations to user
	*/
	public void formatResults(long result){
		if(hasRepeats){
			System.out.println("The number of letter REARRANGEMENTS for " + getWord() + " is: " + result + "\n");	
		}
		else{
			System.out.println("The number of letter PERMUTATIONS for " + getWord() + " is: " + result + "\n");	
		}
	}
	
	/**
	* a method to calcuate the factorial of an integer
	* @param num calculate the factorial of this integer input
	* @return long the calculated product
	*/
	public static long factorial(int num){
		long fproduct = 1;
		for(int i = 1; i<=num; i++){
			fproduct *= i; 	
		}
		return fproduct;
	}
	
	/**
	* a method that allows user the option of (i) determining the total letter permutations/rearrangements of a user-selected word, 
	* or (ii) exiting the program
	*/
	public void mainMenu(){
		System.out.println("**********  LETTER PERMUTATIONS / REARRANGEMENTS CALCULATOR  **********\nSelect an option: ");
		System.out.println("1) Determine total different permutations / rearrangements of the letters in a word of your choice \n2) EXIT");		
		try{
			System.out.print("Enter number of selection: ");
			int userChoice = Integer.parseInt(reader.readLine());	
				switch(userChoice){
					case 1: setWord();
						setRepeats();
						setPR();
						formatResults(letterprs);
						mainMenu();
						break;
					case 2: System.out.print("You selected: EXIT");
						System.exit(0);
						break;
					default: mainMenu(); //reload menu bc invalid selection
						break;	
				}
		}
		catch(Exception e){
		System.out.println("Exception: " + e + "\nTry again!");
		mainMenu();
		}
	}

	/**
	* a method that launches the letter permutations/rearrangements calculator application
	* @param args command line arguments
	*/
	public static void main(String[] args){
		LetterPR go = new LetterPR();
	}
	
}