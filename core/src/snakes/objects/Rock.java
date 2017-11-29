package snakes.objects;

import snakes.gameworld.GameWorld;

public class Rock extends Applyable {

    public Rock(GameWorld world, int x, int y) {
        super(world, x, y);
    }
    
    @Override
    public boolean apply(Snake snake) {
        snake.kill();
        return true;
    }  
    
}
