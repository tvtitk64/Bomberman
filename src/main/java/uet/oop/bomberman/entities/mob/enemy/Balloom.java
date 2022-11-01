package uet.oop.bomberman.entities.mob.enemy;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
//import uet.oop.bomberman.collision.CollisionChecker;
import uet.oop.bomberman.BombermanGame;
import uet.oop.bomberman.entities.Entity;
import uet.oop.bomberman.entities.mob.enemy.ai.AILow;
import uet.oop.bomberman.entities.mob.enemy.ai.AIMedium;
import uet.oop.bomberman.entities.notmoving.Brick;
import uet.oop.bomberman.entities.notmoving.Wall;
import uet.oop.bomberman.explosion.Bomb;
import uet.oop.bomberman.graphics.Sprite;
import uet.oop.bomberman.handlelevel.Handle;

import java.awt.*;
import java.util.Random;

import static uet.oop.bomberman.BombermanGame.*;
//import uet.oop.bomberman.entities.mob.enemy.ai.AILow;

public class Balloom extends Enemy { //TODO: di chuyển ngẫu nhiên

    private int maxStep = 60;
    private int step = 0;
    public Balloom(int x, int y, Image img,int speed, int point) {
        super(x, y, img, speed, point);
        _ai = new AILow();
        _direction = _ai.calculateDirection();
    }

    @Override
    public void canMove() { // 0: up, 1: down, 2: rigth, 3: left
        switch (_direction) {
            case 0: {
                if (!canMoveUp() || step == maxStep) {
                    _direction = _ai.calculateDirection();
                    if (step == maxStep) step = 0;
                    return;
                }
                setY(getY() - speed);
                step++;
                break;
            }
            case 1: {
                if (!canMoveDown() || step == maxStep) {
                    _direction = _ai.calculateDirection();
                    if (step == maxStep) step = 0;

                    return;
                }
                setY(getY() + speed);
                step++;
                break;
            }
            case 2: {
                if (!canMoveRight() || step == maxStep) {
                    _direction = _ai.calculateDirection();
                    if (step == maxStep) step = 0;

                    return;
                }
                setX(getX() + speed);
                step++;

                break;
            }
            case 3: {
                if (!canMoveLeft() || step == maxStep) {
                    _direction = _ai.calculateDirection();
                    if (step == maxStep) step = 0;

                    return;
                }
                setX(getX() - speed);
                step++;
                break;
            }
            default:
                _direction = _ai.calculateDirection();
                break;
        }
    }

    @Override
    public void chooseSprite() {
        if (timeDir > 0 && _direction == 0 || timeDir > 0 && _direction == 3) {
            switch (timeDir) {
                case 150: {
                    img = Sprite.balloom_left1.getFxImage();
                    break;
                }
                case 100: {
                    img = Sprite.balloom_left2.getFxImage();
                    break;
                }
                case 50: {
                    img = Sprite.balloom_left3.getFxImage();
                    break;
                }
            }
            timeDir--;
            if (timeDir == 0) timeDir = 150;
        }
        if (timeDir > 0 && _direction == 1 || timeDir > 0 && _direction == 2) {
            switch (timeDir) {
                case 150: {
                    img = Sprite.balloom_right1.getFxImage();
                    break;
                }
                case 100: {
                    img = Sprite.balloom_right2.getFxImage();
                    break;
                }
                case 50: {
                    img = Sprite.balloom_right3.getFxImage();
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

            if ( entity instanceof Wall || entity instanceof Brick
                    || entity instanceof Bomb) {
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
            if ( entity instanceof Wall || entity instanceof Brick
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
            if ( entity instanceof Wall || entity instanceof Brick
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

            if ( entity instanceof Wall || entity instanceof Brick
                    || entity instanceof Bomb) {
                if (entity.check_left(this)) {
                    return false;
                }
            }
        }
        return true;
    }

}
