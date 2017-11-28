package snakes.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import snakes.gameworld.GameRenderer;
import snakes.gameworld.GameWorld;

public class GameScreen implements Screen {
    private GameWorld world;
    private GameRenderer renderer;
    
    
    public GameScreen() {
       
        float screenWidth = Gdx.graphics.getWidth();
        float screenHeight = Gdx.graphics.getHeight();
        float gameWidth = 136;
        float gameHeight = screenHeight / (screenWidth / gameWidth);

        int midPointY = (int) (gameHeight / 2);
        int midPointX = (int) (gameWidth / 2);
        
        world = new GameWorld(midPointX, midPointY); // initialize world
        renderer = new GameRenderer(world); // initialize renderer
    }

    @Override
    public void render(float delta) {
        world.update(delta); // GameWorld updates 
        renderer.render(); // GameRenderer renders
    }

    @Override
    public void resize(int width, int height) {
        Gdx.app.log("GameScreen", "resizing");
    }

    @Override
    public void show() {
        Gdx.app.log("GameScreen", "show called");
    }

    @Override
    public void hide() {
        Gdx.app.log("GameScreen", "hide called");     
    }

    @Override
    public void pause() {
        Gdx.app.log("GameScreen", "pause called");        
    }

    @Override
    public void resume() {
        Gdx.app.log("GameScreen", "resume called");       
    }

    @Override
    public void dispose() {
        // Leave blank
    }

}