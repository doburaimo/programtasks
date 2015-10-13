package programtasks;

import java.util.LinkedList;



public class CheckBST {


	public static void main(String[] args) {

		//      4
		//  2       6
		//1   3   5   7 
		//              10
		Noder head = new Noder(4);
		head.left = new Noder(2);
		head.left.right = new Noder(3);
		head.right = new Noder(6);
		head.right.left = new Noder(5);
		head.left.left = new Noder(1);
		head.right.right = new Noder(7);
		head.right.right.right = new Noder(10);
         
		System.out.println(isBinary(head));
		int level = 1;
		Noder f= head;
        levelPrint(head,level);
        //head = f;
        System.out.println();
        queueImplementation(head,level);
        System.out.println();
	}

	private static void queueImplementation(Noder head, int level) {
		LinkedList<Noder> traverse = new LinkedList<Noder>();
		LinkedList<Integer> queuevalues = new LinkedList<Integer>();
		int ourlevel = 0;
		if (head == null){
			return;
		}
		traverse.add(head);
		queuevalues.add(0);
		while (!traverse.isEmpty()){
			Noder current = traverse.removeFirst();
			int phase = queuevalues.removeFirst();
			
			if (current == null) return;
			
			if (phase == level){
				System.out.print(current.data+ " ");
			}
			
			if (current.left !=null){
				traverse.add(current.left);
				queuevalues.add(phase+1);
			}
			if (current.right !=null){
				traverse.add(current.right);
				queuevalues.add(phase+1);
			}
		}
	}

	private static void levelPrint(Noder head, int level) {
		if(level == 0 && head!=null){
			System.out.print(head.data + " ");
			return;
		}
		if (head == null){
			return;
		}
		levelPrint(head.left,level-1);
		levelPrint(head.right,level-1);
		
		
	}

	private static boolean isBinary(Noder head) {
		// TODO Auto-generated method stub
		//System.out.println(head.data);
		if (head == null)return true;
		if (head.left !=null){
			if (head.left.data > head.data){
				return false;
			}
			if (!isBinary(head.left))return false;
		}	
		if(head.right !=null){
			if (head.right.data < head.data){
				return false;
			}
			if (!isBinary(head.right))return false;
		}
		return true;
	}


}


class Noder{
	Noder right;
	Noder left;
	int data;

	public Noder(int data){
		this.data = data;
	}

}  