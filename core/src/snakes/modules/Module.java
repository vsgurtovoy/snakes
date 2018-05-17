package snakes.modules;

import snakes.gameworld.GameRenderer;
import snakes.gameworld.GameWorld;

public interface Module {

  public static final int EXIT_SUCCESS = 0;
  public static final int EXIT_FAILURE = 1;

  public void load(GameRenderer gr, GameWorld gw, Module batch);
  public int run();
  public void unload();
}