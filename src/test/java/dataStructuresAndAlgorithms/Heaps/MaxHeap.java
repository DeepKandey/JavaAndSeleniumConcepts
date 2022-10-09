package dataStructuresAndAlgorithms.Heaps;

public class MaxHeap {

    int[] array = new int[100];
    int size = 0;

    void insert(int number) {
        size = size + 1;
        int index = size;
        array[index] = number;

        while (index > 1) {
            int parent = index / 2;

            if (array[parent] < array[index]) {
                int temp = array[parent];
                array[parent] = number;
                array[index] = temp;
                index = parent;
            } else return;
        }

    }

    void print() {
        for (int i = 1; i <= size; i++) {
            System.out.println(array[i]);
        }
    }

    public static void main(String[] args) {
        MaxHeap maxHeap = new MaxHeap();
        maxHeap.insert(50);
        maxHeap.insert(55);
        maxHeap.insert(53);
        maxHeap.insert(52);
        maxHeap.insert(54);

        maxHeap.print();
    }
}
