package javaPrograms;


// https://www.techiedelight.com/stack-implementation-using-linked-list/

public class Stack {
	private Node head;

	static class Node { // A linked list node
		int data;
		Node next;  // Pointer to the next node

		public Node(int data) {
			this.data = data;
			next = null;
		}
	}

	// Utility function to add an element x in the stack
	public void push(int data) {  // insert at the beginning
		System.out.println("--Entering " + data + " in Stack--");
		Node newNode = new Node(data);

		if (head == null) {
			head = newNode;
			return;
		} else {
			newNode.next = head;
			head = newNode;
		}
	}

	public boolean isEmpty() {
		return head == null;
	}

	// Utility to return top element in Stack
	public int peek() {
		if (head == null) {
			throw new IllegalArgumentException("Empty List");
		} else {
			return head.data;
		}
	}

	public void printStack() {
		Node tNode = head;
		System.out.print("Elements in Stack:--> ");
		while (tNode != null) {
			System.out.print(tNode.data + " ");
			tNode = tNode.next;
		}
		System.out.println();
	}

	// Utility function to pop top element from the stack
	public void pop() // remove at the beginning
	{
		if (head == null) {
			System.out.println("Stack Underflow");
			return;
		}
		System.out.println("Removing " + peek());
		head = head.next;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Stack obj = new Stack();
		obj.push(12);
		System.out.println("Top Element in Stack is :--> " + obj.peek());
		obj.printStack();
		obj.push(34);
		System.out.println("Top Element in Stack is:--> " + obj.peek());
		obj.printStack();
		obj.pop();
		obj.printStack();
		obj.pop();
		System.out.println("Is stack Empty? " + obj.isEmpty());

	}
}
