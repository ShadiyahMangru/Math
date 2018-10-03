import java.util.*;
import java.io.*;

	public class ChineseZodiac{
		//fields
		private ArrayList<Zodiac> yearOf;
		private int birthYear;
		private String yourSign;
		
		//constructor
		public ChineseZodiac(){
			setYearOf();
			setBirthYear();
			setYourSign();
			result();
		}
		
		//setters
		public void setYearOf(){
			yearOf = new ArrayList<Zodiac>();
			yearOf.add(new Zodiac("rat", 1912));
			yearOf.add(new Zodiac("ox", 1913));
			yearOf.add(new Zodiac("tiger", 1914));
			yearOf.add(new Zodiac("rabbit", 1915));
			yearOf.add(new Zodiac("dragon", 1916));
			yearOf.add(new Zodiac("snake", 1917));
			yearOf.add(new Zodiac("horse", 1918));
			yearOf.add(new Zodiac("sheep", 1919));
			yearOf.add(new Zodiac("monkey", 1920));
			yearOf.add(new Zodiac("rooster", 1921));
			yearOf.add(new Zodiac("dog", 1922));
			yearOf.add(new Zodiac("pig", 1923));
		}
		
		public void setBirthYear(){
			try{
				System.out.println("Welcome to Chinese Zodiac Calculator!\n");
				BufferedReader readYear = new BufferedReader(new InputStreamReader(System.in)); 
				System.out.print("Enter Birth Year: ");
				birthYear = Integer.parseInt(readYear.readLine());	
			}
			catch(Exception e){
				System.out.println("oh noz, there is an Exception: " + e + "\nTry again!");
			}
		}
		
		public void setYourSign(){
			for(Zodiac element : yearOf){
				if( (birthYear - element.getYear())%12 == 0){
					yourSign = element.getAnimal();	
				}
			}
		}
		
		//getters
		public ArrayList<Zodiac> getYearOf(){
			return yearOf;	
		}
		
		public int getBirthYear(){
			return birthYear;
		}
		
		public String getYourSign(){
			return yourSign;	
		}
		
		//method to output result
		public void result(){
			System.out.println("You were born in the year of the " + getYourSign().toUpperCase() + ".");
		}
		
		//main method
		public static void main(String[] args){
			ChineseZodiac calculate = new ChineseZodiac();
		}
	}

	class Zodiac{
		//fields
		private String animal;
		private int year;
		
		//constructor
		public Zodiac(String a, int y){
			animal = a;
			year = y;
		}
		
		//setters
		public void setAnimal(String a){
			animal = a;
		}
		
		public void setYear(int y){
			year = y;	
		}
		
		//getters
		public String getAnimal(){
			return animal;	
		}
		
		public int getYear(){
			return year;	
		}
	}