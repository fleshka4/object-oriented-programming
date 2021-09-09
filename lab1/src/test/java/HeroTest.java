import lab1.Hero;

import lab1.strategies.FlyStrategy;
import lab1.strategies.HorseRideStrategy;
import lab1.strategies.RunStrategy;
import lab1.strategies.WalkStrategy;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class HeroTest {
    private final String TEST_NAME = "TestHero";
    private Hero hero;
    private final double EPSILON = 0.000001;

    @Test
    public void testConstructors() {
        {
            hero = new Hero(TEST_NAME);
            Assert.assertNull(hero.getStrategy());
            assertEquals(hero.getPosition().x, 0, EPSILON);
            assertEquals(hero.getPosition().y, 0, EPSILON);
            assertEquals(hero.getName(), TEST_NAME);
        }
        {
            final double x = 55.33, y = -32.39;
            hero = new Hero(TEST_NAME, x, y);
            Assert.assertNull(hero.getStrategy());
            assertEquals(hero.getName(), TEST_NAME);
            assertEquals(hero.getPosition().x, x, EPSILON);
            assertEquals(hero.getPosition().y, y, EPSILON);
        }
    }

    @Test
    public void testMove() {
        hero = new Hero(TEST_NAME);

        hero.setStrategy(new RunStrategy());
        assertTrue(hero.getStrategy() instanceof RunStrategy);
        double x = 55.33, y = -32.39;
        hero.move(x, y);
        assertEquals(hero.getPosition().x, x, EPSILON);
        assertEquals(hero.getPosition().y, y, EPSILON);

        hero.setStrategy(new HorseRideStrategy());
        assertTrue(hero.getStrategy() instanceof HorseRideStrategy);
        {
            final double dx = 34567.89, dy = 5432.1;
            hero.move(dx, dy);
            x += dx;
            y += dy;
        }
        assertEquals(hero.getPosition().x, x, EPSILON);
        assertEquals(hero.getPosition().y, y, EPSILON);

        hero.setStrategy(new WalkStrategy());
        assertTrue(hero.getStrategy() instanceof WalkStrategy);
        {
            final double dx = 1.89, dy = 2.1;
            hero.move(dx, dy);
            x += dx;
            y += dy;
        }
        assertEquals(hero.getPosition().x, x, EPSILON);
        assertEquals(hero.getPosition().y, y, EPSILON);

        hero.setStrategy(new FlyStrategy());
        assertTrue(hero.getStrategy() instanceof FlyStrategy);
        {
            final double dx = 367.89, dy = 52.1;
            hero.move(dx, dy);
            x += dx;
            y += dy;
        }
        assertEquals(hero.getPosition().x, x, EPSILON);
        assertEquals(hero.getPosition().y, y, EPSILON);
    }
}
