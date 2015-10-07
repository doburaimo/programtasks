package programtasks;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

/**
 * This is the inefficient solution based on array implementation.
 * 
 *  	(Limits and Visuals)
 *  The Runtime is 0(n^2)
 *  Prints out the Histogram vertically with the biggest rectangle shaded with X
 *  The Size of the Array is <=20
 */

public class MaximumRectangleInAHistogram {

	private static Random randomNumber;
	private static Scanner scan;
	private static int size;
	private static int bordera;
	private static int borderb;
	private static int top;


	public static void printLegend(int size, int index){
		System.out.println("index: "+index+" is size "+ size);
	}

	public static void printHisto(int[] histogram, int max){
		int limit = max;
		while(limit > 0){
			for(int i =0; i < size; i++){
				if (limit <= top && i <= borderb && i >=bordera){
					System.out.print("|X|");
				}
				else if (histogram[i] == max)
					System.out.print("|-|");
				else{
					System.out.print("   ");
					histogram[i]++;
				}
			}
			System.out.println();
			limit--;
		}
	}


	public static int minimum(int previousMinimum,int start){
		if (start < previousMinimum){
			return start;
		}
		return previousMinimum;
	}

	public static void generate(){
		System.out.println("A random number will be generated for you");
		size = randomNumber.nextInt(19)+1;
	}

	public static int solve(int[] histogram){
		int minimum,height;
		int area = 0;
		for (int i = size-1; i >=0; i--){
			minimum = histogram[i];
			for(int j = i; j>=0; j--){
				minimum = minimum(minimum,histogram[j]);
				height = i-j +1;
				height = height * minimum;
				if (area < height){
					area = height;
					bordera = j;
					borderb = i;
					top = minimum;
				}
			}
		}
		System.out.println("border a is "+ bordera + " border b is "+ borderb + "top is"+ top);
		return area;
	}
	public static void main(String[] args) {
		System.out.println("Please Input the amount of bars in the histogram ( less than 20)");
		scan = new Scanner(System.in);
		randomNumber = new Random();
		try{
			size = scan.nextInt();
			if (size > 20 || size < 1){
				generate();
			}
		}	
		catch(InputMismatchException e){
			generate();
		}


		finally{
			System.out.println("An Array will be generated for you");
			int[] histogram = new int[size];
			int max = 0;
			for (int i = 0; i < size; i++){
				histogram[i] = randomNumber.nextInt(19)+1;
				printLegend(histogram[i],i);
				max = ( max < histogram[i]) ? histogram[i] : max;
			}
			int answer = solve(histogram);
			printHisto(histogram,max);

			System.out.println("The Max Area is " + answer);
            scan.close();

		}
	} 
}
