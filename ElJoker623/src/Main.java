import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int i = sc.nextInt();
        // read \n
        sc.nextLine();

        for (int j = 0; j < i; j++) {
            HashMap<Character, Integer> map = new HashMap<>();
            String line = sc.nextLine();
            String[] parts = line.split(" ");

            // Metemos el numero ganador al mapa
            for (int k = 0; k < parts[0].length(); k++) {
                Integer aux = map.put(parts[0].charAt(k),1);
                if (aux != null) map.put(parts[0].charAt(k), 1+aux);
            }

            //Miramos si ganamos
            for (int l = 0; l < parts[1].length(); l++) {
                Integer aux = map.get(parts[1].charAt(l));
                if (aux == null){
                    System.out.println("PIERDE");
                    break;
                } else if (aux != 1){
                    map.put(parts[1].charAt(l), aux-1);
                } else {
                    map.remove(parts[1].charAt(l));
                }

            }
            if (map.isEmpty()) System.out.println("GANA");

        }
    }
}