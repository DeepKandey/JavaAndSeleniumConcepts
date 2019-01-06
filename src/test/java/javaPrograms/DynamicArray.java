package javaPrograms;

public class DynamicArray {

	private int initialCapacity;
	private Object[] data;
	private int size = 0;

	public DynamicArray(int initialCapacity) {
		this.initialCapacity = initialCapacity;
		data = new Object[initialCapacity];
	}

	public String get(int index) {
		return data[index].toString();
	}

	public void set(int index, String value) {
		data[index] = value;
		size++;
	}

	public void insert(int index, String value) {
		// Check size
		if (size == initialCapacity) {
			resize();
		}

		// Copy Up
		for (int j = size - 1; j > index; j--) {
			data[j] = data[j - 1];
		}

		// Insert
		data[index] = value;
		size++;
	}

	public boolean isEmpty() {
		return size() == 0;
	}

	public boolean contains(String value) {
		boolean flag = false;
		for (int i = 0; i < size(); i++) {
			if (data[i].toString().equals(value)) {
				flag = true;
				break;
			}
		}
		return flag;
	}

	public void delete(int index) {
		// Copy data
		for (int j = index; j < size(); j++) {
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
		int counter = 0;
		for (int i = 0; i < data.length; i++) {
			if (data[i] != null) {
				counter++;
			}
		}
		size = counter;
		return size;
	}

	public void print() {
		System.out.print("Printing values from the array--> ");
		for (int i = 0; i < size(); i++) {
			System.out.print(data[i] + " ");
		}
		System.out.println();
	}

	public void add(String value) {
		if (size == initialCapacity) {
			resize();
		}

		data[size] = value;
		size++;
	}

	public static void main(String[] args) {
		DynamicArray obj = new DynamicArray(10);
		obj.set(0, String.valueOf(1));
		obj.print();
		System.out.println("Size of the array: " + obj.size());
		obj.add(String.valueOf(2));
		obj.print();
		System.out.println("Size of the array: " + obj.size());
		System.out.println("Does array contains 3: " + obj.contains(String.valueOf(3)));
		obj.insert(2, String.valueOf(3));
		obj.print();
		System.out.println("Size of the array: " + obj.size());
		System.out.println("Does array contains 3: " + obj.contains(String.valueOf(3)));
		System.out.println("Is array empty?? " + obj.isEmpty());
		System.out.println("Length of the initial array: " + obj.data.length);
		obj.resize();
		System.out.println("After resizing, Length of the array: " + obj.data.length);
		obj.delete(2);
		System.out.println("After deleting data from index 2, Values from the array: ");
		obj.print();
		System.out.println("Size of the array: " + obj.size());
	}
}
