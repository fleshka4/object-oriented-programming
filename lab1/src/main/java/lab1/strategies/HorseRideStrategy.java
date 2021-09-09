package lab1.strategies;

public class HorseRideStrategy implements MoveStrategy{
    @Override
    public void move(double x, double y) {
        System.out.println("Rode (" + x + " ; " + y + ")");
    }

    @Override
    public String toString() {
        return "HorseRideStrategy";
    }
}
