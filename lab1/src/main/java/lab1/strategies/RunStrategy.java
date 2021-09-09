package lab1.strategies;

public class RunStrategy implements MoveStrategy{
    @Override
    public void move(double x, double y) {
        System.out.println("Ran (" + x + " ; " + y + ")");
    }

    @Override
    public String toString() {
        return "RunStrategy";
    }
}
