package snakes.objects;

import com.badlogic.gdx.math.Circle;
import snakes.gameworld.GameWorld;

public class Snake {               
    private enum direction {
        LEFT, RIGHT, UP, DOWN
    }
    
    private enum speed {
        SLOW, MEDIUM, FAST
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
    // Направление движения змеи
    private direction currentDirection;
    // Длина змеи
    private int length;
    // напр
    private int rotation;
    
    public boolean isDead;
    
    
    public Snake(int x, int y, int width, int height) {
        this.x[0] = 20;
        this.y[0] = 20;
        this.width = width;
        this.height = height;
        currentDirection = direction.DOWN;
        rotation = 180;
        length = 0;
        isDead = false;
        growSnake(5);
        circle[0] = new Circle(this.x[0]+GameWorld.DOT_SIZE/2,
                this.y[0]+GameWorld.DOT_SIZE/2, 
                GameWorld.DOT_SIZE/2);
    }
    
    public void growSnake(int x) {
        for (int i = 1; i < x; i++) {
            if (currentDirection == direction.UP) {
                this.x[i] = this.x[i-1];
                this.y[i] = this.y[i-1] + GameWorld.DOT_SIZE;
            }
            if (currentDirection == direction.DOWN) {
                this.x[i] = this.x[i-1];
                this.y[i] = this.y[i-1] - GameWorld.DOT_SIZE;
            }
            if (currentDirection == direction.LEFT) {
                this.x[i] = this.x[i-1] + GameWorld.DOT_SIZE;
                this.y[i] = this.y[i-1];
            }
            if (currentDirection == direction.RIGHT) {
                this.x[i] = this.x[i-1] - GameWorld.DOT_SIZE;
                this.y[i] = this.y[i-1];
            }
            this.circle[i] = new Circle(this.x[i] + GameWorld.DOT_SIZE/2, 
                    this.y[i]+GameWorld.DOT_SIZE/2,
                    GameWorld.DOT_SIZE/2);
        }
        length = x;
    }
    
    public Circle getCircle(int i) {
        return circle[i];
    }
    
    public void moveUp() {
        currentDirection = direction.UP;  
        rotation = 0;
    }

    public void moveDown() {
        currentDirection = direction.DOWN;
        rotation = 180;
    }

    public void moveLeft() {
        currentDirection = direction.LEFT;
        rotation = -90;
    }

    public void moveRight() {
        currentDirection = direction.RIGHT;  
        rotation = 90;
    }    
    public void update(float delta) {
        time += delta;
        if (time >= 0.5f) {
            time = 0;
            
            if (!this.isDead) {
                this.move();
            }
            
        }
        Handler.collides(this);
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
                circle[0].setX(circle[0].x - GameWorld.DOT_SIZE);
                break;
            case RIGHT: 
                x[0] += GameWorld.DOT_SIZE;
                circle[0].setX(circle[0].x + GameWorld.DOT_SIZE);
                break;
            case UP: 
                y[0] -= GameWorld.DOT_SIZE;
                circle[0].setY(circle[0].y - GameWorld.DOT_SIZE);
                break;
            case DOWN: 
                y[0] += GameWorld.DOT_SIZE;
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