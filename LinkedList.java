public class LinkedList {

	private Node head;

	public static class Node {
		Node next;
		int data;

		Node(int data) {
			this.data = data;
		}
	}

	public void append(int data) {
		if (head == null) {
			head = new Node(data);
			return;
		}
		Node current = head;
		while (current.next != null) {
			current = current.next;
		}
		current = new Node(data);
	}

	public void prepend(int data) {
		Node newNode = new Node(data);
		newNode.next = head;
		head = newNode;
	}

	public void delete(int data) {
		if (head == null)
			return;
		if (head.data == data) {
			head = head.next;
			return;
		}
		Node current = head;
		while (current.next != null) {
			if (current.next.data == data) {
				current.next = current.next.next;
				return;
			}
			current = current.next;
		}
	}

}
