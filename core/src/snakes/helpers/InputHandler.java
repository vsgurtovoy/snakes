package snakes.helpers;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import snakes.objects.Snake;

public class InputHandler implements InputProcessor {
    private Snake snake;
    
    public InputHandler(Snake snake) {
        this.snake = snake; 
    }
    
    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean keyDown(int keycode) {
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
        return false;
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
