package lab1.strategies;

public class FlyStrategy implements MoveStrategy {
    @Override
    public void move(double x, double y) {
        System.out.println("Flew (" + x + " ; " + y + ")");
    }

    @Override
    public String toString() {
        return "FlyStrategy";
    }
}
