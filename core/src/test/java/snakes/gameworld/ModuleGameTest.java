package snakes.gameworld;

import org.junit.Assert;
import org.junit.Test;
import snakes.helpers.AssetLoader;

public class ModuleGameTest {
    @Test
    public void ChangeDirectionToAppleDown(){
        GameWorld gw = new GameWorld();
        gw.getSnake().moveLeft();
        Assert.assertEquals(-90, gw.getSnake().getRotation());
        gw.getApple().setX(0);
        gw.getApple().setY(7);
        ModuleGame bot = new ModuleGame();
        bot.load(null, gw, null);
        bot.run();
        Assert.assertEquals(180, gw.getSnake().getRotation());
    }

    @Test
    public void KeepDirectionToAppleDown(){
        GameWorld gw = new GameWorld();
        gw.getApple().setX(0);
        gw.getApple().setY(7);
        ModuleGame bot = new ModuleGame();
        bot.load(null, gw, null);
        bot.run();
        Assert.assertEquals(180, gw.getSnake().getRotation());
    }

    @Test
    public void ChangeDirectionToAppleLeft(){
        GameWorld gw = new GameWorld();
        ModuleGame bot = new ModuleGame();
        bot.load(null, gw, null);
        bot.run();
        Assert.assertEquals(-90, gw.getSnake().getRotation());

    }

    @Test
    public void KeepDirectionToAppleLeft(){
        GameWorld gw = new GameWorld();
        gw.getSnake().moveRight();
        Assert.assertEquals(90, gw.getSnake().getRotation());
        ModuleGame bot = new ModuleGame();
        bot.load(null, gw, null);
        bot.run();
        Assert.assertEquals(90, gw.getSnake().getRotation());
    }

}