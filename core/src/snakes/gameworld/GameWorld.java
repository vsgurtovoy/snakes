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
    public static int HEIGHT = 400;
    public static int WIDTH = 270;
    public static int ALL_DOTS = 1080;
    
    private Snake snake;
    public Snake getSnake() {
        return snake;
    }
    
    private Apple apple;
    private ColdApple coldApple;
    private Battery battery;
    private Ice ice;
    private Rock rock;
    
    Handler handler;
    
    public GameWorld() {
        snake = new Snake(0, 0, GameWorld.DOT_SIZE, GameWorld.DOT_SIZE);
        handler = new Handler(snake);
        
    }
    
    public void update(float delta) {
        if (handler.collides()) {
            return;
        }
        snake.update(delta);
    }
}
