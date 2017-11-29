package snakes.objects;

import snakes.gameworld.GameWorld;

public class Ice extends Applyable {

    public Ice(GameWorld world, int x, int y) {
        super(world, x, y);
    }
    
    @Override
    public boolean apply(Snake snake) {
        snake.makeSlower();
        return true;        
    }
}
