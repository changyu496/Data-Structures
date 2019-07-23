public class Array<E> {

    private E data[];
    private int size;


    public Array(){
        this(10);
    }

    public Array(int capacity){
        this.data = (E[])new Object[capacity];
        this.size = 0;
    }

    public void addLast(E e){
        add(size,e);
    }

    public void addFirst(E e){
        add(0,e);
    }

    public void add(int index,E e){
        if(size < 0 || size > data.length){
            throw new IllegalArgumentException("Add failed.Index required > 0 and < capacity");
        }
        if(size == data.length){
            resize(2*data.length);
        }
        for (int i = size-1; i >= index; i--) {
            data[i+1] = data[i];
        }
        data[index] = e;
        size++;
    }

    public E get(int index){
        if(index<0 || index>size){
            throw new IllegalArgumentException("Get Failed.Index is illegal");
        }
        return data[index];
    }

    public void set(int index,E e){
        if(index<0 || index>size){
            throw new IllegalArgumentException("Set Failed,Index is illegal");
        }
        data[index] = e;
    }

    public int getSize() {
        return this.size;
    }

    public int getCapacity(){
        return data.length;
    }

    public boolean contains(E e){
        for (int i = 0; i < size; i++) {
            if(data[i].equals(e)){
                return true;
            }
        }
        return false;
    }

    public int find(E e){
        for (int i = 0; i < size; i++) {
            if(data[i].equals(e)){
                return i;
            }
        }
        return -1;
    }


    public void removeElement(E e){
        int index = find(e);
        if(index>0){
            remove(index);
        }
    }

    public E remove(int index){
        if(index<0||index>size){
            throw new IllegalArgumentException("Remove failed.Index is illegal");
        }
        E ret = data[index];
        for (int i = index+1; i < size ; i++) {
            data[i-1] = data[i];
        }
        size--;
        if(size == data.length/2){
            resize(data.length/2);
        }
        return ret;
    }

    public boolean isEmpty(){
        return this.size == 0;
    }

    @Override
    public String toString() {
        StringBuilder ret = new StringBuilder();
        ret = ret.append(String.format("Array: size is %d,capacity is %d\r\n",size,data.length));
        ret.append("[");
        for (int i = 0; i < size; i++) {
            ret.append(data[i]);
            if(i != size-1){
                ret.append(" ,");
            }
        }
        ret.append("]");
        return ret.toString();
    }

    private void resize(int newCapacity){
        E[] newData = (E[])(new Object[newCapacity]);
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        this.data = newData;
    }
}
