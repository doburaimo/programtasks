package programtasks;

import java.util.Scanner;

public class StringPermutation {

	private static void permutate(char[] thestring,int start, int focus){
		if (start == focus){
			System.out.println(thestring);
			return;
		}
			
		for (int j = start; j <=focus; j++){
			char first = thestring[j];
			char second = thestring[start];
			thestring[j] = second;
			thestring[start] = first;
			permutate(thestring,start+1,focus);
			first = thestring[j];
		    second = thestring[start];
			thestring[j] = second;
			thestring[start] = first;
		
		}
	}

	public static void main(String[] args) {
		System.out.println("Enter the string to be permutated");
		Scanner scan = new Scanner(System.in);
		String input  = scan.next();
		char[] a = input.toCharArray();
		permutate(a,0,a.length-1);
		//char[] g = "abcdef".toCharArray();
		//System.out.println(g);
	}
}
