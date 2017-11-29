
package snakes.objects;

import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Intersector;
import snakes.gameworld.GameWorld;

public class Handler {
    
    public static boolean collides(Snake snake) {
        boolean collides = false;
        for (int i = 1; i < snake.getLength(); i++) {
            if (Intersector.overlaps(snake.getCircle(0), snake.getCircle(i))) {
                collides = true;
                snake.isDead = true;
            }
        }
        
        return collides;
    }
    
    public static Applyable isOnApplyable(Snake snake, GameWorld world) {
        if (Intersector.overlaps(world.getApple().getCircle(), snake.getCircle(0))) {
            return world.getApple();
        }
        if (Intersector.overlaps(world.getColdApple().getCircle(), snake.getCircle(0))) {
            return world.getColdApple();
        }
        if (Intersector.overlaps(world.getBattery().getCircle(), snake.getCircle(0))) {
            return world.getBattery();
        }
        if (Intersector.overlaps(world.getIce().getCircle(), snake.getCircle(0))) {
            return world.getIce();
        }
        if (Intersector.overlaps(world.getRock().getCircle(), snake.getCircle(0))) {
            return world.getRock();
        }
        return null;
    }
    
    public static boolean hasSpace(GameWorld world, Circle circle) {
        /*if (Intersector.overlaps(world.getApple().getCircle(), circle)) {
            return false;
        }
        if (Intersector.overlaps(world.getColdApple().getCircle(), circle)) {
            return false;
        }
        if (Intersector.overlaps(world.getBattery().getCircle(), circle)) {
            return false;
        }
        if (Intersector.overlaps(world.getIce().getCircle(), circle)) {
            return false;
        }
        if (Intersector.overlaps(world.getRock().getCircle(), circle)) {
            return false;
        }*/
        Snake snake = world.getSnake();
        for (int i = 0; i < snake.getLength(); i++) {
            if (Intersector.overlaps(snake.getCircle(i), circle)) {
                return false;
            }
        }
        return true;
    }
}
