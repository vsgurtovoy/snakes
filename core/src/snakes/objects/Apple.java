package snakes.objects;

import java.util.Random;
import snakes.gameworld.GameWorld;

public class Apple extends Applyable {   
    public Apple(GameWorld world, int x, int y) {
        super(world, x, y);
    }
    
    @Override
    public boolean apply(Snake snake) {
        snake.feed(1);
        return true;
    }
}
