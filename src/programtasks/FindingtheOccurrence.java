package programtasks;

public class FindingtheOccurrence {
	public static void main(String[] args) {
		int[] array = {0,0,0,1,1,1,1,2,2,3,4,4,56};
		int number = 3; 
		System.out.println(count(number, array));
	}
	
	public static int count(int number, int[] array){
		int left = leftparse(number, array);
		int right = rightparse(number, array);
		if (right == -1 || left == -1){
			return 0;
		}
		return right - left + 1;
	}
	
	public static int leftparse(int number, int[] array){
		int left = 0;
		int right = array.length-1;
		int first = -1;

		while(left <= right){
			int current =  (left+right)/2;
			if (array[current] < number){
				left = current + 1;
			}
			else if (array[current] > number){
				right = current - 1;   
			}
			else{
				first = current; 
				right = current - 1;
			}

		}
		return first;
	}
	
	public static int rightparse(int number, int[] array){
		int left = 0;
		int right = array.length -1;
		int last = -1;
		while(left <= right){
			int current = (left + right)/2;
			if (array[current] < number){
				left = current + 1;
			}
			else if (array[current] > number){
				right = current - 1;  
			}
			else{
				last = current;
				left = current + 1;

			}
		}
		return last;
	}

}
