package snakes.objects;

public class ColdApple extends Applyable {

    public ColdApple(int x, int y) {
        super(x, y);
    }
    
    @Override
    public boolean apply(Snake snake) {
        snake.cut(1);
        return true;
    }    
}
