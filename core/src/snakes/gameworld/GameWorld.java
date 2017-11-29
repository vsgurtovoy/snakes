package snakes.gameworld;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Rectangle;
import snakes.objects.Apple;
import snakes.objects.Battery;
import snakes.objects.ColdApple;
import snakes.objects.Handler;
import snakes.objects.Ice;
import snakes.objects.Rock;
import snakes.objects.Snake;

public class GameWorld {
    public static int DOT_SIZE = 10;
    public static int HEIGHT = 200;
    public static int WIDTH = 130;
    public static int ALL_DOTS = 1080;
    
    private Snake snake;
    public Snake getSnake() {
        return snake;
    }
    
    private Apple apple;
    public Apple getApple() {
        return apple;
    }
    
    private ColdApple coldApple;
    public ColdApple getColdApple() {
        return coldApple;
    }
    
    private Battery battery;
    public Battery getBattery() {
        return battery;
    }
    
    private Ice ice;
    public Ice getIce() {
        return ice;
    }
    
    private Rock rock;
    public Rock getRock() {
        return rock;
    }
        
    public GameWorld() {
        snake = new Snake(this, 0, 0, GameWorld.DOT_SIZE, GameWorld.DOT_SIZE);
        apple = new Apple(this, -50, -50);
        coldApple = new ColdApple(this, -70, -70);
        battery = new Battery(this, -80, -80);
        ice = new Ice(this, -90, -90);
        rock = new Rock(this, -100, -100);
    }
    
    public void update(float delta) {
        if (snake.isDead) {
            return;
        }
        snake.update(delta);
        coldApple.update(delta);
        //battery.update(delta);
        //ice.update(delta);
        //rock.update(delta);
    }
}
