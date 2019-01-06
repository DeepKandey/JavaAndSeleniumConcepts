package javaPrograms;

public class LinkedList {

	Node head; // head of list

	static class Node {
		int data;
		Node next;

		// Constructor
		public Node(int data) {
			this.data = data;
			next = null;
		}
	}

	public void addFront(int data) {
		// Create new Node
		Node newNode = new Node(data);

		// Check if we are adding node for first time
		if (head == null) {
			head = newNode;
			return;
		} else {
			// Set new node's next to the current node
			newNode.next = head;

			// Set current head to point new node
			head = newNode;
		}
	}

	public void addBack(int data) {
		// Create new Node
		Node newNode = new Node(data);

		// Check if we are adding node for first time
		if (head == null) {
			head = newNode;
			return;
		} else {
			// Else traverse list till the last node
			Node last = head;
			while (last.next != null) {
				last = last.next; // O(n)
			}
			// Insert the new node at last node
			last.next = newNode;
		}
	}

	public int getFront() {
		if (head == null) {
			throw new IllegalArgumentException("Empty List");
		} else {
			return head.data;
		}
	}

	public int getLast() {
		if (head == null) {
			throw new IllegalArgumentException("Empty List");
		} else {
			Node last = head;
			while (last.next != null) {
				last = last.next; // O(n)
			}
			return last.data;
		}
	}

	public int getSize() {
		int counter = 0;

		if (head == null) {
			return counter;
		} else {
			Node node = head;
			while (node.next != null) {
				counter++;
				node = node.next;
			}
			return counter;
		}
	}

	public void clear() {
		head = null;
	}

	public void deleteValue(int data) {
		// if linked list is empty
		if (head == null) {
			return;
		}

		// if head is to be removed
		if (head.data == data) {
			head = head.next;
			return;
		}

		// else walk the list
		Node current = head;
		while (current.next != null) {
			if (current.next.data == data) {
				current.next = current.next.next;
				return;
			}
			current = current.next;
		}
	}

	public void printList() {
		Node tNode = head;

		while (tNode != null) {
			System.out.println(tNode.data + " ");
			tNode = tNode.next;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}
