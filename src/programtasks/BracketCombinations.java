package programtasks;

import java.util.Random;

public class BracketCombinations {
	static int combinations = 0;
	
	public static void main(String[] args) {
		Random randomInteger = new Random();

		int number = randomInteger.nextInt(5) + 1;

		System.out.println("We will generate combinations based on " + number+ " left and right combinations " );
		generateBrackets(number,number,"");
		System.out.println(combinations + " combinations");
	}

	private static void generateBrackets(int left, int right, String string) {
		if (right == 0){
			System.out.println(string);
			combinations++;
			return;
		}
		if (right > left){
			generateBrackets(left, right-1, string + ")");
		}
		if (left > 0){
			generateBrackets(left-1, right, string + "(");
		}

	}
}
