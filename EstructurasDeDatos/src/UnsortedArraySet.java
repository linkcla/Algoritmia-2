import java.util.Iterator;

public class UnsortedArraySet<E> {
    private E[] array;
    private int n;
    // Prepara l’array per emmagatzemar el conjunt
    public UnsortedArraySet(int max){
        array = (E[]) new Object[max];
        n = 0;
    }

    // Consultar si el conjunt conté l’element
    public boolean contains(E elem) {
        boolean contains = false;
        int i = 0;
        while (!contains && i < n) {
            contains = elem.equals(array[i]);
            i++;
        }
        return contains;
    }

    // Afegir un element al conjunt (si encara no es troba present)
    // Retorna true si s'ha canviat el conjunt
    public boolean add(E elem) {
        if (n < array.length && !contains(elem)){
            array[n++] = elem;
            return true;
        }
        return false;
    }

    // Eliminar un element del conjunt (si es troba present)
    // Retorna true si s'ha canviat el conjunt
    public boolean remove(E elem) {
        if (n == 0) return false;
        boolean changed = false;
        int i = 0;
        while (!changed && i < n) {
            if (elem.equals(array[i])) {
                n--;
                array[i] = array[n];
                changed = true;
            }
            i++;
        }
        return changed;
    }

    //Consultar si el conjunt es troba buit
    public boolean isEmpty() {
        return n == 0;
    }

    public Iterator iterator() {
        return new IteratorUnsortedArraySet();
    }

    private class IteratorUnsortedArraySet implements Iterator {
        private int iteratorI;
        private IteratorUnsortedArraySet() {
            iteratorI = 0;
        }

        @Override
        public boolean hasNext() {
            return iteratorI < n;
        }
        @Override
        public Object next() {
            return array[iteratorI++];
        }
    }
}
