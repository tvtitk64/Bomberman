package uet.oop.bomberman.entities.mob.enemy;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import uet.oop.bomberman.BombermanGame;
import uet.oop.bomberman.entities.Entity;
import uet.oop.bomberman.entities.mob.enemy.ai.AIMedium;
import uet.oop.bomberman.entities.notmoving.Wall;
import uet.oop.bomberman.explosion.Bomb;
import uet.oop.bomberman.graphics.Sprite;

import static uet.oop.bomberman.BombermanGame.*;

public class Kondoria extends Enemy { //TODO: đuổi theo người nhưng bị chặn bởi wall,

    public Kondoria(int x, int y, Image img,int speed, int point) {
        super(x, y, img,speed, point);
        _ai = new AIMedium(bomberman,this);
        _direction = _ai.calculateDirection();
    }

    @Override
    public void render(GraphicsContext gc) {

        if(isLife)
            chooseSprite();
        else {
            switch (time) {
                case 60: {
                    img = Sprite.mob_dead1.getFxImage();
                    break;
                }
                case 30: {
                    img = Sprite.mob_dead2.getFxImage();
                    break;
                }
                case 0: {
                    img = Sprite.mob_dead3.getFxImage();
                    break;
                }
            }
            time--;
            if (time == 0) {
                Bomb bom = new Bomb((x + 24 ) / Sprite.SCALED_SIZE,
                        (y + 24) / Sprite.SCALED_SIZE,Sprite.bomb.getFxImage(), this);
                bomList.add(bom);
                stillObjects.add(bom);
                stillObjects.remove(this);
                entities.remove(this);
                root.getChildren().remove(pane);
            }
        }
        gc.drawImage(img,x,y);
    }

    @Override
    public void chooseSprite() {
        if (timeDir > 0 && _direction == 0 || timeDir > 0 && _direction == 3) {
            switch (timeDir) {
                case 150: {
                    img = Sprite.kondoria_left1.getFxImage();
                    break;
                }
                case 100: {
                    img = Sprite.kondoria_left2.getFxImage();
                    break;
                }
                case 50: {
                    img = Sprite.kondoria_left3.getFxImage();
                    break;
                }
            }
            timeDir--;
            if (timeDir == 0) timeDir = 150;
        }
        if (timeDir > 0 && _direction == 1 || timeDir > 0 && _direction == 2) {
            switch (timeDir) {
                case 150: {
                    img = Sprite.kondoria_right1.getFxImage();
                    break;
                }
                case 100: {
                    img = Sprite.kondoria_right2.getFxImage();
                    break;
                }
                case 50: {
                    img = Sprite.kondoria_right3.getFxImage();
                    break;
                }
            }
            timeDir--;
            if (timeDir == 0) timeDir = 150;
        }
    }

    public boolean canMoveUp() {
        for (Entity entity : BombermanGame.stillObjects) {
            if (entity instanceof Enemy) {
                if (entity.check_down(bomberman)) {
                    bomberman.kill();
                }
            }

            if ( entity instanceof Wall
                    || entity instanceof Bomb ) {
                if (entity.check_up(this)) {
                    if (this.getX() - 8 > entity.getMaxX() || this.getMaxX() + 8 < entity.getX())
                        return true;
                    else return false;
                }
            }
        }
        return true;
    }

    public boolean canMoveDown() {
        for (Entity entity : BombermanGame.stillObjects) {
            if (entity instanceof Enemy) {
                if (entity.check_up(bomberman)) {
                    bomberman.kill();
                }
            }
            if ( entity instanceof Wall
                    || entity instanceof Bomb) {
                if (entity.check_down(this)) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean canMoveRight() {
        for (Entity entity : BombermanGame.stillObjects) {
            if (entity instanceof Enemy) {
                if (entity.check_left(bomberman)) {
                    bomberman.kill();
                }
            }
            if ( entity instanceof Wall
                    || entity instanceof Bomb) {
                if (entity.check_right(this)) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean canMoveLeft() {
        for (Entity entity : BombermanGame.stillObjects) {
            if (entity instanceof Enemy) {
                if (entity.check_right(bomberman)) {
                    bomberman.kill();
                }
            }

            if ( entity instanceof Wall
                    || entity instanceof Bomb ) {
                if (entity.check_left(this)) {
                    return false;
                }
            }
        }
        return true;
    }

}
