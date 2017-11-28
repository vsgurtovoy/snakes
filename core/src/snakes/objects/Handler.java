
package snakes.objects;

import com.badlogic.gdx.math.Intersector;

public class Handler {
    private Snake snake;
    
    public Handler(Snake snake) {
        this.snake = snake;
    }
    
    public boolean collides() {
        boolean collides = false;
        for (int i = 1; i < snake.getLength(); i++) {
            if (Intersector.overlaps(snake.getCircle(0), snake.getCircle(i))) {
                collides = true;
            }
        }
        
        return collides;
    }
}
