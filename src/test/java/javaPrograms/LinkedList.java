package javaPrograms;

public class LinkedList {

	private Node head; // head of list

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
			counter++;
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
		System.out.print("Elements in the Linked List: ");
		while (tNode != null) {
			System.out.print(tNode.data + " ");
			tNode = tNode.next;
		}
		System.out.println();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList obj = new LinkedList();
		// obj.getFront();
		obj.addFront(12);
		obj.addFront(34);
		obj.addBack(13);
		obj.addBack(98);
		System.out.println("Front Element: " + obj.getFront());
		obj.printList();
		System.out.println("Deleting Front Element 34");
		obj.deleteValue(34);
		System.out.println("Front Element: " + obj.getFront());
		obj.printList();
		System.out.println("Last Element: " + obj.getLast());
		System.out.println("Size of the Linked List: " + obj.getSize());
		System.out.println("Deleting Last Element 98");
		obj.deleteValue(98);
		obj.printList();
		System.out.println("Size of the Linked List: " + obj.getSize());
	}
}
