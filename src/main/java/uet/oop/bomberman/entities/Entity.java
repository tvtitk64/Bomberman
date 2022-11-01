package uet.oop.bomberman.entities;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import uet.oop.bomberman.graphics.Sprite;
import uet.oop.bomberman.handlelevel.Coordinates;

import java.awt.*;

import static uet.oop.bomberman.graphics.Sprite.SCALED_SIZE;

public abstract class Entity {
    //Tọa độ X tính từ góc trái trên trong Canvas
    public int x;

    //Tọa độ Y tính từ góc trái trên trong Canvas
    public int y;

    public Image img;

    public boolean itemBomb = false;
    public Rectangle solidArea;
    public Sprite _sprite = new Sprite(16,0xffff00ff);



    //Khởi tạo đối tượng, chuyển từ tọa độ đơn vị sang tọa độ trong canvas
    public Entity( int xUnit, int yUnit, Image img) {
        this.x = xUnit * SCALED_SIZE;
        this.y = yUnit * SCALED_SIZE;
        this.img = img;
    }

    public Entity () {};

    public void render(GraphicsContext gc) {
        gc.drawImage(img, x, y);
    }
    public abstract void update();

    public boolean check_left(Entity entity) {
        boolean impactX = (this.getMaxX() == entity.getX());
        boolean intersectY = (entity.getY() >= this.getY() && entity.getY() < this.getMaxY()
                || (entity.getMaxY() > this.getY() && entity.getMaxY() <= this.getMaxY()));
        return impactX && intersectY;

    }

    public boolean check_up(Entity entity) {
        boolean impactY = (this.getMaxY() == entity.getY());
        boolean intersectX = (entity.getX() <= this.getX() && entity.getMaxX() > this.getX()
                || (entity.getMaxX() >= this.getMaxX() && entity.getX() < this.getMaxX()));
        return impactY && intersectX;
    }

    public boolean check_right(Entity entity) {
        boolean impactX = (this.getX() == entity.getMaxX());
        boolean intersectY = (entity.getY() >= this.getY() && entity.getY() < this.getMaxY()
                || (entity.getMaxY() > this.getY() && entity.getMaxY() <= this.getMaxY()));
        return impactX && intersectY;
    }

    public boolean check_down(Entity entity) {
        boolean impactY = (this.getY() == entity.getMaxY());
        boolean intersectX = (entity.getX() <= this.getX() && entity.getMaxX() > this.getX()
                || (entity.getMaxX() >= this.getMaxX() && entity.getX() < this.getMaxX()));
        return impactY && intersectX;

    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getMaxX() {
        return x + SCALED_SIZE;
    }

    public int getMaxY() {
        return y + SCALED_SIZE;
    }

    public int getXTile() {
        return Coordinates.pixelToTile( x + _sprite.SIZE / 2);
    }

    public int getYTile() {
        return Coordinates.pixelToTile(y + 24 - _sprite.SIZE / 2);
    }

}
