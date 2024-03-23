import java.util.Iterator;

public class UnsortedLinkedListSet<E> {
    private class Node {
        private E elem;
        private Node next;

        private Node (E elem, Node next){
            this.elem = elem;
            this.next = next;
        }
    }

    private Node first;
    
    public UnsortedLinkedListSet() {
        first = null;
    }

    public boolean contains(E elem) {
        Node aux = first; boolean contains = false;
        while (!contains && aux != null) {
            contains = aux.elem.equals(elem);
            aux = aux.next;
        }
        return contains;
    }

    public boolean add(E elem) {
        if (contains(elem)) return false;
        first = new Node(elem, first);
        return false;
    }

    public boolean remove(E elem) {
        Node p = first; Node pp = null; boolean found = false;
        while (p != null && !found) {
            found = p.elem.equals(elem);
            if (!found) {
                pp = p;
                p = p.next;
            }
        }
        if (found) {
            if (pp == null) {
                first = p.next;
            } else {
                pp.next = p.next;
            }
        }
        return found;
    }

    public boolean isEmpty () { return first == null; }

    public Iterator iterator() { return new IteratorUnsortedLinkedListSet(); }
    private class IteratorUnsortedLinkedListSet implements Iterator {
        private Node idxIterator;
        private IteratorUnsortedLinkedListSet() { idxIterator = first; }
        public boolean hasNext() { return  idxIterator.next != null ;}
        public Object next() {
            E elem = idxIterator.elem;
            idxIterator = idxIterator.next;
            return elem;
        }
    }
}
