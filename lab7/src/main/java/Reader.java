import java.util.concurrent.BlockingQueue;

public class Reader implements Runnable {
    private final BlockingQueue blockingQueue;

    public <T> Reader(BlockingQueue<T> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {
        try {
            System.out.println(Thread.currentThread().getName() + " read " + blockingQueue.take());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
