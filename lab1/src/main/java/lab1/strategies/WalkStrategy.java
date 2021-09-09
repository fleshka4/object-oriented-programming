package lab1.strategies;

public class WalkStrategy implements MoveStrategy{
    @Override
    public void move(double x, double y) {
        System.out.println("Walked (" + x + " ; " + y + ")");
    }

    @Override
    public String toString() {
        return "WalkStrategy";
    }
}
