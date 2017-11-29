package snakes.objects;

public class Rock extends Applyable {

    public Rock(int x, int y) {
        super(x, y);
    }
    
    @Override
    public boolean apply(Snake snake) {
return true;        
//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
