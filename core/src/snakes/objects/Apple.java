package snakes.objects;

public class Apple extends Applyable {
    
    public Apple(int x, int y) {
        super(x, y);
    }
    
    @Override
    public boolean apply(Snake snake) {
        snake.feedSnake(1);
        return true;
    }
}
