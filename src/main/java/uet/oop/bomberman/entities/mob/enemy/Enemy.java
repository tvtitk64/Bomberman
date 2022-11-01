package uet.oop.bomberman.entities.mob.enemy;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import uet.oop.bomberman.entities.mob.enemy.ai.AI;
import uet.oop.bomberman.entities.mob.Mob;
import uet.oop.bomberman.graphics.Sprite;

import static uet.oop.bomberman.BombermanGame.*;

public abstract class Enemy extends Mob {

    public AI _ai;
    protected int point;
    protected int speed;
    int _direction;
    int time = 60;
    int timeDir = 150;
    protected static Text pointEnemy;
    protected Pane pane;

    public Enemy( int x, int y, Image img,int speed, int point) {
        super(x, y, img);
        this.speed = speed;
        this.point = point;
    }

    @Override
    public void update() {
        if(isLife) {
            canMove();
        }
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
                stillObjects.remove(this);
                entities.remove(this);
                root.getChildren().remove(pane);
            }
        }
        gc.drawImage(img,x,y);
    }

    @Override
    public void kill() {
        bomberman.setPoint(bomberman.getPoint() + point);
        setLife(false);
        enemyCount--;
        if (enemyCount == 0) isDoll = true;
        pointEnemy = new Text();
        pointEnemy.setText("+" + String.valueOf(this.point));
        pointEnemy.setFont(Font.font("Arial", FontWeight.BOLD, 12));
        pointEnemy.setFill(Color.WHITE);
        pointEnemy.setX(this.getX() + 12);
        pointEnemy.setY(this.getY() + 50);

        pane = new Pane();
        pane.getChildren().addAll(pointEnemy);
        pane.setMinSize(1,1);
        pane.setMaxSize(1,1);
        pane.setStyle("-fx-background-color: white");
        root.getChildren().add(pane);
        System.out.println("enemy: " + enemyCount);
    }

    @Override
    public void afterKill() {
        setLife(true);
    }

    public abstract void chooseSprite();

    public void canMove() { // 0: up, 1: down, 2: rigth, 3: left
        _direction = _ai.calculateDirection();
        switch (_direction) {
            case 0: {
                if (!canMoveUp()) {
                    _direction = _ai.calculateDirection();
                    return;
                }
                setY(getY() - speed);
                break;
            }
            case 1: {
                if (!canMoveDown()) {
                    _direction = _ai.calculateDirection();
                    return;
                }
                setY(getY() + speed);
                break;
            }
            case 2: {
                if (!canMoveRight()) {
                    _direction = _ai.calculateDirection();
                    return;
                }
                setX(getX() + speed);
                break;
            }
            case 3: {
                if (!canMoveLeft()) {
                    _direction = _ai.calculateDirection();
                    return;
                }
                setX(getX() - speed);
                break;
            }
            case -1:
                _direction = _ai.calculateDirection();
                break;
        }
    }

    public abstract boolean canMoveUp();

    public abstract boolean canMoveDown();

    public abstract boolean canMoveRight();

    public abstract boolean canMoveLeft();

}
