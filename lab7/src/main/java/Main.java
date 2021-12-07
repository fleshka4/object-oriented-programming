import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.err.println("There must be one integer argument");
            System.exit(1);
        }
        final int n = Integer.parseInt(args[0]);

        final ExecutorService readers = Executors.newFixedThreadPool(n, new ThreadFactory() {
            private int temp = 1;
            @Override
            public Thread newThread(Runnable r) {
                return new Thread(r, "reader#" + temp++);
            }
        });

        final ExecutorService writers = Executors.newFixedThreadPool(n, new ThreadFactory() {
            private int temp = 1;
            @Override
            public Thread newThread(Runnable r) {
                return new Thread(r, "writer#" + temp++);
            }
        });

        final BlockingQueue<String> blockingDeque = new ArrayBlockingQueue<>(n);
        Writer writer = new Writer(blockingDeque);
        Reader reader = new Reader(blockingDeque);

        for (int i = 0; i < n; i++) {
            writers.submit(writer);
            readers.submit(reader);
        }

        writers.shutdown();
        readers.shutdown();
    }
}
