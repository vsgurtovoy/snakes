package snakes.objects;

import com.badlogic.gdx.Gdx;
import java.util.Random;
import snakes.gameworld.GameWorld;

public class Battery  extends Applyable {
    float time;
    float interval;
    float life;
    boolean lives;
    Random r;

    public Battery(GameWorld world, int x, int y) {
        super(world, x, y, objType.APPLE);
        time = 0;
        interval = 5f;
        life = 10f;
        lives = false;
        r = new Random();
    }
    
    @Override
    public boolean apply(Snake snake) {
        snake.makeFaster();
        kill();
        return true;        
    }
    
    public void update(float delta) {
        time += delta;
        if (lives && time >= life ) {
            kill();
        } else if (!lives && time >= interval) {
            lives = true;
            time = 0;
            
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
    
    protected void kill() {
        lives = false;
        time = 0;
        this.setPos(-20, -20);
    }
    
    public void onRestart() {
        kill();
    }
}
