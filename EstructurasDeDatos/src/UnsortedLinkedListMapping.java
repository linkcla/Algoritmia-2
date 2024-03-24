import java.util.Iterator;

public class UnsortedLinkedListMapping<K, V> {
    private class Node {
        private K key;
        private V value;
        private Node next;
        private Node (K key, V value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }
    private Node first;
    public UnsortedLinkedListMapping() {
        first = null;
    }

    public boolean contains(V value) {
        Node aux = first;
        while (aux != null) {
            if (aux.value.equals(value)) return true;
            aux = aux.next;
        }
        return false;
    }
    public V get(K key) {
        Node aux = first;
        while (aux != null) {
            if (key.equals(aux.key)) return aux.value;
            aux = aux.next;
        }
        return null;
    }
    public V put(K key, V value) {
        Node aux = first;
        boolean contains = false;
        while (!contains && aux != null) {
            contains = aux.key.equals(key);
            if(!contains) aux = aux.next;
        }
        V auxValue = null;
        if (contains) {
            auxValue = aux.value;
            aux.value = value;
        } else {
            first = new Node(key, value, first);
        }
        return auxValue;
    }
    public V remove(K key) {
        Node p = first; Node pp = null; boolean found = false;
        while (p != null && !found) {
            found = p.key.equals(key);
            if (!found) {
                pp = p;
                p = p.next;
            }
        }
        V auxValue = null;
        if (found) {
            auxValue = p.value;
            if (pp == null) {
                first = p.next;
            } else {
                pp.next = p.next;
            }
        }
        return auxValue;
    }
    public boolean isEmpty() { return first == null; }

    public Iterator iterator() { return new IteratorUnsortedLinkedListMapping(); }

    private class IteratorUnsortedLinkedListMapping implements Iterator {
        private Node idxIterator;
        private IteratorUnsortedLinkedListMapping() { idxIterator = first; }
        public boolean hasNext() { return idxIterator.next != null; }
        public Object next() {
            Pair pair = new Pair<>(idxIterator.key, idxIterator.value);
            idxIterator = idxIterator.next;
            return pair;
        }
    }

    public class Pair <K, V> {
        K key;
        V value;
        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }
        public V getValue() {
            return value;
        }
    }
}
