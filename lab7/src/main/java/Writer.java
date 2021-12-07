import java.util.concurrent.BlockingQueue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Writer implements Runnable {
    private final BlockingQueue blockingQueue;
    private final Lock lock = new ReentrantLock();

    public <T> Writer(BlockingQueue<T> queue) {
        this.blockingQueue = queue;
    }

    @Override
    public void run() {
        lock.lock();
        try {
            Thread.sleep(3000);
            blockingQueue.put(Thread.currentThread());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        lock.unlock();
    }
}
