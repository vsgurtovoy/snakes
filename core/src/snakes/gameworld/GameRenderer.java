package snakes.gameworld;

import com.badlogic.gdx.Gdx;

public class GameRenderer {
    private GameWorld myWorld;
    
    public GameRenderer(GameWorld world) {
        myWorld = world;
    }
    
    public void render() {
        Gdx.app.log("GameRenderer", "render");
    }
}
