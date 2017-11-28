package snakes.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import snakes.screens.GameScreen;

public class MyGdxGame extends Game {
    
    @Override
    public void create() {
        Gdx.app.log("Snakes", "created");
        setScreen(new GameScreen());
    }
}
