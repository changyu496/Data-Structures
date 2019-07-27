import java.util.Random;

public class Main {

    public static void testQueue(Queue queue,int opCount){
        Random random = new Random();
        for (int i = 0; i < opCount; i++) {
            queue.enqueue(random.nextInt());
        }
        for (int i = 0; i < opCount; i++) {
            queue.dequeue();
        }
    }

    public static void main(String[] args) {
        int opCount = 100000;
        long start1 = System.nanoTime();
        testQueue(new ArrayQueue(),opCount);
        long end1 = System.nanoTime();
        System.out.println("ArrayQueue :"+(end1-start1)/1000000000.0 +"秒");
        long start2 = System.nanoTime();
        testQueue(new LoopQueue(),opCount);
        long end2 = System.nanoTime();
        System.out.println("LoopQueue :"+(end2-start2)/1000000000.0 +"秒");
    }
}
