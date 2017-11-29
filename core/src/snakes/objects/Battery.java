package snakes.objects;

public class Battery  extends Applyable {

    public Battery(int x, int y) {
        super(x, y);
    }
    
    @Override
    public boolean apply(Snake snake) {
        snake.makeFaster();
        return true;        
    }
    
}

