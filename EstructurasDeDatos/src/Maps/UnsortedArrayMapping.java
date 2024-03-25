package Maps;

import javax.management.ObjectName;
import java.util.Iterator;

public class UnsortedArrayMapping<K, V> {
    private K[] claus;
    private V[] valors;
    private int n;
    // Prepara els arrays per emmagatzemar el mapping
    public UnsortedArrayMapping(int max){
        claus = (K[]) new Object[max];
        valors = (V[]) new Object[max];
        n = 0;
    }

    // Consultar el valor associat a la clau
    public V get(K key) {
        Integer i = contaisKey(key);
        if (i == null) return null;
        return valors[i];
    }
    // Afegir una parella clau-valor
    // Retorna el valor anterior associat a la clau, si n’hi havia, o null
    public V put(K key, V value) {
        if (n < claus.length) return null;
        Integer i = contaisKey(key);
        if (i == null) {
            claus[n] = key;
            valors[n] = value;
            n++;
            return null;
        } else {
            V aux;
            aux = valors[i];
            valors[i] = value;
            return aux;
        }
    }

    // Eliminar l’associació d’una clau
    // Retorna el valor associat a la clau, si n’hi havia, o null
    public V remove(K key) {
        if (n == 0) return null;
        Integer i = contaisKey(key);
        if (i == null) return null;
        V aux;
        aux = valors[i];
        n--;
        claus[i] = claus[n];
        valors[i] = valors[n];
        return aux;
    }

    // Consultar si el mapping es troba buit
    public boolean isEmpty() {
        return n == 0;
    }

    private Integer contaisKey(K elem) {
        Integer pos = null;
        int i = 0;
        boolean found = false;
        while (!found && i < n) {
            if (elem.equals(claus[i])) {
                pos = i;
                found = true;
            }
            i++;
        }
        return pos;
    }

    public Iterator iterator() { return new IteratorUnsortedArrayMapping(); }

    private class IteratorUnsortedArrayMapping implements Iterator {
        private int iteratorI;
        private IteratorUnsortedArrayMapping() {
            iteratorI = 0;
        }

        @Override
        public boolean hasNext() {
            return iteratorI < n;
        }
        @Override
        public Object next() {
            return new Pair<>(claus[iteratorI], valors[iteratorI]);
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
