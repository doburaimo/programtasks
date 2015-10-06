package programtasks;

import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;

/**
 * This is an efficient solution based on stack implementation.
 * 
 *  	(Limits and Visuals)
 *  The Runtime is 0(n)
 *  Prints out the Histogram vertically with the biggest rectangle shaded with X
 *  The Size of the Array is <=20
 */


public class MaximumRectangleStack {

	private static Random randomNumber;
	private static Scanner scan;
	private static int size;
	private static int bordera;
	private static int borderb;
	private static int top;

	public static void printLegend(int size, int index){
		System.out.println("index: "+index+" is size "+ size);
	}

	public static void printHelper(int[] histogram, int maxarea){
		int tries = 0;
		int popped = bordera;
		boolean end = false;
		while(!end && size >= 1 && tries < 100000){
			tries++;
			if ((borderb - bordera+1)*top == maxarea){
				end = true;
			}
			else if (bordera >0 && histogram[bordera-1]>= histogram[popped]){
				bordera--;
			}
			else if (borderb < size){
				if(borderb+1 < size && histogram[borderb+1] >=histogram[popped]){
					borderb++;
				}
			}
			else if (borderb == bordera && maxarea == histogram[popped]){
				end = true;
			}
		}
		if(tries >= 100000){
			System.out.println("ERROR: ACCURATE HISTOGRAM SHADING COULD NOT BE DERIVED");
			bordera =0;
			top = 0;
			borderb = 0;
		}
	}

	public static void printHisto(int[] histogram, int max,int maxarea){
		int limit = max;
		printHelper(histogram,maxarea);
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


	public static void generate(){
		System.out.println("A random number will be generated for you");
		size = randomNumber.nextInt(19)+1;
	}


	public static int solve(int[] histogram){
		LinkedList<Integer> stack = new LinkedList<Integer>(); //add the indices of values
		int area = 0;
		int maxarea = -1;
		int i = 0;
		int popped;
		while ( i < size){ //initial scan through the array
			if (stack.isEmpty() || histogram[stack.peekLast()] <= histogram[i]){
				//if the stack is empty or the top of the stack is less than or equal to the current histogram value
				stack.add(i++);
			}
			else{
				//if the stack's top is greater than the current histogram value
				popped = stack.removeLast();
				if (stack.isEmpty()){
					area = histogram[popped] * i;

				}
				else
				{
					area = histogram[popped] * (i- stack.peekLast()-1);

				}
				if (maxarea < area){
					maxarea = area;
					top = histogram[popped];
					bordera = popped;
					borderb = popped;
				}

			}

		}

		while (!stack.isEmpty() )
		{
			popped = stack.removeLast();
			if (stack.isEmpty()){
				area = histogram[popped] * i;
			}
			if(!stack.isEmpty())
			{
				area = histogram[popped] * (i- stack.peekLast()-1);
			}

			if (maxarea < area){
				maxarea = area;
				top = histogram[popped];
				bordera = popped;
				borderb = popped;
			}


		}

		return maxarea;
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
			System.out.println();
			int answer = solve(histogram);
			printHisto(histogram,max,answer);
			System.out.println("The Max Area is " + answer);


		}
	}
}