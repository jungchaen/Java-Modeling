public class BubbleSortGenerics {
    public static <T extends Comparable<T>> void bubbleSort(T[] array) {
        for (int i = 1; i < array.length; i++) {
            for (int j = 0; j < array.length - i; j++) {
                if (array[j].compareTo(array[j + 1]) > 0) {
                    swap(array, j, j + 1);
                }
            }
        }
    }

    public static <T extends Comparable<T>> void swap(T[] array, int i, int j) {
        T temp = array[j];
        array[j] = array[i];
        array[i] = temp;
    }

    public static <T extends Comparable<T>> void printArray(T[] array) {
        for (T i : array) {
            System.out.print(i + " ");
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        Integer[] numbers = new Integer[] { 1, 15, 3, 4, 6 };
        printArray(numbers);
        bubbleSort(numbers);
        printArray(numbers);
    }
}
