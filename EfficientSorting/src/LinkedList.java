public class LinkedList<E extends Comparable<E>> {
    private Node fist;

    public LinkedList() {
        this.fist = null;
    }

    public void add(E item) {
        this.fist = new Node(item, this.fist);
    }

    //O(n)
    private Node middle(Node firstNode) {
        Node slow = firstNode;
        Node fast = firstNode;
        while (fast.getNext() != null && fast.getNext().getNext() != null) {
            slow = slow.getNext();
            fast = fast.getNext().getNext();
        }
        return slow;
    }

    public void mergeSort() {
        this.fist = mergeSort(this.fist);
    }

    private Node mergeSort(Node n) {
        if (n == null || n.getNext() == null) {
            return n;
        }
        Node middle = middle(n);
        Node nextToMiddle = middle.getNext();
        middle.setNext(null);
        Node left = mergeSort(n);
        Node right = mergeSort(nextToMiddle);
        return merge(left, right);
    }

    private Node merge(Node l, Node r) {
        Node p = null;
        Node first = null;
        if (l != null && ((E) l.getItem()).compareTo((E) r.getItem()) < 0) {
            p =l;
            l = l.getNext();
            first = p;
        } else if (r != null) {
            p = r;
            r = r.getNext();
            first = p;
        }
        while (l != null && r != null) {
            if(((E) l.getItem()).compareTo((E) r.getItem()) < 0) {
                p.setNext(l);
                l = l.getNext();
            } else {
                p.setNext(r);
                r = r.getNext();
            }
            p = p.getNext();
        }

        if(l == null) p.setNext(r);
        else if(r == null) p.setNext(l);

        return first;
    }

    @Override
    public String toString() {
        String result = "";
        Node current = this.fist;
        while (current != null) {
            result += current.getItem() + " ";
            current = current.getNext();
        }
        return result;
    }
}
