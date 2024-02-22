import java.util.Random;

public class Main {
    public static void main(String[] args) {

        int[] arr = generateRandomArray(600000);
        //printArray(arr);
        long initialTime = System.currentTimeMillis();
        Sorting.selectionSort(arr);
        //printArray(arr);
        long executionTime = System.currentTimeMillis() - initialTime;
        System.out.println(executionTime);
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
}