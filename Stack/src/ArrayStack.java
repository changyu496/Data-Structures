public class ArrayStack<E> implements Stack<E> {

    private Array<E> data;

    ArrayStack(int capacity){
        data = new Array<E>(capacity);
    }

    ArrayStack(){
        this(10);
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
    public void push(E e) {
        data.addLast(e);
    }

    @Override
    public E pop() {
        return data.removeLast();
    }

    @Override
    public E peek() {
        return data.getLast();
    }

    public int getCapacity(){
        return data.getCapacity();
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Stack: [");
        for (int i = 0; i < data.getSize(); i++) {
            res.append(data.get(i)+" ");
            if(i!=getSize()-1){
                res.append(",");
            }
        }
        res.append("] top");
        return res.toString();
    }

    public static void main(String[] args) {
        ArrayStack<Integer> stack = new ArrayStack<Integer>();
        for (int i = 0; i < 10; i++) {
            stack.push(i);
        }
        System.out.println(stack);
        stack.pop();
        System.out.println(stack);
    }
}
