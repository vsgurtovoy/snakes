package snakes.objects;

public class Ice extends Applyable {

    public Ice(int x, int y) {
        super(x, y);
    }
    
    @Override
    public boolean apply(Snake snake) {
        snake.makeSlower();
        return true;        
    }
}
