package programtasks;

import java.util.LinkedList;

public class ReverseLinkedList {
	public static Node lid;
	public static void main(String[] args) {
		Node head = new Node(null,0);
		Node curr = head;
		for (int i = 0; i < 10; i++){
			curr.next = new Node(null,i);
			curr = curr.next;
		}
		curr = head.next;
		System.out.println("In correct order");
        LinkedList<Integer> stack = new LinkedList<Integer>();
		while (curr != null){
			System.out.print(curr.data+" ");
			stack.add(curr.data); //pushing to the stack. adding to end of the stack
			curr = curr.next;
		}
		System.out.println("\n"+"In reverse order by using stack");
		while(!stack.isEmpty()){
			System.out.print(stack.removeLast() +" "); //popping from the stack. removing from the top of the stack
		}
		System.out.println("\n"+"In reverse order by using recursion");
		curr = head.next;
		Recursively(curr);
		
		curr = lid;
		while (curr != null){
			System.out.print(curr.data+" ");
			stack.add(curr.data); //pushing to the stack. adding to end of the stack
			curr = curr.next;
		}
		
		
	}

	private static void Recursively(Node top) {
		// TODO Auto-generated method stub
		if(top.next == null){
			lid = top;
			return;
		}
		Recursively(top.next);

		Node newNode = top.next; //This the value  we are inserting in our list
		newNode.next = top; //now points to previous element;
		top.next = null; //remove original pointer;
	}
}
class Node{
	Node next;
	int data;

	public Node(Node next,int data ){
		this.next = next;
		this.data = data;
	}
}
