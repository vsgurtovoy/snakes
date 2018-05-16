package snakes.objects;

import com.badlogic.gdx.math.Circle;
import java.util.Random;
import snakes.gameworld.GameWorld;
import snakes.helpers.AssetLoader;


public class Applyable {
    int x, y;
    
    GameWorld world;
    
    protected Circle circle;
    protected Circle bufCircle;
    
    float time;
    float interval;
    float life;
    boolean lives;
    Random r;
    
    public static enum objType {
        APPLE, COLDAPPLE, BATTERY, ICE, ROCK, PAINT, FLICKERAPPLE
    }
    
    private objType type;
    private boolean isEthereal=false;
    
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    
    public Circle getCircle() {
        return circle;
    }    
    
    protected void setCircle(int x, int y) {
        circle.set(x+GameWorld.DOT_SIZE/2, y+GameWorld.DOT_SIZE/2, GameWorld.DOT_SIZE/2);
    }
    
    public Circle getBufCircle() {
        return bufCircle;
    }    
    
    protected void setBufCircle(int x, int y) {
        bufCircle.set(x+GameWorld.DOT_SIZE/2, y+GameWorld.DOT_SIZE/2, GameWorld.DOT_SIZE/2);
    }
    
    protected void setPos(int x, int y) {
        this.x = x;
        this.y = y;
        setCircle(x, y);
    } 

    public Applyable(GameWorld world, int x, int y, Applyable.objType type) {
        this.x = x;
        this.y= y;
        circle = new Circle(x+GameWorld.DOT_SIZE/2, y+GameWorld.DOT_SIZE/2, GameWorld.DOT_SIZE/2);
        bufCircle = new Circle(x+GameWorld.DOT_SIZE/2, y+GameWorld.DOT_SIZE/2, GameWorld.DOT_SIZE/2);
        this.world = world;
        this.type = type;
        r = new Random();
        time = 0;
        lives = false;

        switch (type) {
            case APPLE:
                interval = 0f;
                life = 0f;
                break;
            case FLICKERAPPLE:
                interval = 0f;
                life = 0f;
                break;
            case COLDAPPLE:
                interval = 4f;
                life = 7f;
                break;
            case BATTERY:
                interval = 4f;
                life = 6f;
                break;
            case ICE:
                interval = 4f;
                life = 4f;
                break;
            case PAINT:
                interval = 4f;
                life = 5f;
                break;
            case ROCK:
                interval = 4f;
                life = 6f;
                break;
            default:
                break;
        }
    }

    public boolean isEthereal() {
        return isEthereal;
    }

    public boolean apply(Snake snake) {
        int xx;
        int yy;
        if (null != type) switch (type) {
            case APPLE:
                snake.feed(1);
                AssetLoader.coin.play();
                GameWorld.addScore(1);
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
                break;
            case FLICKERAPPLE:
                if(!isEthereal()) {
                    snake.feed(1);
                    AssetLoader.coin.play();
                    GameWorld.addScore(1);
                    do {
                        xx = r.nextInt(130);
                        yy = r.nextInt(200);
                        xx = xx / 10;
                        xx *= 10;
                        yy = yy / 10;
                        yy *= 10;
                        bufCircle.setPosition(xx, yy);
                    } while (!Handler.hasSpace(world, bufCircle));
                    this.setPos(xx, yy);
                }
                break;
            case COLDAPPLE:
                snake.cut(1);
                kill();
                break;
            case BATTERY:
                snake.makeFaster();
                kill();
                break;
            case ICE:
                snake.makeSlower();
                kill();
                break;
            case PAINT:
                snake.changeColor();
                kill();
                break;
            case ROCK:
                snake.kill();
                break;
            default:
                break;
        }
        return true;
    }
    
    public void update(float delta) {
        if (type == objType.APPLE) {
            return;
        }
        if(type == objType.FLICKERAPPLE){
            this.isEthereal = System.currentTimeMillis()/1000 % 10 < 5;
            return;
        }
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
        if (type == objType.APPLE || type == objType.FLICKERAPPLE) {
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
            return;
        }
        kill();
    }
}
