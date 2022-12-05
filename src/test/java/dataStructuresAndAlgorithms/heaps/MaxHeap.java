package dataStructuresAndAlgorithms.heaps;

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

    void deleteFromHeap() {
        if (size == 0) return;

        int index = 1;
        array[1] = array[size];
        size--;

        while (index < size) {
            int leftIndex = index * 2;
            int rightIndex = index * 2 + 1;

            if (leftIndex < size && array[leftIndex] > array[index]) {
                int temp = array[leftIndex];
                array[leftIndex] = array[index];
                array[index] = temp;
                index = leftIndex;
            } else if (rightIndex < size && array[rightIndex] > array[index]) {
                int temp = array[rightIndex];
                array[rightIndex] = array[index];
                array[index] = temp;
                index = rightIndex;
            } else return;
        }
    }

    void heapify(int[] array1, int n, int i) {
        int largest = i;
        int leftIndex = largest * 2;
        int rightIndex = largest * 2 + 1;

        if (leftIndex <= n && array1[leftIndex] > array1[largest]) {
            largest = leftIndex;
        }
        if (rightIndex <= n && array1[rightIndex] > array1[largest]) {
            largest = rightIndex;
        }

        if (largest != i) {
            int temp = array1[largest];
            array1[largest] = array1[i];
            array1[i] = temp;
            heapify(array1, n, largest);
        }
    }

    void heapSort(int[] array3, int n) {
        int size = n;

        while (size > 1) {
            int temp = array3[1];
            array3[1] = array3[size];
            array3[size] = temp;
            size--;
            heapify(array3, size, 1);
        }
    }

    void print() {
        for (int i = 1; i <= size; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    void printArray(int[] array2) {
        for (int i = 1; i <= array2.length - 1; i++) {
            System.out.print(array2[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        MaxHeap maxHeap = new MaxHeap();

        maxHeap.insert(50);
        maxHeap.insert(55);
        maxHeap.insert(53);
        maxHeap.insert(52);
        maxHeap.insert(54);
        System.out.println("After Insert");
        maxHeap.print();

        System.out.println("After Delete");
        maxHeap.deleteFromHeap();
        maxHeap.print();

        int[] arr = new int[]{-1, 54, 53, 55, 52, 50};
        int n = 5;
        for (int i = n / 2; i > 0; i--) {
            maxHeap.heapify(arr, n, i);
        }
        System.out.println("After Heapify");
        maxHeap.printArray(arr);

        maxHeap.heapSort(arr,n);
        System.out.println("After heap sort");
        maxHeap.printArray(arr);

    }
}
