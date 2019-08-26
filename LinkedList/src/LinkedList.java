public class LinkedList<E> {

    private class Node<E> {
        public E e;
        public Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node(E e) {
            this(e, null);
        }

        public Node() {
            this(null, null);
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }

    private Node<E> dummyHead;

    private int size;

    public LinkedList() {
        dummyHead = new Node<E>(null, null);
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void addFirst(E e) {
        add(0, e);
    }

    public void add(int index, E e) {
        if (0 < index || index > size) {
            throw new IllegalArgumentException("Add failed,illegal index");
        }
        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
//        Node newNode = new Node(e);
//        newNode.next = prev.next;
//        prev.next = newNode;
        prev.next = new Node(e, prev.next);
        size++;

    }

    public void addLast(E e) {
        add(size, e);
    }

}
