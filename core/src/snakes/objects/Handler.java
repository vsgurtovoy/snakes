
package snakes.objects;

import com.badlogic.gdx.math.Intersector;

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
    
    
}
