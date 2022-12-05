package dataStructuresAndAlgorithms.sorting;

import java.util.Arrays;

public class QuickSort {

    int partition(int[] array, int start, int end) {

        int pivot = array[start];
        int count = 0;

        for (int i = start + 1; i <= end; i++) {
            if (array[i] <= pivot) count++;
        }

        int pivotIndex = start + count;

        int temp = array[pivotIndex];
        array[pivotIndex] = array[start];
        array[start] = temp;

        int i = start, j = end;

        while (i < pivotIndex && j > pivotIndex) {
            while (array[i] < array[pivotIndex]) i++;
            while (array[j] > array[pivotIndex]) j--;

            if (i < pivotIndex && j > pivotIndex) {
                int temp_1 = array[i];
                array[i] = array[j];
                array[j] = temp_1;
            }
        }

        return pivotIndex;
    }

    void quickSorting(int[] array, int start, int end) {
        // Base case
        if (start > end) return;

        int pivot = partition(array, start, end);

        // Quick sort left part
        quickSorting(array, start, pivot - 1);
        // Quick sort right part
        quickSorting(array, pivot + 1, end);
    }

    public static void main(String[] args) {

        int[] array = new int[]{34, 89, 56, 24, 65};

        QuickSort quickSort = new QuickSort();
        quickSort.quickSorting(array, 0, 4);

        System.out.println(Arrays.toString(array));
    }
}
