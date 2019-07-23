public class Main {

    public static void main(String[] args) {
        Array<Integer> arr = new Array();
        for (int i = 0; i < 10; i++) {
            arr.add(i,i);
        }
        arr.add(0,99);
        arr.addFirst(-1);
        arr.addLast(100);
        arr.remove(0);
        arr.removeElement(0);
        System.out.println(arr);
        arr.remove(0);
        arr.remove(0);
        System.out.println(arr);
    }
}
