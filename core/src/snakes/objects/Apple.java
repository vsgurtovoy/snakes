package snakes.objects;

import com.badlogic.gdx.Gdx;
import java.util.Random;
import snakes.gameworld.GameWorld;
import snakes.helpers.AssetLoader;

public class Apple extends Applyable {  
    Random r;

    public Apple(GameWorld world, int x, int y) {
        super(world, x, y, objType.APPLE);
        r = new Random();
    }
    
    @Override
    public boolean apply(Snake snake) {
        snake.feed(1);
        AssetLoader.coin.play();
        GameWorld.addScore(1);
        int xx;
        int yy;
        
        do {
            xx = r.nextInt(130);
            yy = r.nextInt(200);
            xx = xx/10;
            xx *= 10;
            yy = yy/10;
            yy *= 10;
            bufCircle.setPosition(xx, yy);
        } while (!Handler.hasSpace(world, bufCircle));
        
        this.setPos(xx, yy);
        return true;
    }
    
    public void onRestart() {
        int xx;
        int yy;
        
        do {
            xx = r.nextInt(130);
            yy = r.nextInt(200);
            xx = xx/10;
            xx *= 10;
            yy = yy/10;
            yy *= 10;
            bufCircle.setPosition(xx, yy);
        } while (!Handler.hasSpace(world, bufCircle));
        
        this.setPos(xx, yy);
    }
    
}
