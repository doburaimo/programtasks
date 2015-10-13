package programtasks;

import java.util.Random;

public class PrintSubSet {



	public static void main(String[] args) {
		Random randinteger = new Random();
		int input = randinteger.nextInt(7);
		int[] intArray = new int[input];
		boolean[] boolArray = new boolean[input];
		System.out.println("We are going to generate subsets of an array of " + input + " element(s)");
        System.out.println("The array is below");
        System.out.print("{ ");
		for (int i = 0; i < input; i++){
			intArray[i] = i + 1;
			System.out.print(i + 1 +" ");
			boolArray[i] = false;		
		}
		 System.out.println("}");
		 System.out.println("The subset(s) below");
		printSubArray(intArray,boolArray,0);
	}
	public static void printSubArray(int[] array, boolean[] bools, int start){
		if (start == array.length){
			System.out.print("{");
			for(int i =0; i < array.length;i++){
				if (bools[i] == true){
					System.out.print(array[i]);
				}
			}
			System.out.print("} ");
			return;
		}
		boolean[] temp = bools;
		temp[start] = false;
		printSubArray(array,bools,start+1);
		temp[start] = true;
		printSubArray(array,bools,start+1);
	}
}
