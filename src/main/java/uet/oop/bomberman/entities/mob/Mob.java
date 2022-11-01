package uet.oop.bomberman.entities.mob;

import  javafx.scene.image.Image;
import uet.oop.bomberman.entities.Entity;

public abstract class Mob extends Entity {

    protected boolean isLife = true;

    public Mob(int xUnit, int yUnit, Image img) {
        super(xUnit, yUnit, img);
    }

    @Override
    public void update() {

    }

    protected int _animate = 0;
    protected final int MAX_ANIMATE = 7500; //save the animation status and dont let this get too big

    protected void animate() {
        if(_animate < MAX_ANIMATE) _animate++; else _animate = 0; //reset animation
    }

    public abstract void kill();

    public abstract void afterKill();

    public void setLife(boolean isAlive) {
        this.isLife = isAlive;
    }

    public boolean isLife() {
        return isLife;
    }
}
