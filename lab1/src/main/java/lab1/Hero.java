package lab1;

import lab1.strategies.MoveStrategy;

public class Hero {
    private final String name;
    private MoveStrategy strategy;

    public static class Point {
        public double x, y;

        public Point(double x, double y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }

    private final Point position = new Point(0, 0);

    public Hero(String name) {
        this.name = name;
    }

    public Hero(String name, double x, double y) {
        this.name = name;
        this.position.x = x;
        this.position.y = y;
    }

    public String getName() {
        return name;
    }

    public MoveStrategy getStrategy() {
        return strategy;
    }

    public void setStrategy(MoveStrategy strategy) {
        this.strategy = strategy;
    }

    public Point getPosition() {
        return position;
    }

    public void move(double x, double y) {
        position.x += x;
        position.y += y;
        strategy.move(x, y);
    }

    @Override
    public String toString() {
        return "Hero{" +
                "name='" + name + '\'' +
                ", strategy=" + strategy +
                ", position=" + position +
                '}';
    }
}
