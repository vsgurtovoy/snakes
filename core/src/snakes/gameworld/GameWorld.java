package snakes.gameworld;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Rectangle;
import snakes.objects.Snake;

public class GameWorld {
    public static int DOT_SIZE = 10;
    public static int HEIGHT = 400;
    public static int WIDTH = 270;
    public static int ALL_DOTS = 1080;
    
    private int midPointY;
    private int midPointX;
    private Snake snake;
    public Snake getSnake() {
        return snake;
    }
    
    public GameWorld(int midPointX, int midpointY) {
        snake = new Snake(33, midPointY - 5, 17, 12);
    }
    
    public void update(float delta) {
        Gdx.app.log("GameWorld", "update");
        snake.update(delta);
    }
}
