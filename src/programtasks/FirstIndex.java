package programtasks;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;


public class FirstIndex {
	static boolean  done = false; 

	public static void main(String[] args) {
		Random randomnumber = new Random();
		int[] array = new int[20];
		for (int i =0; i < array.length; i++){
			array[i] = randomnumber.nextInt(30); 	  
		}
		Arrays.sort(array);
		int counter = 0;
		while(counter < array.length){
			System.out.print(array[counter] + "  ");
			counter++;
		}
		System.out.println();

		System.out.println("What number would you like to find the first index");
		Scanner scan = new Scanner(System.in);
		int number = 0;
		String method = "UNKNOWN";
		try{
			number = scan.nextInt();
			System.out.println("Type 1 for recursive search. Any other input will result in Binary Search");
			method = scan.next();

		}	
		catch(InputMismatchException e){
			done = true;
			System.out.println("Restart the Application");
		}


		finally{
			if (done ==false){
				int answer = (method.equals("1"))? recursive(0, number, array.length-1, array): BinarySearch(number,array.length-1,array);
				System.out.print(number);
				String answerString = ((answer >=0)? "'s  first index is "+answer: " is not in our array");
				System.out.print(answerString);
				System.out.println();
				counter = 0;
				if(answer >= 0){
					while(counter < array.length){
						if (counter == answer){
							System.out.print("("+ array[counter] + ")  ");
						}
						else{
							System.out.print(array[counter] + "  ");
						}
						counter++;
					}
				}
			}
			scan.close();
		}

	}

	private static int recursive(int left, int number, int right, int[] array) {
		int mid = (right + left) / 2;
		if (left > right){
			return -1;
		}

		if (left < 0){
			return -1;
		}
		if (right > array.length){
			return -1;
		}

		if (array[mid] == number ){ 
			if(mid > 0 && array[mid-1] ==number ){
				return recursive(left,number,mid-1,array);
			}
			return mid;

		}
		else if(array[mid] < number){
			return recursive(mid+1, number,right,array);
		}
		else if (array[mid] > number
				){
			return recursive(left, number, mid-1,array);
		}
		else{
			return -1;
		}
	}

	public static int BinarySearch(int a, int size, int[]array){
		int number = -1;
		int left = 0;
		int right = size;

		while (left<=right){ 
			int mid = (right + left)/2;
			//System.out.println(mid);
			if(array[mid] < a){
				left = mid+1;
			}
			else if (array[mid] > a){
				right = mid-1;
			}
			else{
				number = mid;
				right = mid-1;
			}
		}
		return number;
	}
}
