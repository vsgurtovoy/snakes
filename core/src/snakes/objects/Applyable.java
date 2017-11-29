package snakes.objects;

import com.badlogic.gdx.math.Circle;
import snakes.gameworld.GameWorld;

abstract public class Applyable {
    int x, y;
    protected Circle circle;
    public Circle getCircle() {
        return circle;
    }    
    public void setCircle(int x, int y) {
        circle.set(x+GameWorld.DOT_SIZE/2, y+GameWorld.DOT_SIZE/2, GameWorld.DOT_SIZE/2);
    }
    public Applyable(int x, int y) {
        this.x = x;
        this.y = y;
        circle = new Circle(x+GameWorld.DOT_SIZE/2, y+GameWorld.DOT_SIZE/2, GameWorld.DOT_SIZE/2);
    }
    abstract public boolean apply(Snake snake);
}
