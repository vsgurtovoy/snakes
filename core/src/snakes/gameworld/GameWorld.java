package snakes.gameworld;

import snakes.objects.Apple;
import snakes.objects.Battery;
import snakes.objects.ColdApple;
import snakes.objects.Ice;
import snakes.objects.Rock;
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
        snake = new Snake(this, 0, 0, GameWorld.DOT_SIZE, GameWorld.DOT_SIZE);
        apple = new Apple(this, 50, 50);
        coldApple = new ColdApple(this, -70, -70);
        battery = new Battery(this, -80, -80);
        ice = new Ice(this, -90, -90);
        rock = new Rock(this, -100, -100);
        currentState = GameState.READY;
    }
    
    public void updateRunning(float delta) {
        if (snake.isDead) {
            currentState = GameState.GAMEOVER;
            return;
        } else {
            snake.update(delta);
            coldApple.update(delta);
            battery.update(delta);
            ice.update(delta);
            rock.update(delta);
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
    }

    public boolean isGameOver() {
        return currentState == GameState.GAMEOVER;
    }
}
