package snakes.objects;

public class Rock extends Applyable {

    public Rock(int x, int y) {
        super(x, y);
    }
    
    @Override
    public boolean apply(Snake snake) {
        snake.killSnake();
        return true;
    }  
    
}
