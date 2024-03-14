public class Sorting {
    public static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }

    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int split = partition(arr, low, high);

            quickSort(arr, low, split - 1);
            quickSort(arr, split + 1, high);
        }

    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = getPivot(arr, low, high);
        int split = low;
        for (int j = low; j <= high - 1; j++) {
            if (arr[j] < pivot) {
                swap(arr, split, j);
                split++;
            }
        }
        swap(arr, split, high);
        return split;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    public static void mergeSort(int[] arr, int low, int high) {
        if (low < high) {
            int m = (low + high)/2;
            mergeSort(arr, low, m);
            mergeSort(arr, m+1, high);
            merge(arr, low, m , high);
        }
    }

    public static void merge(int[] arr, int l, int m, int r) {
        int[] lArr = new int[m-l+1];
        int[] rArr = new int[r-m];

        for (int i = 0; i<lArr.length; i++) {
            lArr[i] = arr[l+i];
        }
        for (int j = 0; j<rArr.length; j++) {
            rArr[j] = arr[m+1+j];
        }

        // Merge
        int i = 0, j = 0; int k = l;
        while (i < lArr.length && j < rArr.length) {
            if (lArr[i] < rArr[j]) {
                arr[k] = lArr[i];
                i++;
            } else {
                arr[k] = rArr[j];
                j++;
            }
            k++;
        }

        while (i < lArr.length) {
            arr[k] = lArr[i];
            i++;
            k++;
        }

        while (j < rArr.length) {
            arr[k] = rArr[j];
            j++;
            k++;
        }
    }


    private static int getPivot (int[] arr, int low, int high) {
        int mid = (low + high) / 2;

        if (arr[low] > arr[mid]) swap(arr, low, mid);
        if (arr[high] < arr[low]) swap(arr, low, high);
        else if (arr[mid] < arr[high]) swap(arr, mid, high);
        return arr[high];
    }

}
