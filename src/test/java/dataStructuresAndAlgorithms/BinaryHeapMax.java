package dataStructuresAndAlgorithms;

import java.util.Arrays;

public class BinaryHeapMax {

	private int capacity = 10;
	private int size = 0;

	public int[] items = new int[capacity];

	private int leftChildIndex(int parentIndex) {
		return (2 * parentIndex + 1);
	}

	private int rightChildIndex(int parentIndex) {
		return (2 * parentIndex + 2);
	}

	private int parentIndex(int childIndex) {
		return (childIndex - 1) / 2;
	}

	private boolean hasLeftChild(int index) {
		return leftChildIndex(index) < size;
	}

	private boolean hasRightChild(int index) {
		return rightChildIndex(index) < size;
	}

	private boolean hasParent(int index) {
		return parentIndex(index) >= 0;
	}

	private int leftChild(int index) {
		return items[leftChildIndex(index)];
	}

	private int rightChild(int index) {
		return items[rightChildIndex(index)];
	}

	private int parent(int index) {
		return items[parentIndex(index)];
	}

	public int extractMax() {
		if (size == 0)
			throw new IllegalStateException();
		int item = items[0]; // Grab the max
		items[0] = items[size - 1]; // swap top and bottom
		size--; // effectively
		heapifyDown();
		return item;
	}

	public void heapifyDown() {
		int index = 0; // start at the top

		// as long as I have children
		// Note: Only need to check left because if no left, there is no right
		while (hasLeftChild(index)) {

			// take the larger of the two indexes
			int smallerChildIndex = leftChildIndex(index);
			if (hasRightChild(index) && rightChild(index) > leftChild(index)) {
				smallerChildIndex = rightChildIndex(index);
			}

			// now compare

			// if I am larger than the items of my two children..
			// then everything is good. I am sorted..
			if (items[index] > items[smallerChildIndex]) {
				break;
			} else {
				// we are still not in order...swap
				swap(index, smallerChildIndex);
			}

			// then move down to smaller child
			index = smallerChildIndex;
		}
	}

	private void swap(int indexOne, int indexTwo) {
		int tempIndex = items[indexOne];
		items[indexOne] = items[indexTwo];
		items[indexTwo] = tempIndex;
	}

	private void ensureCapacity() {
		if (size == capacity) {
			items = Arrays.copyOf(items, capacity * 2);
			capacity *= 2;
		}
	}

	public void insert(int item) {
		ensureCapacity();
		items[size] = item; // put in last spot
		size++;
		heapifyUp();
	}

	private void heapifyUp() {
		int index = size - 1; // start at the last element
		// while my parents are less than me
		while (hasParent(index) && parent(index) < items[index]) {
			swap(parent(index), items[index]);
			index = parentIndex(index); // walk upwards to next node;
		}
	}

	public void print() {
		for (int i = 0; i < size; i++) {
			System.out.println(i + "[" + items[i] + "]");
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}
