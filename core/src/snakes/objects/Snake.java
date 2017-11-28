/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snakes.objects;

import snakes.gameworld.GameWorld;

public class Snake {    
    private final int x[] = new int[GameWorld.ALL_DOTS];
    private final int y[] = new int[GameWorld.ALL_DOTS];
       
    private int width;
    private int height;
    private float time;
    
    private enum direction {
        LEFT, RIGHT, UP, DOWN
    }
    
    private enum speed {
        SLOW, MEDIUM, FAST
    }
    
    private direction currentDirection;
    private int length;
    
    public Snake(int x, int y, int width, int height) {
        this.x[0] = x;
        this.y[0] = y;
        this.width = width;
        this.height = height;
    }
    
    public void update(float delta) {
        time += delta;
        if (time >= 1f) {
            
        }
    }
}