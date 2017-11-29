package snakes.objects;

import com.badlogic.gdx.math.Circle;
import snakes.gameworld.GameWorld;

abstract public class Applyable {
    int x, y;
    GameWorld world;
    
    protected Circle circle;
    
    public Circle getCircle() {
        return circle;
    }    
    
    protected void setCircle(int x, int y) {
        circle.set(x+GameWorld.DOT_SIZE/2, y+GameWorld.DOT_SIZE/2, GameWorld.DOT_SIZE/2);
    }
    
    protected void setPos(int x, int y) {
        this.x = x;
        this.y = y;
        circle = new Circle(x+GameWorld.DOT_SIZE/2, y+GameWorld.DOT_SIZE/2, GameWorld.DOT_SIZE/2);
    } 
    
    public Applyable(GameWorld world, int x, int y) {
        setPos(x, y);
        this.world = world;
    }
    
    abstract public boolean apply(Snake snake);
}
