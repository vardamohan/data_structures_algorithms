public class Queue {

	public static class Node {
		int data;
		Node next;

		Node(int data) {
			this.data = data;
		}
	}

	Node head;
	Node tail;

	public void add(int data) {
		Node node = new Node(data);
		if (tail != null) {
			tail.next = node;
		}
		tail = node;
		if (head == null) {
			head = tail;
		}
	}

	public boolean isEmpty() {
		return head == null;
	}

	public int peek() {
		return head.data;
	}

	public int remove() {
		int data = head.data;
		head = head.next;
		if(head == null)
			tail = null;
		return data;
	}

}
