import java.io.*;

public class MatrixCreator{
	//fields
	private int matrixRows;
	private int matrixColumns;
	private int [][] userMatrix;
	private BufferedReader reader;
	
	//constructor
	public MatrixCreator(){
		reader = new BufferedReader(new InputStreamReader(System.in));
		setMatrixDimensions();
		setUserMatrix();
		printMatrix();
	}
	
	//getters
	public int getMatrixRows(){
		return matrixRows;
	}
	
	public int getMatrixColumns(){	
		return matrixColumns;
	}
	
	public int [][] getUserMatrix(){
		return userMatrix;	
	}
	
	public BufferedReader getReader(){
		return reader;	
	}
	
	//setters
	public void setMatrixDimensions(){
		try{
			System.out.print("Enter number of rows: "); 				
			matrixRows = Integer.parseInt(reader.readLine());	
			System.out.print("Enter number of columns: "); 		
			matrixColumns = Integer.parseInt(reader.readLine());	
		}
		catch(Exception e){
			System.out.println("oh noz, there is an Exception: " + e + "\nTry again!");
		}			
	}
	
	
	public void setUserMatrix(){	
		userMatrix = new int [matrixRows] [matrixColumns];
		try{
			for(int i = 0; i<userMatrix.length; i++){
				for(int j=0; j<userMatrix[i].length; j++){
					System.out.print("Enter row " + i + " column " + j + ": "); 				
					int userInput = Integer.parseInt(reader.readLine());	
					userMatrix[i][j] = userInput;	//creates matrix from user input
				}
			}
		}
		catch(Exception e){
			System.out.println("oh noz, there is an Exception: " + e + "\nTry again!");
		}	
	}
	
	public void setReader(BufferedReader r){
		reader = r;	
	}
	
	//a method to output user's matrix
	public void printMatrix(){
		System.out.println("  ");
		System.out.println("YOU ENTERED THIS " + matrixRows + " x " + matrixColumns + " MATRIX: ");
		for(int i=0; i<userMatrix.length; i++){
			for(int j=0; j<userMatrix[i].length; j++){
				System.out.print(userMatrix[i][j] + ", ");	
			}
			System.out.println("\n");
		}				
	}
	

	//main method
	public static void main(String[] args){
		MatrixCreator matrix = new MatrixCreator();						
	}	
	
}