package snakes.helpers;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import snakes.gameworld.GameWorld;
import snakes.objects.Snake;

public class InputHandler implements InputProcessor {
    protected Snake snake;
    protected GameWorld myWorld;
    
    public InputHandler(GameWorld world) {
        this.myWorld = world;
        this.snake = myWorld.getSnake();
    }
    
    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean keyDown(int keycode) {
        if (myWorld.isReady()) {
            // начнем игру
            myWorld.start();
        } else if (myWorld.isGameOver()) {
            // Обнулим все перменные, перейдем в GameState.READ
            myWorld.restart();
        } else {        
            switch (keycode) {
                case Input.Keys.UP:
                    snake.moveUp();
                    break;
                case Input.Keys.DOWN:
                    snake.moveDown();
                    break;
                case Input.Keys.LEFT:
                    snake.moveLeft();
                    break;
                case Input.Keys.RIGHT:
                    snake.moveRight();
                    break;
                default: break;
            } 
        }
        return true;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }

}
