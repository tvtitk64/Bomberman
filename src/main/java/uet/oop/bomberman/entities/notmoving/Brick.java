package uet.oop.bomberman.entities.notmoving;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import uet.oop.bomberman.BombermanGame;
import uet.oop.bomberman.entities.Entity;
import uet.oop.bomberman.entities.mob.enemy.Enemy;
import uet.oop.bomberman.graphics.Sprite;
import uet.oop.bomberman.handlelevel.Handle;

import static uet.oop.bomberman.BombermanGame.isItem;
import static uet.oop.bomberman.handlelevel.Handle.*;

public class Brick extends Entity {
    private boolean destroyed = false;
    private int time = 24;
    public Brick(int x, int y, Image img) {
        super(x, y, img);
    }

    public void setDestroyed(boolean destroyed) {
        this.destroyed = destroyed;
    }

    @Override
    public void update() {
    }

    @Override
    public void render(GraphicsContext gc) {
        if (destroyed) {
            if (time > 0) {
                switch (time) {
                    case 24: {
                        img = Sprite.brick_exploded.getFxImage();
                        System.out.println(24);
                        break;
                    }
                    case 16: {
                        img = Sprite.brick_exploded1.getFxImage();
                        System.out.println(16);
                        break;
                    }
                    case 8: {
                        img = Sprite.brick_exploded2.getFxImage();
                        System.out.println(8);
                        break;
                    }
                }
                time--;
            } else {
                if (y / Sprite.SCALED_SIZE == portalY && x / Sprite.SCALED_SIZE == portalX)
                {
                    Handle.matrixTile[y / Sprite.SCALED_SIZE][x / Sprite.SCALED_SIZE] = 9;
                    BombermanGame.stillObjects.remove(this);
                }
                else {
                    Handle.matrixTile[y / Sprite.SCALED_SIZE][x / Sprite.SCALED_SIZE] = 2;
                    BombermanGame.stillObjects.remove(this);
                }
            }
        }
        gc.drawImage(img,x,y);
    }
}
