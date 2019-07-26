public class ArrayQueue<E> implements Queue<E> {

    private Array<E> data;

    ArrayQueue(int capacity){
        data = new Array<E>(capacity);
    }

    ArrayQueue(){
        this(10);
    }

    @Override
    public void enqueue(E e) {
        data.addLast(e);
    }

    @Override
    public E dequeue() {
        return data.removeFirst();
    }

    @Override
    public E getFront() {
        return data.getFirst();
    }

    @Override
    public int getSize() {
        return data.getSize();
    }

    @Override
    public boolean isEmpty() {
        return data.isEmpty();
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Queue: front[");
        for (int i = 0; i < data.getSize(); i++) {
            res.append(data.get(i));
            if(i!=data.getSize()-1) {
                res.append(" ,");
            }
        }
        res.append("] tail");
        return res.toString();
    }
}
