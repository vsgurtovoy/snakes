package snakes.gameworld;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import snakes.helpers.AssetLoader;
import snakes.objects.Apple;
import snakes.objects.Battery;
import snakes.objects.ColdApple;
import snakes.objects.Ice;
import snakes.objects.Rock;
import snakes.objects.Snake;

public class GameRenderer {
    private OrthographicCamera cam;
    private ShapeRenderer shapeRenderer;
    private SpriteBatch batcher;
    
    private GameWorld myWorld;
    private Snake snake;
    private Apple apple;
    private ColdApple coldApple;
    private Battery battery;
    private Ice ice;
    private Rock rock;
    
    private int snakeLength;
    private int midPointY;
    private int midPointX;
    private float runTime;
    
    private TextureRegion bg;
    private Animation snakeAnimation, appleAnimation, coldAppleAnimation;
    private Animation batteryAnimation, iceAnimation, rockAnimation;
    private TextureRegion snakeBody;
    
    private void initGameObjects() {
        snake = myWorld.getSnake();
        apple = myWorld.getApple();
        coldApple = myWorld.getColdApple();
        battery = myWorld.getBattery();
        ice = myWorld.getIce();
        rock = myWorld.getRock();
    }

    private void initAssets() {
        bg = AssetLoader.bg;
        snakeAnimation = AssetLoader.snakeAnimation;
        snakeBody = AssetLoader.snakeBody;
        appleAnimation = AssetLoader.appleAnimation;
        coldAppleAnimation = AssetLoader.coldAppleAnimation;
        batteryAnimation = AssetLoader.batteryAnimation;
        iceAnimation = AssetLoader.iceAnimation;
        rockAnimation = AssetLoader.rockAnimation;
    }
    
    public GameRenderer(GameWorld world, int midPointX, int midPointY) {
        myWorld = world;
        this.midPointX = midPointX;
        this.midPointY = midPointY;
        cam = new OrthographicCamera();
        cam.setToOrtho(true, 136, 204);
        batcher = new SpriteBatch();
        batcher.setProjectionMatrix(cam.combined);
        shapeRenderer = new ShapeRenderer();
        shapeRenderer.setProjectionMatrix(cam.combined);
        initGameObjects();
        initAssets();
    }
    
    public void render(float delta) {        
        runTime += delta;
        
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
/*
        shapeRenderer.begin(ShapeType.Filled);
        shapeRenderer.setColor(55 / 255.0f, 80 / 255.0f, 100 / 255.0f, 1);
        shapeRenderer.rect(0, 0, 136, 204);
        shapeRenderer.end();*/

        // Отрисовать фон
        batcher.begin();
        batcher.disableBlending();
        batcher.draw(bg, 0, 0, 136, 207);
        batcher.enableBlending();

        // Отрисовать голову змеи
        batcher.draw((TextureRegion) snakeAnimation.getKeyFrame(runTime), 
                snake.getX(0), snake.getY(0), 
                snake.getWidth()/2f, snake.getHeight()/2f, 
                snake.getWidth(), snake.getHeight(),
                1, 1, snake.getRotation());
        // Отрисовать тело змеи
        snakeLength = snake.getLength();
        for (int i = 1; i < snakeLength; i++) {
            batcher.draw(snakeBody, snake.getX(i), snake.getY(i));
        }
        // отрисовать яблоко
        batcher.draw((TextureRegion) appleAnimation.getKeyFrame(runTime), 
                apple.getX(), apple.getY(), 
                snake.getWidth()/2f, snake.getHeight()/2f, 
                snake.getWidth(), snake.getHeight(),
                1, 1, 180);
        // отрисовать холодное яблоко
        batcher.draw((TextureRegion) coldAppleAnimation.getKeyFrame(runTime), 
                coldApple.getX(), coldApple.getY(), 
                snake.getWidth()/2f, snake.getHeight()/2f, 
                snake.getWidth(), snake.getHeight(),
                1, 1, 180);
        // отрисовать батарейку
        batcher.draw((TextureRegion) batteryAnimation.getKeyFrame(runTime), 
                battery.getX(), battery.getY(), 
                snake.getWidth()/2f, snake.getHeight()/2f, 
                snake.getWidth(), snake.getHeight(),
                1, 1, 180);
        // отрисовать лед
        batcher.draw((TextureRegion) iceAnimation.getKeyFrame(runTime), 
                ice.getX(), ice.getY(), 
                snake.getWidth()/2f, snake.getHeight()/2f, 
                snake.getWidth(), snake.getHeight(),
                1, 1, 180);
        // отрисовать камень
        batcher.draw((TextureRegion) rockAnimation.getKeyFrame(runTime), 
                rock.getX(), rock.getY(), 
                snake.getWidth()/2f, snake.getHeight()/2f, 
                snake.getWidth(), snake.getHeight(),
                1, 1, 180);
        
        if (myWorld.isReady()) {
            // Отрисуем сначала тень
            AssetLoader.shadow.draw(batcher, "Touch me", (136 / 2)
                    - (42), 76);
            // Отрисуем сам текст
            AssetLoader.font.draw(batcher, "Touch me", (136 / 2)
                    - (42 - 1), 75);
        } else {

            if (myWorld.isGameOver()) {
                AssetLoader.shadow.draw(batcher, "Game Over", 25, 56);
                AssetLoader.font.draw(batcher, "Game Over", 24, 55);
                
                AssetLoader.shadow.draw(batcher, "Try again?", 23, 76);
                AssetLoader.font.draw(batcher, "Try again?", 24, 75);
                
                AssetLoader.shadow.draw(batcher, "High Score:", 23, 106);
                AssetLoader.font.draw(batcher, "High Score:", 22, 105);

                String highScore = AssetLoader.getHighScore() + "";

                AssetLoader.shadow.draw(batcher, highScore, (136 / 2)
                        - (3 * highScore.length()), 128);
                AssetLoader.font.draw(batcher, highScore, (136 / 2)
                        - (3 * highScore.length() - 1), 127);
                // установить новый рекорд
                if (GameWorld.getScore() > AssetLoader.getHighScore()) {
                    AssetLoader.setHighScore(GameWorld.getScore());
                }
            }
        
            // Конвертирование integer в String
            String score = GameWorld.getScore() + "";

            // Отрисуем сначала тень
            AssetLoader.shadow.draw(batcher, "" + GameWorld.getScore(), (136 / 2) - (3 * score.length() - 1), 12);
            // Отрисуем сам текст
            AssetLoader.font.draw(batcher, "" + GameWorld.getScore(), (136 / 2) - (3 * score.length() - 1), 11);

            // печать технических кругов
/*            shapeRenderer.begin(ShapeType.Filled);
            shapeRenderer.setColor(Color.RED);

            for (int i = 0; i < snakeLength; i++) {
                shapeRenderer.circle(snake.getCircle(i).x, snake.getCircle(i).y, snake.getCircle(i).radius);
            }           
            shapeRenderer.circle(apple.getCircle().x, apple.getCircle().y, apple.getCircle().radius);
            shapeRenderer.circle(coldApple.getCircle().x, coldApple.getCircle().y, coldApple.getCircle().radius);
            shapeRenderer.circle(battery.getCircle().x, battery.getCircle().y, battery.getCircle().radius);
            shapeRenderer.circle(ice.getCircle().x, ice.getCircle().y, ice.getCircle().radius);
            shapeRenderer.circle(rock.getCircle().x, rock.getCircle().y, rock.getCircle().radius);
            
            shapeRenderer.end();*/
        }
        batcher.end();
    }
}
