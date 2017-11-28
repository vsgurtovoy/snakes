package snakes.objects;

import snakes.gameworld.GameWorld;

public class Snake {               
    private enum direction {
        LEFT, RIGHT, UP, DOWN
    }
    
    private enum speed {
        SLOW, MEDIUM, FAST
    }
    // TODO поменять на linked list для большей производительности
    private final int x[] = new int[GameWorld.ALL_DOTS];
    private final int y[] = new int[GameWorld.ALL_DOTS];
    private int width;
    private int height;
    private float time;
    private direction currentDirection;
    private int length;
    private int rotation = 0;
    
    public Snake(int x, int y, int width, int height) {
        this.x[0] = x;
        this.y[0] = y;
        this.width = width;
        this.height = height;
    }
    
    public void moveUp() {
        currentDirection = direction.UP;        
    }

    public void moveDown() {
        currentDirection = direction.DOWN;        
    }

    public void moveLeft() {
        currentDirection = direction.LEFT;        
    }

    public void moveRight() {
        currentDirection = direction.RIGHT;        
    }    
    public void update(float delta) {
        time += delta;
        if (time >= 1f) {
            time = 0;
            for (int z = length; z > 0; z--) {
                x[z] = x[(z - 1)];
                y[z] = y[(z - 1)];
            }
            switch (currentDirection) {
                case LEFT: 
                    x[0] -= GameWorld.DOT_SIZE;
                    break;
                case RIGHT: 
                    x[0] -= GameWorld.DOT_SIZE;
                    break;
                case UP: 
                    y[0] += GameWorld.DOT_SIZE;
                    break;
                case DOWN: 
                    y[0] -= GameWorld.DOT_SIZE;
                    break;
                default: break;
            }
        }
    }
    
    public int getX() {
        return x[0];
    }
    
    public int getY() {
        return y[0];
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
}