package javaPrograms;

public class DynamicArray {

	private int initialCapacity;
	private Object[] data;
	private int size;

	public DynamicArray(int initialCapacity) {
		this.initialCapacity = initialCapacity;
		data = new Object[initialCapacity];
	}

	public String get(int index) {
		return data[index].toString();
	}

	public void set(int index, String value) {
		data[index] = value;
	}

	public void insert(int index, String value) {
		// Check size
		if (size == initialCapacity) {
			resize();
		}

		// Copy Up
		for (int j = size; j > index; j--) {
			data[j] = data[j - 1];
		}

		// Insert
		data[index] = value;
		size++;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public boolean contains(String value) {
		boolean flag = false;
		for (int i = 0; i < size - 1; i++) {
			if (data[i] == value) {
				flag = true;
				break;
			}
		}
		return flag;
	}

	public void delete(int index) {
		// Copy data

		for (int j = index; j < size - 1; j++) {
			data[j] = data[j + 1];
		}
		size--;

	}

	public void resize() {
		Object[] newData = new Object[initialCapacity * 2];
		for (int i = 0; i < initialCapacity; i++) {
			newData[i] = data[i];
		}
		data = newData;
		initialCapacity = initialCapacity * 2;
	}

	public int size() {
		return size;
	}

	public void print() {
		for (int i = 0; i < size; i++) {
			System.out.println(data[i]);
		}
	}

	public void add(String value) {
		if (size == initialCapacity) {
			resize();
		}

		data[size] = value;
		size++;
	}

	public static void main(String[] args) {

	}

}
