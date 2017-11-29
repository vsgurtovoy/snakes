package snakes.helpers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class AssetLoader {
    public static BitmapFont font, shadow;
    public static Texture texture;
    public static TextureRegion bg;
    public static Animation snakeAnimation;
    public static TextureRegion snake1, snake2;
    public static TextureRegion apple;

    public static void load() {
        font = new BitmapFont(Gdx.files.internal("data/text.fnt"));
        font.getData().setScale(.25f, -.25f);
        shadow = new BitmapFont(Gdx.files.internal("data/shadow.fnt"));
        shadow.getData().setScale(.25f, -.25f);

        texture = new Texture(Gdx.files.internal("data/texture.png"));
        texture.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);

        bg = new TextureRegion(texture, 0, 0, 136, 43);
        bg.flip(false, true);

        snake1 = new TextureRegion(texture, 136, 0, 10, 10);
        snake1.flip(false, true);

        snake2 = new TextureRegion(texture, 153, 0, 10, 10);
        snake2.flip(false, true);

        //birdUp = new TextureRegion(texture, 170, 0, 17, 12);
        //birdUp.flip(false, true);

        TextureRegion[] snakes = { snake1, snake2};
        snakeAnimation = new Animation<TextureRegion>(0.6f, snakes);
        snakeAnimation.setPlayMode(Animation.PlayMode.LOOP_PINGPONG);

        apple = new TextureRegion(texture, 153, 0, 10, 10);
//        apple = new TextureRegion(texture, 192, 0, 24, 14);
    }

    public static void dispose() {
        // Мы должны избавляться от текстур, когда заканчивает работать с объектом в котором есть текстуры
        texture.dispose();
        font.dispose();
        shadow.dispose();
    }
}