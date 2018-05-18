package snakes.gameworld;

import java.util.Random;
import snakes.modules.Module;
import snakes.objects.Apple;
import snakes.objects.Applyable;
import snakes.objects.Snake;

public class ModuleGame implements Module {

    GameWorld gw;
    Random rnd;
    
    @Override
    public void load(GameRenderer gr, GameWorld gw, Module batch) {
        this.gw = gw;
        if(gr != null){
            gr.setModule(batch);
        }
        this.rnd = new Random(System.currentTimeMillis());
    }

    @Override
    public int run() {
        Applyable apple = gw.getApple();
        Snake snake = gw.getSnake();
        if(snake.getY(0) == apple.getY()){
            snake.moveLeft();
        } else {
            snake.moveDown();
        }
        return 0;
    }


    @Override
    public void unload() {
        System.out.println("unload");
    }
   
}
