package snakes.helpers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
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
    public static Animation redSnakeAnimation, blueSnakeAnimation;
    public static Animation batteryAnimation, iceAnimation, rockAnimation, paintAnimation;
    public static TextureRegion snake1, snake2, snakeBody;
    public static TextureRegion redSnake1, redSnake2, redSnakeBody;
    public static TextureRegion blueSnake1, blueSnake2, blueSnakeBody;
    public static TextureRegion apple1, apple2;
    public static TextureRegion coldApple1, coldApple2;
    public static TextureRegion battery1, battery2;
    public static TextureRegion ice1, ice2;
    public static TextureRegion rock1, rock2;
    public static TextureRegion paint1, paint2, paint3;
    public static Sound dead, turn, coin;
    public static Preferences prefs;

    public static void load() {
        font = new BitmapFont(Gdx.files.internal("data/text.fnt"));
        font.getData().setScale(.25f, -.25f);
        
        shadow = new BitmapFont(Gdx.files.internal("data/shadow.fnt"));
        shadow.getData().setScale(.25f, -.25f);

        texture = new Texture(Gdx.files.internal("data/texture.png"));
        texture.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);

        bg = new TextureRegion(texture, 0, 0, 136, 43);
        bg.flip(false, true);
// зеленая змея        
        snakeBody = new TextureRegion(texture, 136, 11, 10, 10);
        snakeBody.flip(false, true);

        snake1 = new TextureRegion(texture, 136, 0, 10, 10);
        snake1.flip(false, true);

        snake2 = new TextureRegion(texture, 147, 0, 10, 10);
        snake2.flip(false, true);

        TextureRegion[] snakes = { snake1, snake2 };
        snakeAnimation = new Animation<TextureRegion>(0.6f, snakes);
        snakeAnimation.setPlayMode(Animation.PlayMode.LOOP_PINGPONG);
        
// красная змея
        redSnakeBody = new TextureRegion(texture, 158, 11, 10, 10);
        redSnakeBody.flip(false, true);

        redSnake1 = new TextureRegion(texture, 158, 0, 10, 10);
        redSnake1.flip(false, true);

        redSnake2 = new TextureRegion(texture, 169, 0, 10, 10);
        redSnake2.flip(false, true);

        TextureRegion[] redSnakes = { redSnake1, redSnake2 };
        redSnakeAnimation = new Animation<TextureRegion>(0.6f, redSnakes);
        redSnakeAnimation.setPlayMode(Animation.PlayMode.LOOP_PINGPONG);
        
// красная змея
        blueSnakeBody = new TextureRegion(texture, 180, 11, 10, 10);
        blueSnakeBody.flip(false, true);

        blueSnake1 = new TextureRegion(texture, 180, 0, 10, 10);
        blueSnake1.flip(false, true);

        blueSnake2 = new TextureRegion(texture, 191, 0, 10, 10);
        blueSnake2.flip(false, true);

        TextureRegion[] blueSnakes = { blueSnake1, blueSnake2 };
        blueSnakeAnimation = new Animation<TextureRegion>(0.6f, blueSnakes);
        blueSnakeAnimation.setPlayMode(Animation.PlayMode.LOOP_PINGPONG);
//        
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
        
        paint1 = new TextureRegion(texture, 136, 77, 10, 10);
        paint2 = new TextureRegion(texture, 147, 77, 10, 10);
        paint3 = new TextureRegion(texture, 158, 77, 10, 10);
        
        TextureRegion[] paints = { paint1, paint2, paint3 };
        paintAnimation = new Animation<TextureRegion>(0.6f, paints);
        paintAnimation.setPlayMode(Animation.PlayMode.LOOP_PINGPONG);
        
        dead = Gdx.audio.newSound(Gdx.files.internal("data/dead.wav"));
        turn = Gdx.audio.newSound(Gdx.files.internal("data/turn.wav"));
        coin = Gdx.audio.newSound(Gdx.files.internal("data/coin.wav"));

        prefs = Gdx.app.getPreferences("Snakes");
        if (!prefs.contains("highScore")) {
            prefs.putInteger("highScore", 0);
        }
    }
    
    // Получает на вход значение для hishScore и сохраняет в файл
    public static void setHighScore(int val) {
        prefs.putInteger("highScore", val);
        prefs.flush();
    }

    // Возвращает текущее значение hishScore
    public static int getHighScore() {
        return prefs.getInteger("highScore");
    }

    // Избавляется от текстур
    public static void dispose() {
        texture.dispose();
        font.dispose();
        shadow.dispose();
    }
}