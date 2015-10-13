package programtasks;

import java.util.Scanner;

public class RotatingPalindrome {

	public static void main(String[] args) {
		System.out.println("Enter the rotating palindrome(Uppercase and lowercase equality is not supported)");
		Scanner scan = new Scanner(System.in);
		String input  = scan.next();
		isRotatingPalindrome(input);
	}
	public static boolean isPalindrome(char[] s){
		int left = 0;
		int right = s.length-1;
		while (right-left >0){
			if(s[left++] != s[right--] ){
				return false;
			}
		}
		return true;
	}
	public static boolean isRotatingPalindrome(String s){
		int start = 1;
		while (start < s.length()){
			if (isPalindrome(s.substring(start,s.length()).concat(s.substring(0, start++)).toCharArray())== true){
				System.out.println("The palindrome is "+ s.substring(--start,s.length()).concat(s.substring(0, start)));
				return true;
			}
		}
		System.out.println("No Palindrome Possible");
		return false;
	}
}
