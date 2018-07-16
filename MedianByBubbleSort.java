/**
* The MedianByBubbleSort class provides methods to 
* (i) bubble sort an array of ints and (ii) get median of a sorted array
* 
* @author Shadiyah Mangru
* @version 1.0
* @since May 2018
*/

public class MedianByBubbleSort{
	
	/**
	* returns an array of ints sorted by bubble sort
	* @return array sorted by bubble sort
	*/
	public int[] bubbleSort(int[] ints){
		int ctr = 0;
		do{
			for(int i = 0; i<ints.length-1; i++){
				if(ints[i] > ints[i+1]){
					int temp = ints[i];
					ints[i] = ints[i+1];
					ints[i+1] = temp;
				}		
			}
		ctr++;
		}
		while(ctr<ints.length);
		System.out.print("Bubble Sorted Numbers: ");
		for(int num : ints){
			System.out.print(num + " ");	
		}
		return ints;
	}
	
	/**
	* returns median of (bubble) sorted array of ints
	* @return double median
	*/
	public double getMedian(int[] sortedArray){
		double medianNum = 0.0;
		int totalNumbers = sortedArray.length;
		if(totalNumbers%2!=0){ 
		 	medianNum = sortedArray[sortedArray.length/2];
		 	System.out.println("\nMedian Number: " + medianNum);
		 	return medianNum;
		}
		else{
			medianNum = (sortedArray[sortedArray.length/2 - 1] + sortedArray[sortedArray.length/2])/2.0;
			System.out.println("\nMedian Number: " + medianNum);
			return medianNum;
		}
	}

	
	/**
	* the main method launches the application
	* @param args command line arguments
	*/
	public static void main(String[] args){
		MedianByBubbleSort newInst = new MedianByBubbleSort();
		int[] anArrayOfInts = {13, 75, 76, 3, 1, 876, 56, 234, 10, 1, 0, 8, 7, 45, 90, 34, 888, 94, 73, 14, 39};
		//int[] anArrayOfInts = {2};
		//int[] anArrayOfInts = {1, 7};
		newInst.getMedian(newInst.bubbleSort(anArrayOfInts));	
	}
}
