package snakes.objects;

import snakes.gameworld.GameWorld;

public class ApplyableFactory {
    
    GameWorld world;
    
    public ApplyableFactory(GameWorld world) {
        this.world = world;
    }
    
    public Applyable createApple() {
        return new Applyable(this.world, 50, 50, Applyable.objType.APPLE);
    }

    public Applyable createFlickerApple() { return new Applyable(this.world, 60, 60, Applyable.objType.FLICKERAPPLE); }
    
    public Applyable createColdApple() {
        return new Applyable(this.world, -70, -70, Applyable.objType.COLDAPPLE);
    }
    
    public Applyable createBattery() {
        return new Applyable(this.world, -80, -80, Applyable.objType.BATTERY);
    }
    
    public Applyable createIce() {
        return new Applyable(this.world, -90, -90, Applyable.objType.ICE);
    }
    
    public Applyable createRock() {
        return new Applyable(this.world, -100, -100, Applyable.objType.ROCK);
    }
    
    public Applyable createPaint() {
        return new Applyable(this.world, -110, -110, Applyable.objType.PAINT);
    }
}
