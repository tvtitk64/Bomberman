package uet.oop.bomberman.explosion;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import uet.oop.bomberman.BombermanGame;
import uet.oop.bomberman.entities.Entity;
import uet.oop.bomberman.entities.notmoving.Wall;
import uet.oop.bomberman.graphics.Sprite;

import static uet.oop.bomberman.BombermanGame.*;

public class Explosion extends Entity {

    public int dicrection;

    public Explosion(int x, int y, Image img) {
        super(x,y,img);
    }

    public Explosion(int x, int y, int direction, boolean last) {
        super(x,y,null);
        this.dicrection = direction;

        // TODO: kiểm tra hướng di chuyển
        switch (direction) {
            case 0:
                if(last == false) {
                    this.img = Sprite.explosion_vertical2.getFxImage();
                } else {
                    this.img = Sprite.explosion_vertical_top_last2.getFxImage();
                }
                break;
            case 1:
                if(last == false) {
                    this.img = Sprite.explosion_horizontal2.getFxImage();
                } else {
                    this.img = Sprite.explosion_horizontal_right_last2.getFxImage();
                }

                break;
            case 2:
                if(last == false) {
                    this.img = Sprite.explosion_vertical2.getFxImage();
                } else {
                    this.img = Sprite.explosion_vertical_down_last2.getFxImage();
                }

                break;
            case 3:
                if(last == false) {
                    this.img = Sprite.explosion_horizontal2.getFxImage();
                } else {
                    this.img = Sprite.explosion_horizontal_left_last2.getFxImage();
                }

                break;
        }
    }


    @Override
    public void update() {

    }

}
