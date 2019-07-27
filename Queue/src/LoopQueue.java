public class LoopQueue<E> implements Queue<E> {

    private E[] data;
    private int front;
    private int tail;
    private int size;

    LoopQueue(int capacity){
        data = (E[])new Object[capacity+1];
        front = 0;
        tail = 0;
        size = 0;
    }

    LoopQueue(){
        this(10);
    }

    public int getCapacity(){
        return data.length-1;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return front == tail;
    }


    @Override
    public void enqueue(E e) {
        if((tail+1)%data.length == front){
            resize(getCapacity()*2);
        }
        data[tail] = e;
        tail = (tail+1) % data.length;
        size++;
    }

    @Override
    public E dequeue() {
        if(isEmpty()){
            throw new IllegalArgumentException("Can not dequeue from an empty queue");
        }
        E ret = data[front];
        data[front] = null;
        front = (front+1)%data.length;
        size--;
        if(size == getCapacity()/4 && getCapacity()/2 != 0 ){
            resize(getCapacity()/2);
        }
        return ret;
    }

    @Override
    public E getFront() {
        if(isEmpty()){
            throw new IllegalArgumentException("Queue is empty");
        }
        return data[front];
    }

    private void resize(int newCapacity){
        E[] newData = (E[])new Object[newCapacity+1];
        for (int i = 0; i < size; i++) {
            newData[i] = data[(i+front) % data.length];
        }
        this.data = newData;
        front = 0;
        tail = size;
    }

    @Override
    public String toString() {
        StringBuilder ret = new StringBuilder();
        ret = ret.append(String.format("Queue: size is %d,capacity is %d\r\n",size,getCapacity()));
        ret.append("front [");
        for (int i = front; i != tail; i= (i+1)%data.length) {
            ret.append(data[i]);
            if((i+1)%data.length != tail){
                ret.append(" ,");
            }
        }
        ret.append("] tail");
        return ret.toString();
    }

    public static void main(String[] args) {
        LoopQueue<Integer> queue = new LoopQueue<Integer>();
        for (int i = 0; i < 10; i++) {
            queue.enqueue(i);
            System.out.println(queue);
            if (i % 3 == 2) {
                queue.dequeue();
                System.out.println(queue);
            }
        }
    }
}
