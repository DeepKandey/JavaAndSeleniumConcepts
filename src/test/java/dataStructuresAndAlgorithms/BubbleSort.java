package dataStructuresAndAlgorithms;

public class BubbleSort {

  static int[] unsortedArray = {212, 5, 6, 1, 4, 0, 3, 9};

  public int[] sort(int[] array) {
    int size = unsortedArray.length;
    for (int i = 0; i < size; i++) {
      for (int j = 0; j < size - i - 1; j++) {
        if (array[j] > array[j + 1]) {
          int temp = array[j];
          array[j] = array[j + 1];
          array[j + 1] = temp;
        }
      }
    }
    return array;
  }

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    BubbleSort obj = new BubbleSort();

    System.out.println("--UnSorted Array--");
    for (int i = 0; i < unsortedArray.length; i++) {
      System.out.print(unsortedArray[i] + " ");
    }
    System.out.println();

    int[] sortedArray = obj.sort(unsortedArray);
    System.out.println("--Sorted Array--");
    for (int i = 0; i < sortedArray.length; i++) {
      System.out.print(sortedArray[i] + " ");
    }
  }
}
