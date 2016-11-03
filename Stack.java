public class Stack {
	
	public static class Node{
		int data;
		Node next;
		Node(int data){
			this.data = data;
		}
	}
	
	private static Node top; 
	
	public void push(int data){
		Node node = new Node(data);
		node.next = top;
		top = node;
	}
	
	public int peek(){
		return top.data;
	}
	
	public int pop(){
		int node = top.data;
		top = top.next;
		return node;
	}
	
	public boolean isEmpty(){
		return top == null;
	}
}
