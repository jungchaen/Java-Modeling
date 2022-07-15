public class InsertionSort {
    public static int[] numbers = { 3, 15, 8, 2, 4, 1 };

    public static void insertionSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            for (int j = i; j > 0; j--) {
                if (array[j - 1] > array[j]) {
                    swap(array, j - 1, j);
                }
            }
        }
    }

    public static void swap(int[] array, int i, int j) {
        int temp = array[j];
        array[j] = array[i];
        array[i] = temp;
    }

    public static void printArray(int[] array) {
        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        printArray(numbers);
        insertionSort(numbers);
        printArray(numbers);
    }
}
