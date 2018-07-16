import java.io.*;

/**
* The MedianByLinkedList class uses a linked-list to sort a data set.
* 
* @author Shadiyah Mangru
* @version 1.0
* @since May 2018
*/


class Node {
	int data;
	Node next;
	
	Node(int data){
		this.data = data;	
	}
	
	Node(int data, Node next){
		this.data = data;
		this.next = next;
	}	
}

public class MedianByLinkedList{
	private Node start;
	private Node p;
	private int ListLength;
	
	//constructor
	public MedianByLinkedList(){
		selectionMenu();	
	}
	
	public static void main(String[] args){
		MedianByLinkedList newInst = new MedianByLinkedList();
	}
	
	//main menu of user options
	public void selectionMenu(){
		System.out.println("\n***********  MAIN  MENU  ***********\n"+
			"1) PRINT current data set \n"+
			"2) ADD number to data set \n"+          
			"3) DELETE number from data set \n"+	   		
			"4) Get MEDIAN of data set \n"+		  
			"5) EXIT \n"+
			"************************************\n");
		try{
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			System.out.print("Enter Menu Selection: ");
			int menuPick = Integer.parseInt(reader.readLine());	
				switch(menuPick){
					case 1: printLinkedList();
						selectionMenu();
						break; 
					case 2: ListLength++;
						getNumberInput();
						selectionMenu();
						break; 
					case 3: getNumberDelete();
						selectionMenu();
						break;
					case 4: getMedian();
						selectionMenu();
						break; 
					case 5: System.out.println("You are EXITING the program");
						System.exit(0);
						break; 
					default: selectionMenu(); //reload menu bc invalid selection
						break;	
				}
		}
		catch(IOException e){
			System.out.println("oh noz, there is an IOException: " + e + "\n");
			selectionMenu();		}
		catch(Exception e){
			System.out.println("oh noz, there is an Exception: " + e + "\n");	
			selectionMenu();		}
	}
	
	//print the current linked-list
	public void printLinkedList(){
		System.out.print("The current data set is:  ");	
		for (p=start; p!=null; p = p.next){
			System.out.print(p.data + "  ");	
		}
		if(ListLength == 0){
			System.out.println("Empty Data Set");
		}
		System.out.println("\nThe current data set contains " + ListLength + " values");
	}
	
	//get input from user of number to add to sorted linked-list
	public void getNumberInput(){
	try{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Enter number to add to data set: ");
		int numberInput = Integer.parseInt(reader.readLine());
		start = insert(start, numberInput);	
	}
	catch(IOException e){
		System.out.println("oh noz, there is an IOException: " + e + "\nTry again!\n");
		getNumberInput();		}
	catch(Exception e){
		System.out.println("oh noz, there is an Exception: " + e + "\nTry again!\n");	
		getNumberInput();		}
	}	
	
	//insert number in sorted linked-list
	int termCond = 0;
	public Node insert(Node start, int numberToInput) throws RuntimeException, Exception{
		if(start==null || start.data>numberToInput){
			start = new Node(numberToInput, start);
			return start;
		}
		Node p = start;
		while(p.next!=null & termCond == 0){
			if(p.next.data > numberToInput){
			termCond++;
			}
			else{
				p=p.next;
			}
		}
		p.next = new Node(numberToInput, p.next);
		return start;
	}	
	
	//get input from user of number to delete from sorted linked-list
	public void getNumberDelete(){
	try{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Enter number to delete from data set: ");
		int numberDelete = Integer.parseInt(reader.readLine());
		start = delete(start, numberDelete);
	}
	catch(IOException e){
		System.out.println("oh noz, there is an IOException: " + e + "\n");
		getNumberDelete();		}
	catch(Exception e){
		System.out.println("oh noz, there is an Exception: " + e + "\n");	
		getNumberDelete();		}
	}
	
	
	//delete number from linked-list or alert user that number does not exist in current linked-list
	int ctr = 0;
	public Node delete(Node start, int numberToDelete){
		if(start==null || start.data > numberToDelete){
			System.out.println(numberToDelete + " not in data set");
			return start;
		}
		else if(start.data == numberToDelete){
			ctr++;
			ListLength--;
			System.out.println(numberToDelete + " successfully deleted");
			return start.next;
		}
		for (Node p = start; p.next != null & ctr==0 ; p = p.next){
			if(p.next.data>numberToDelete);
			else if(p.next.data == numberToDelete){
				p.next = p.next.next;
				ctr++;
			}
		}
		if(ctr==0){
			System.out.println(numberToDelete + " not in data set");	
		}
		if(ctr!=0){
			ListLength--;
			System.out.println(numberToDelete + " successfully deleted");
		}
		return start;
	}

	//find the median of the current linked-list
	public void getMedian() throws Exception{
	int oddMedian = 0;
	double evenMedian = 0.0;
	p = start;
	if((ListLength%2)==1){
		if(ListLength==1){
			oddMedian = Integer.valueOf(p.data);	
		}
		else{
			for (int i = 0 ; i<(ListLength/2) ; i++){
				p = p.next;
				oddMedian = Integer.valueOf(p.data);	
			}	
		}
	printLinkedList();
	System.out.println("This odd-length set's MEDIAN is: " + oddMedian);		
	}
	else if(ListLength%2==0 & ListLength!=0){
		if(ListLength==2){
			evenMedian = (Double.valueOf(p.data) + Double.valueOf(p.next.data))/2;	
		}
		else{
			for(int i = 0; i< (ListLength/2-1); i++){
				p = p.next;
				evenMedian = (Double.valueOf(p.data) + Double.valueOf(p.next.data))/2;	
			}
		}
	printLinkedList();
	System.out.println("This even-length set's MEDIAN is: " + evenMedian);
	}
	else{
		System.out.println("The MEDIAN of the empty set is undefined");
	}
}
}
