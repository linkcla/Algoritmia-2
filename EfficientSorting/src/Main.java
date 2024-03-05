import java.util.Random;

public class Main {
    public static void main(String[] args) {

        int[] ns = {10, 100, 1000, 10000, 100000, 200000, 300000, 500000, 600000};
        int[] test;
        long ini;
        long fin;
        int[] arr = invertedArray(10);
        Sorting.quickSort(arr, 0, arr.length - 1);
        printArray(arr);
/*
        for (int n : ns) {
            //test = generateRandomArray(n);
            test = invertedArray(n);
            ini = System.currentTimeMillis();

            Sorting.selectionSort(test);
            //Sorting.quickSort(test, 0, test.length - 1);
            //Sorting.mergeSort(test,0, test.length - 1);

            fin = System.currentTimeMillis();
            System.out.println(fin - ini + " ms");
        }

 */

    }


    public static void printArray(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static int[] generateRandomArray(int size) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = (int)(Math.random() * 100);
        }
        return arr;
    }

    public static int[] invertedArray(int n) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = n - i;
        }
        return arr;
    }
}