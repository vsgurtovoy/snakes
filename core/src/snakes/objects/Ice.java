package snakes.objects;

import com.badlogic.gdx.Gdx;
import java.util.Random;
import snakes.gameworld.GameWorld;

public class Ice extends Applyable {
    float time;
    float interval;
    float life;
    boolean lives;
    Random r;
    
    public Ice(GameWorld world, int x, int y) {
        super(world, x, y);
        time = 0;
        interval = 4f;
        life = 4f;
        lives = false;
        r = new Random();
    }
    
    @Override
    public boolean apply(Snake snake) {
        snake.makeSlower();
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
