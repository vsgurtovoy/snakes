package snakes.objects;

import com.badlogic.gdx.Gdx;
import java.util.Random;
import snakes.gameworld.GameWorld;

public class Apple extends Applyable {  
    Random r;

    public Apple(GameWorld world, int x, int y) {
        super(world, x, y);
        r = new Random();
    }
    
    @Override
    public boolean apply(Snake snake) {
        snake.feed(1);
        world.addScore(1);
        do {
            int xx = r.nextInt(130);
            int yy = r.nextInt(200);
            xx = xx/10;
            xx *= 10;
            yy = yy/10;
            yy *= 10;
            this.setPos(xx, yy);
            Gdx.app.log(xx+"", yy+"");
        } while (!Handler.hasSpace(world, circle));
        return true;
    }
    
}
