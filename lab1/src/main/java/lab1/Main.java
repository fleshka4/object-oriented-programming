package lab1;

import lab1.strategies.FlyStrategy;
import lab1.strategies.HorseRideStrategy;
import lab1.strategies.RunStrategy;
import lab1.strategies.WalkStrategy;

public class Main {
    public static void main(String[] args) {
        Hero hero = new Hero("Mr S");

        hero.setStrategy(new RunStrategy());
        hero.move(9, 45);
        System.out.println(hero);

        hero.setStrategy(new FlyStrategy());
        hero.move(54.31, -90.9);
        System.out.println(hero);

        hero.setStrategy(new WalkStrategy());
        hero.move(3.2, -2.3);
        System.out.println(hero);

        hero.setStrategy(new HorseRideStrategy());
        hero.move(2394.4964, 3920.66);
        System.out.println(hero);
    }
}
