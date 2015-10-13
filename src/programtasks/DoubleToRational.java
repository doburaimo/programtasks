package programtasks;

import java.math.BigInteger;
import java.text.DecimalFormat;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class DoubleToRational {

	private static double input;
	private static boolean negative = false;
	private static Random randomNumber = new Random();

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Input a number");
		try{
			input = (double)scan.nextDouble();
		}	
		catch(InputMismatchException e){
			generate();
		}
		finally{
			if (input < 0){
				negative = true;	
				input = Math.abs(input);
			}
			if (input ==0){
				generate();
			}
			System.out.println(rationalize(input));
			scan.close();
		}
	}

	private static String rationalize(double thedouble) {
		DecimalFormat df = new DecimalFormat("#");
		df.setMaximumFractionDigits(100);// We don't want any computerized notations
		int decicount = 0;
		String numerator = df.format(thedouble);
		System.out.println("We are about to rationalize "+ numerator);
		if (numerator.contains(".")){
			decicount = numerator.length() - numerator.lastIndexOf('.')-1;
			numerator = numerator.substring(0, numerator.lastIndexOf('.')) + numerator.substring(numerator.lastIndexOf('.')+ 1, numerator.length());
		}
		BigInteger top = new BigInteger(numerator);
		BigInteger bottom = BigInteger.TEN.pow(decicount);
		BigInteger gcf = gcf(top,bottom);
		top = top.divide(gcf);
		bottom = bottom.divide(gcf);
		top = (negative)? top.negate() : top;
		return top + " / " + bottom;
	}


	private static void generate() {
		input = randomNumber.nextDouble()+0.1;
	}

	@SuppressWarnings("finally")
	private static BigInteger gcf(BigInteger a, BigInteger b){
		/*
		 * Does the Euciledian Algorithm to find Greatest Common Factor 
		 * if a = 40 && b = 16
		 * a = (somefactor)* b + a%b
		 *     remainder = a%b
		 * 		a will now be b while b = remainder
		 *     if remainder is 0 return b;
		 * 
		 */
		BigInteger remainder;
		BigInteger zero = BigInteger.ZERO;
		BigInteger error = zero;
		BigInteger answer = (b.compareTo(a) >0)? b: a;
		BigInteger modifier = (b.compareTo(a) >0)?a: b;
		try{

			while (answer.mod(modifier) != zero){ // Big Integer throws an exception when mod returns 0
				error = modifier;
				remainder = answer.mod(modifier);
				answer = modifier;
				modifier = remainder;
			}
		}
		catch(ArithmeticException e){
			modifier = error;
		}
		finally{
			return modifier;
		}
	}
}
