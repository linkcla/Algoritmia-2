import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int i = sc.nextInt();

        // Iteramos sobre cada uno de los caso de prueba
        while (i != 0) {
            int[] arr = new int[i];
            // Guardamos los elementos del caso de prueba
            for (int j = 0; j < i; j++) {
                arr[j] = sc.nextInt();
            }
            // Ordenamos el array O(n log(n))
            quickSort(arr, 0, arr.length - 1);

            int moda = 0;
            int modaCount = 0;
            int modaAux = arr[0];
            int modaCountAux = 1;
            // Buscamos cual es la moda O(n)
            for (int j = 1; j < i; j++) {
                if (arr[j] == modaAux){
                    modaCountAux++;
                } else {
                    // arr[j] != modaAux
                    if (modaCount < modaCountAux){
                        moda = modaAux;
                        modaCount = modaCountAux;
                    }
                    modaAux = arr[j];
                    modaCountAux = 1;
                }

            }
            // Por si la moda está al final del array
            if (modaCount < modaCountAux) moda = modaAux;

            // Imprimimos la moda
            System.out.println(moda);
            // Leemos si entrarán mas casos de prueba, si lee 0 se acaba el programa
            i = sc.nextInt();
        }
    }

    // El metodo de ordenación elegido es el quickSort ya que es
    // O(n log(n)) y añadiendo el metodo getPivot() evita la existencia
    // del peor de los casos. (Visto en clase, sin modificaciones)
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

    //Usamos get pivot para eliminar la existencia del peor de los casos
    private static int getPivot (int[] arr, int low, int high) {
        int mid = (low + high) / 2;

        // Encontrar la mediana y ponerlo en arr[high]
        if (arr[low] > arr[mid]) swap(arr, low, mid);
        if (arr[high] < arr[low]) swap(arr, low, high);
        else if (arr[mid] < arr[high]) swap(arr, mid, high);
        return arr[high];
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}

