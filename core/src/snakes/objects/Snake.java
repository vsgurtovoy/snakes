package snakes.objects;

import com.badlogic.gdx.math.Circle;
import snakes.gameworld.GameWorld;
import snakes.helpers.AssetLoader;

public class Snake {               
    private enum direction {
        LEFT, RIGHT, UP, DOWN
    }
    // TODO поменять на linked list для большей производительности
    // Координаты частей змейки
    private final int x[] = new int[GameWorld.ALL_DOTS];
    private final int y[] = new int[GameWorld.ALL_DOTS];
    private Circle circle[] = new Circle[GameWorld.ALL_DOTS];
    // Размеры части змейки
    private int width;
    private int height;
    // Время между переходами
    private float time;
    // скорость передвижения змейки
    private float velocity;
    // Направление движения змеи
    private direction currentDirection;
    // Длина змеи
    private int length;
    // напр
    private int rotation;
    
    public boolean isDead;
    private GameWorld world;
    
    
    public Snake(GameWorld world, int x, int y, int width, int height) {
        this.world = world;
        this.x[0] = 20;
        this.y[0] = 20;
        this.width = width;
        this.height = height;
        currentDirection = direction.DOWN;
        rotation = 180;
        length = 1;
        isDead = false;
        velocity = 0.5f;
        for (int i = 0; i < GameWorld.ALL_DOTS; i++) {
            circle[i] = new Circle(this.x[0]+GameWorld.DOT_SIZE/2,
                this.y[0]+GameWorld.DOT_SIZE/2, 
                GameWorld.DOT_SIZE/2); 
        }
        feed(3);
    }
    
    public void onRestart() {
        this.x[0] = 20;
        this.y[0] = 20;
        for (int i = 0; i < GameWorld.ALL_DOTS; i++) {
            circle[i].setPosition(this.x[0]+GameWorld.DOT_SIZE/2, this.y[0]+GameWorld.DOT_SIZE/2); 
        }
        currentDirection = direction.DOWN;
        rotation = 180;
        length = 1;
        isDead = false;
        velocity = 0.5f;        
        feed(3);
    }
    
    public void feed(int times) {
        for (int j = 1; j <= times; j++) {
            length++;
            move();
        }
    }
    
    public void cut(int times) {
        length--;
        if (length == 0) {
            isDead = true;
        }
    }
    
    public void kill() {
        isDead = true;
    }
    
    public void makeFaster() {
        velocity -= 0.25f;
    }
    
    public void makeSlower() {
        velocity += 0.25f;
    }
    
    public Circle getCircle(int i) {
        return circle[i];
    }
    
    public void moveUp() {
        if (currentDirection != direction.DOWN) {
            currentDirection = direction.UP;  
            rotation = 0;
            AssetLoader.turn.play();
        }
    }

    public void moveDown() {
        if (currentDirection != direction.UP) {
            currentDirection = direction.DOWN;
            rotation = 180;
            AssetLoader.turn.play();
        }
    }

    public void moveLeft() {
        if (currentDirection != direction.RIGHT) {
            currentDirection = direction.LEFT;
            rotation = -90;
            AssetLoader.turn.play();
        }
    }

    public void moveRight() {
        if (currentDirection != direction.LEFT) {
            currentDirection = direction.RIGHT;  
            rotation = 90;
            AssetLoader.turn.play();
        }
    }    
    public void update(float delta) {
        time += delta;
        if (time >= velocity) {
            time = 0;          
            this.move();
            Applyable thing = Handler.isOnApplyable(this, world);
            if (thing != null) {
                thing.apply(this);
            }
        }
        Handler.collides(this);
        if (isDead) {
            AssetLoader.dead.play();
        }
    }
    
    private void move() {
        for (int z = length-1; z > 0; z--) {
            x[z] = x[(z - 1)];
            y[z] = y[(z - 1)];

            circle[z].setPosition(circle[z-1].x, circle[z-1].y);
        }

        switch (currentDirection) {
            case LEFT: 
                x[0] -= GameWorld.DOT_SIZE;
                if (x[0] < 0) {
                    x[0] = x[0] + 130;
                }
                circle[0].setX(circle[0].x - GameWorld.DOT_SIZE);
                break;
            case RIGHT: 
                x[0] += GameWorld.DOT_SIZE;
                if (x[0] > 130) {
                    x[0] = x[0] - 130;
                }
                circle[0].setX(circle[0].x + GameWorld.DOT_SIZE);
                break;
            case UP: 
                y[0] -= GameWorld.DOT_SIZE;
                if (y[0] < 0) {
                    y[0] = y[0] + 200;
                }
                circle[0].setY(circle[0].y - GameWorld.DOT_SIZE);
                break;
            case DOWN:
                y[0] += GameWorld.DOT_SIZE;
                if (y[0] > 200) {
                    y[0] = y[0] - 200;
                }
                circle[0].setY(circle[0].y + GameWorld.DOT_SIZE);
                break;
            default: break;
        }
    }
    
    public int getX(int i) {
        return x[i];
    }
    
    public int getY(int i) {
        return y[i];
    }
    
    public int getWidth() {
        return width;
    }
    
    public int getHeight() {
        return height;
    }
    
    public int getRotation() {
        return rotation;
    }
    
    public int getLength() {
        return length;
    }
}