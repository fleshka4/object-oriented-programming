import java.util.Arrays;

public class AbstractProgram implements Runnable {
    private final long interval;
    private final Object mutex;
    private ProgramState state;

    enum ProgramState {
        UNKNOWN,
        STOPPING,
        RUNNING,
        FATAL_ERROR
    }

    private final Runnable runnable = new Runnable() {
        @Override
        public void run() {
            while (getState() != ProgramState.FATAL_ERROR) {
                synchronized (mutex) {
                    try {
                        mutex.wait(interval);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if (!Thread.currentThread().isInterrupted()) {
                        state = getRandomProgramState();
                        System.out.println("New state: " + state);
                        mutex.notify();
                    }
                }
            }
        }
    };

    public AbstractProgram(long interval) {
        this.interval = interval;
        mutex = new Object();
        this.state = ProgramState.RUNNING;
    }

    private synchronized static ProgramState getRandomProgramState() {
        int toSkip = (int) Math.round(Math.random() * ProgramState.values().length);
        return Arrays.stream(ProgramState.values())
                .skip((toSkip) == 4 ? 3 : toSkip)
                .findAny()
                .orElseThrow();
    }

    @Override
    public void run() {
        Thread thread = new Thread(runnable);
        thread.setDaemon(true);
        thread.start();
    }

    public synchronized Object getMutex() {
        return mutex;
    }

    public synchronized ProgramState getState() {
        return state;
    }

    public synchronized void setState(ProgramState state) {
        this.state = state;
    }
}
