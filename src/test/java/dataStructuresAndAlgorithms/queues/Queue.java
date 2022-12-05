package dataStructuresAndAlgorithms.queues;

public class Queue {

  private Node head; // remove things here
  private Node tail; // add things here

  private static class Node {
    private int data;
    private Node next;

    public Node(int data) {
      this.data = data;
      this.next = null;
    }
  }

  public void enQueue(int data) {
    // Create a new node
    // Set the current tail.next to point to this new node
    // Then set the new node to be the new tail

    Node newNode = new Node(data);
    System.out.println("Inserting " + data);

    if (tail != null) {
      tail.next = newNode;
    }
    tail = newNode;

    // handle case of first element where head is null
    if (head == null) {
      head = tail;
    }
  }

  // Utility to return top element in Stack
  public int peek() {
    if (head == null) {
      throw new IllegalArgumentException("Empty Queue");
    } else {
      return head.data;
    }
  }

  public void deQueue() {
    if (head == null) {
      System.out.println("Empty Queue");
      return;
    }
    System.out.println("Removing " + peek());

    // Point the head to the next element (effectively removing it)
    head = head.next;

    // Handle queue now being empty
    if (head == null) {
      tail = null;
    }
  }

  public boolean isEmpty() {
    return (head == null);
  }

  public void printQueue() {
    Node tNode = head;

    System.out.print("Elements in Queue:--> ");
    while (tNode != null) {
      System.out.print(tNode.data + " ");
      tNode = tNode.next;
    }
    System.out.println();
  }

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    Queue obj = new Queue();
    obj.enQueue(12);
    obj.printQueue();
    obj.enQueue(13);
    obj.printQueue();
    obj.deQueue();
    obj.printQueue();
  }
}
