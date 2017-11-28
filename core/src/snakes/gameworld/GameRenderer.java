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
import snakes.objects.Snake;

public class GameRenderer {
    private GameWorld myWorld;
    private OrthographicCamera cam;
    private ShapeRenderer shapeRenderer;
    private SpriteBatch batcher;
    private Snake snake;
    private int snakeLength;
    private int midPointY;
    private int midPointX;
    private float runTime;
    
    private TextureRegion bg;
    private Animation snakeAnimation;
    private TextureRegion snake1, snake2;
    private TextureRegion apple;
    
    private void initGameObjects() {
        snake = myWorld.getSnake();
    }

    private void initAssets() {
        bg = AssetLoader.bg;
        snakeAnimation = AssetLoader.snakeAnimation;
        snake1 = AssetLoader.snake1;
        snake2 = AssetLoader.snake2;
        apple = AssetLoader.apple;
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

        shapeRenderer.begin(ShapeType.Filled);

        // Заливаем задний фон
        shapeRenderer.setColor(55 / 255.0f, 80 / 255.0f, 100 / 255.0f, 1);
        shapeRenderer.rect(0, 0, 136, 204);

        // Рисуем Grass
        /*
        shapeRenderer.setColor(111 / 255.0f, 186 / 255.0f, 45 / 255.0f, 1);
        shapeRenderer.rect(0, midPointY + 66, 136, 11);

        // Рисуем Dirt
        shapeRenderer.setColor(147 / 255.0f, 80 / 255.0f, 27 / 255.0f, 1);
        shapeRenderer.rect(0, midPointY + 77, 136, 52);*/

        shapeRenderer.end();

        batcher.begin();
        batcher.disableBlending();
        //batcher.draw(bg, 0, midPointY + 23, 136, 43);

        batcher.enableBlending();

        batcher.draw((TextureRegion) snakeAnimation.getKeyFrame(runTime), 
                snake.getX(0), snake.getY(0), 
                snake.getWidth()/2f, snake.getHeight()/2f, 
                snake.getWidth(), snake.getHeight(),
                1, 1, snake.getRotation());
        batcher.draw((TextureRegion) snakeAnimation.getKeyFrame(runTime), 
                snake.getX(1), snake.getY(1), 
                snake.getWidth()/2f, snake.getHeight()/2f, 
                snake.getWidth(), snake.getHeight(),
                1, 1, snake.getRotation());
        snakeLength = snake.getLength();
        for (int i = 2; i < snakeLength; i++) {
            batcher.draw(snake1, 
                snake.getX(i), snake.getY(i) 
                );
        }      
        batcher.end();
        shapeRenderer.begin(ShapeType.Filled);
        shapeRenderer.setColor(Color.RED);
        for (int i = 0; i < snakeLength; i++) {
            shapeRenderer.circle(snake.getCircle(i).x, snake.getCircle(i).y, snake.getCircle(i).radius);
        }
        shapeRenderer.end();
    }
}
