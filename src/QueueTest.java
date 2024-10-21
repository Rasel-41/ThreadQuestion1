public class QueueTest {
    public static void main(String[] args) {
        Queue<Integer>queue = new Queue<>();
        Thread Producer = new Thread(()->{
            for(int i = 1;i<100;i++){
                queue.enqueue(i);
                System.out.println("Enqueued: "+i);
                try{Thread.sleep(2000);
            }
                catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
    }
    );
        Thread Consumer = new Thread(()->{
            for(int i = 1;i<10;i++){
                try{
                    int item = queue.dequeue();
                    System.out.println("Dequeued :"+item);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        );
        Producer.start();
        Consumer.start();


        }
    }
