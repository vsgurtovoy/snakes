package snakes.helpers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class AssetLoader {
    public static BitmapFont font, shadow;
    public static Texture texture;
    public static TextureRegion bg;
    public static Animation snakeAnimation, appleAnimation, coldAppleAnimation;
    public static Animation batteryAnimation, iceAnimation, rockAnimation;
    public static TextureRegion snake1, snake2, snakeBody;
    public static TextureRegion apple1, apple2;
    public static TextureRegion coldApple1, coldApple2;
    public static TextureRegion battery1, battery2;
    public static TextureRegion ice1, ice2;
    public static TextureRegion rock1, rock2;
    public static Sound dead, turn, coin;

    public static void load() {
        font = new BitmapFont(Gdx.files.internal("data/text.fnt"));
        font.getData().setScale(.25f, -.25f);
        
        shadow = new BitmapFont(Gdx.files.internal("data/shadow.fnt"));
        shadow.getData().setScale(.25f, -.25f);

        texture = new Texture(Gdx.files.internal("data/texture.png"));
        texture.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);

        bg = new TextureRegion(texture, 0, 0, 136, 43);
        bg.flip(false, true);
        
        snakeBody = new TextureRegion(texture, 136, 11, 10, 10);
        snakeBody.flip(false, true);

        snake1 = new TextureRegion(texture, 136, 0, 10, 10);
        snake1.flip(false, true);

        snake2 = new TextureRegion(texture, 153, 0, 10, 10);
        snake2.flip(false, true);

        TextureRegion[] snakes = { snake1, snake2 };
        snakeAnimation = new Animation<TextureRegion>(0.6f, snakes);
        snakeAnimation.setPlayMode(Animation.PlayMode.LOOP_PINGPONG);
        
        apple1 = new TextureRegion(texture, 136, 22, 10, 10);
        apple2 = new TextureRegion(texture, 147, 22, 10, 10);
        
        TextureRegion[] apples = { apple1, apple2 };
        appleAnimation = new Animation<TextureRegion>(0.6f, apples);
        appleAnimation.setPlayMode(Animation.PlayMode.LOOP_PINGPONG);
        
        coldApple1 = new TextureRegion(texture, 136, 33, 10, 10);
        coldApple2 = new TextureRegion(texture, 147, 33, 10, 10);
        
        TextureRegion[] coldApples = { coldApple1, coldApple2 };
        coldAppleAnimation = new Animation<TextureRegion>(0.6f, coldApples);
        coldAppleAnimation.setPlayMode(Animation.PlayMode.LOOP_PINGPONG);
        
        battery1 = new TextureRegion(texture, 136, 44, 10, 10);
        battery2 = new TextureRegion(texture, 147, 44, 10, 10);
        
        TextureRegion[] batteries = { battery1, battery2 };
        batteryAnimation = new Animation<TextureRegion>(0.6f, batteries);
        batteryAnimation.setPlayMode(Animation.PlayMode.LOOP_PINGPONG);
        
        ice1 = new TextureRegion(texture, 136, 55, 10, 10);
        ice2 = new TextureRegion(texture, 147, 55, 10, 10);
        
        TextureRegion[] ices = { ice1, ice2 };
        iceAnimation = new Animation<TextureRegion>(0.6f, ices);
        iceAnimation.setPlayMode(Animation.PlayMode.LOOP_PINGPONG);
        
        rock1 = new TextureRegion(texture, 136, 66, 10, 10);
        rock2 = new TextureRegion(texture, 147, 66, 10, 10);
        
        TextureRegion[] rocks = { rock1, rock2 };
        rockAnimation = new Animation<TextureRegion>(0.6f, rocks);
        rockAnimation.setPlayMode(Animation.PlayMode.LOOP_PINGPONG);
        
        dead = Gdx.audio.newSound(Gdx.files.internal("data/dead.wav"));
        turn = Gdx.audio.newSound(Gdx.files.internal("data/turn.wav"));
        coin = Gdx.audio.newSound(Gdx.files.internal("data/coin.wav"));

    }

    public static void dispose() {
        // Мы должны избавляться от текстур, когда заканчивает работать с объектом в котором есть текстуры
        texture.dispose();
        font.dispose();
        shadow.dispose();
    }
}