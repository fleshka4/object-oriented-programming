public class Supervisor implements Runnable {
    private final AbstractProgram abstractProgram;

    public Supervisor(AbstractProgram abstractProgram) {
        this.abstractProgram = abstractProgram;
    }

    @Override
    public void run() {
        new Thread(abstractProgram).start();
        System.out.println("Program started");

        while (abstractProgram.getState() != AbstractProgram.ProgramState.FATAL_ERROR) {
            synchronized (abstractProgram.getMutex()) {
                try {
                    abstractProgram.getMutex().wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (abstractProgram.getState() == AbstractProgram.ProgramState.UNKNOWN ||
                        abstractProgram.getState() == AbstractProgram.ProgramState.STOPPING) {
                    abstractProgram.setState(AbstractProgram.ProgramState.RUNNING);
                    System.out.println("Program restarted");
                }
                abstractProgram.getMutex().notify();
            }
        }

        Thread.currentThread().interrupt();
        System.out.println("Program stopped");
    }
}
