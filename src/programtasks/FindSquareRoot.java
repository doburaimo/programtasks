package programtasks;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class FindSquareRoot {
	static double precision = 0.0000000001;


	public static double sqrt(double number){

		if (number < -1){
			return 0;
		}
		if (number == 1 || number == 0){
			return number;
		}
		double guess = number / 2.0 ;
		double guesscheck;
		while(Math.abs( guess*guess - number) > precision ){
			guesscheck = guess;
			guess = (guess + (number/guess)) / 2;
			if (guesscheck == guess){
				break;  //break out of an infinite loop; 
			}
		}
		int integer = (int)guess;
		if (integer*integer == number){
			return integer;
		}
		return  guess;	
	}
	public static void main(String[] args) {
		System.out.println("Find the squareroot of what number? You tell me ");
		Scanner scan = new Scanner(System.in);
		Random randomNumber = new Random();
		int size = 0;
		try{
			size = scan.nextInt();
		}	
		catch(InputMismatchException e){
			size = randomNumber.nextInt(100000);
			System.out.println(size);
		}


		finally{
			System.out.println(sqrt(size));
			scan.close();
		}
	}
}
