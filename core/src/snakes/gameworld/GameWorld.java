package snakes.gameworld;

import snakes.objects.Applyable;
import snakes.objects.Applyable.objType;
import snakes.objects.ApplyableFactory;
import snakes.objects.Snake;

public class GameWorld {
    public static int DOT_SIZE = 10;
    public static int HEIGHT = 200;
    public static int WIDTH = 130;
    public static int ALL_DOTS = 260;
    
    private Snake snake;
    public Snake getSnake() {
        return snake;
    }
    
    private Applyable apple;
    public Applyable getApple() {
        return apple;
    }
    
    private Applyable coldApple;
    public Applyable getColdApple() {
        return coldApple;
    }
    
    private Applyable battery;
    public Applyable getBattery() {
        return battery;
    }
    
    private Applyable ice;
    public Applyable getIce() {
        return ice;
    }
    
    private Applyable rock;
    public Applyable getRock() {
        return rock;
    }
    
    private Applyable paint;
    public Applyable getPaint() {
        return paint;
    }
    
    private ApplyableFactory factory;
    
    private static int score;
    public static int getScore() {
        return score;
    }
    public static void addScore(int inc) {
        score += inc;
    }
        
    public enum GameState {
        READY, RUNNING, GAMEOVER
    }
    private GameState currentState;
    
    public GameWorld() {
        score = 0;
        factory = new ApplyableFactory(this);
        snake = new Snake(this, 0, 0, GameWorld.DOT_SIZE, GameWorld.DOT_SIZE);
        apple = factory.createApple();
        coldApple = factory.createColdApple();
        battery = factory.createBattery();
        ice = factory.createIce();
        rock = factory.createRock();
        paint = factory.createPaint();
        currentState = GameState.READY;
    }
    
    public void updateRunning(float delta) {
        if (snake.isDead) {
            currentState = GameState.GAMEOVER;
        } else {
            snake.update(delta);
            coldApple.update(delta);
            battery.update(delta);
            ice.update(delta);
            rock.update(delta);
            paint.update(delta);
        }
    }
    
      public void update(float delta) {
        switch (currentState) {
        case READY:
            updateReady(delta);
            break;
        case RUNNING:
            updateRunning(delta);
            break;
        default:
            break;
        }

    }

    private void updateReady(float delta) {
        // Пока что ничего не делаем
    }
    
    public boolean isReady() {
        return currentState == GameState.READY;
    }

    public void start() {
        currentState = GameState.RUNNING;
    }

    public void restart() {
        currentState = GameState.READY;
        score = 0;
        snake.onRestart();
        apple.onRestart();
        coldApple.onRestart();
        battery.onRestart();
        ice.onRestart();
        rock.onRestart();
        paint.onRestart();
    }

    public boolean isGameOver() {
        return currentState == GameState.GAMEOVER;
    }
}
