public class Main {
    public static void main(String[] args) {
        Supervisor supervisor = new Supervisor(new AbstractProgram(1000));
        new Thread(supervisor).start();
    }
}
