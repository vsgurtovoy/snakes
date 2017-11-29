package snakes.objects;

import snakes.gameworld.GameWorld;

public class ColdApple extends Applyable {

    public ColdApple(GameWorld world, int x, int y) {
        super(world, x, y);
    }
    
    @Override
    public boolean apply(Snake snake) {
        snake.cut(1);
        return true;
    }    
}
