public class LinkedListCycle {

	static Node head;

	public static class Node {
		int data;
		Node next;

		Node(int data) {
			this.data = data;
		}
	}

	public static boolean hasCycle(Node head) {
		if (head == null)
			return false;
		Node slow = head;
		Node fast = head.next;
		while (slow != null && fast != null && fast.next != null) {
			if (slow == fast)
				return true;
			slow = slow.next;
			fast = fast.next.next;
		}
		return false;
	}

	public static void removeCycle(Node head) {
		if (head == null)
			return;
		Node slow = head;
		Node fast = head.next;
		while (slow != null && fast.next != null && fast != null) {
			if (slow == fast)
				break;
			slow = slow.next;
			fast = fast.next.next;
		}
		slow = head;
		fast = fast.next;
		Node prev = fast;
		while (slow != null && fast != null) {
			if (slow == fast) {
				prev.next = null;
				return;
			}
			prev = fast;
			slow = slow.next;
			fast = fast.next;
		}
	}

	public static void main(String args[]) {
		Node n1 = new Node(1);
		Node n2 = new Node(2);
		Node n3 = new Node(3);
		Node n4 = new Node(4);
		Node n5 = new Node(5);
		Node n6 = new Node(6);
		Node n7 = new Node(7);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;
		n6.next = n7;
		n7.next = n4;
		head = n1;
		System.out.println(hasCycle(head));
		removeCycle(head);
		System.out.println(hasCycle(head));
	}

}
