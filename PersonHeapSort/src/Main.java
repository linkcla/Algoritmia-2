import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) {

        Persona p1 = new Persona("Juan", 25);
        Persona p2 = new Persona("Angel", 20);
        Persona p3 = new Persona("Zoe", 23);
        Persona p4 = new Persona("Jose", 40);
        Persona p5 = new Persona("Marc", 43);
        Persona p6 = new Persona("Carlos", 28);

        PriorityQueue<Persona> cola = new PriorityQueue<Persona>();
        cola.offer(p1);
        cola.offer(p2);
        cola.offer(p3);
        cola.offer(p4);
        cola.offer(p5);
        cola.offer(p6);

        while (cola.size() > 0) {
            System.out.println(cola.poll());
        }

    }
}