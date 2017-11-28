package snakes.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import snakes.gameworld.GameRenderer;
import snakes.gameworld.GameWorld;
import snakes.helpers.InputHandler;

public class GameScreen implements Screen {
    private GameWorld world;
    private GameRenderer renderer;
    
    public GameScreen() {
        /*
        float screenWidth = Gdx.graphics.getWidth();
        float screenHeight = Gdx.graphics.getHeight();
        float gameWidth = 136;
        float gameHeight = screenHeight / (screenWidth / gameWidth);

        int midPointY = (int) (gameHeight / 2);
        int midPointX = (int) (gameWidth / 2);
        */
        
        world = new GameWorld(); // initialize world
        renderer = new GameRenderer(world, midPointX, midPointY); // initialize renderer
        Gdx.input.setInputProcessor(new InputHandler(world.getSnake()));
    }

    @Override
    public void render(float delta) {
        world.update(delta); // GameWorld updates 
        renderer.render(delta); // GameRenderer renders
    }

    @Override
    public void resize(int width, int height) {
    }

    @Override
    public void show() {
    }

    @Override
    public void hide() {
    }

    @Override
    public void pause() {
    }

    @Override
    public void resume() {
    }

    @Override
    public void dispose() {
        // Leave blank
    }
}