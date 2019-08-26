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
        if (index < 0 || index > size) {
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

    public E get(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Get failed,illegal index");
        }
        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return (E) cur.e;
    }

    public E getFirst() {
        return get(0);
    }

    public E getLast() {
        return get(size - 1);
    }

    public boolean contains(E e) {
        Node cur = dummyHead.next;
        for (int i = 0; i < size; i++) {
            if (cur.e.equals(e)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        Node cur;
        for (cur = dummyHead.next; cur != null; cur = cur.next) {
            stringBuilder.append(cur.e + "->");
        }
        stringBuilder.append("NULL");
        return stringBuilder.toString();
    }
}
