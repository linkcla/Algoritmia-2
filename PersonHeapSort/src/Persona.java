public class Persona implements Comparable<Persona> {
    private String name;
    private int age;

    public Persona(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }

    @Override
    public int compareTo(Persona o) {
        if (this.name.compareTo(o.getName()) > 0) {
            return 1;
        } else if (this.name.compareTo(o.getName()) < 0) {
            return -1;
        } else {
            if (this.age > o.getAge()) {
                return 1;
            } else if (this.age < o.getAge()) {
                return -1;
            } else {
                return 0;
            }
        }
    }

    @Override
    public String toString() {
        return "Name: " + name + " Age: " + age;
    }
}
