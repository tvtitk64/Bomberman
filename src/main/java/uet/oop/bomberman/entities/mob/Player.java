package uet.oop.bomberman.entities.mob;

import javafx.scene.image.Image;

import uet.oop.bomberman.BombermanGame;
import uet.oop.bomberman.collision.CollisionChecker;
import uet.oop.bomberman.explosion.Bomb;
import uet.oop.bomberman.graphics.Sprite;
import uet.oop.bomberman.audio.Audio;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.awt.*;
import java.io.IOException;

import static uet.oop.bomberman.BombermanGame.*;

public class Player extends Mob {
    public boolean upPressed;
    public boolean downPressed;
    public boolean leftPressed;
    public boolean rightPressed;
    public static String direction = "";
    public static int spriteNum = 1;
    public static int spriteCount = 0;
    public static int speed = 3;
    public static int timeDie = 48;
    public static int life = 3;
    public static int point = 0;
    private Audio audio = new Audio();
    //Pane pane = new Pane();

    public Player(int x, int y, Image img) {
        super(x, y, img);
        solidArea = new Rectangle();
        solidArea.x = 2;
        solidArea.y = 4;
        solidArea.width = 35;
        solidArea.height = 40;
    }

    public static void SetRestart()
    {
        direction = "";
        spriteNum = 1;
        spriteCount = 0;
        speed = 3;
        timeDie = 48;
        life = 3;
        point = 0;
        bomberman.upPressed = false;
        bomberman.downPressed = false;
        bomberman.leftPressed = false;
        bomberman.rightPressed = false;
        bomberman.img = Sprite.player_right.getFxImage();
        bomberman.isLife = true;
    }

    @Override
    public void update() {

        if (!isLife) {
            switch (timeDie) {
                case 24: {
                    img = Sprite.player_dead1.getFxImage();
                    break;
                }
                case 12: {
                    img = Sprite.player_dead2.getFxImage();
                    break;
                }
                case 6: {
                    img = Sprite.player_dead3.getFxImage();
                    break;
                }
            }
            timeDie--;
            if (timeDie == 0 && life > 0) {
                life--;
                System.out.println("dieeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee");
                setX(48);
                setY(48);
                afterKill();
                img = Sprite.player_right.getFxImage();
                timeDie = 24;
                //root.getChildren().remove(pane);
            } else if (life == 1) {
                BombermanGame.isLife = false;
                System.out.println("Game over!!!!!!!!!!!!!!!!");
                //stillObjects.remove(this);
                //entities.remove(this);
            }
        }

        CollisionChecker checker = new CollisionChecker();
        if (!checker.collisionPlayer(bomberman) && isLife)
            if (this.upPressed || this.downPressed || this.leftPressed || this.rightPressed) {
                if (this.rightPressed) {
                    this.x += speed;
                    if (spriteNum == 1) {
                        this.img = Sprite.player_right_1.getFxImage();
                    }
                    if (spriteNum == 2) {
                        this.img = Sprite.player_right_2.getFxImage();
                    }
                } else if (this.leftPressed) {
                    this.x -= speed;

                    if (spriteNum == 1) {
                        this.img = Sprite.player_left_1.getFxImage();
                    }
                    if (spriteNum == 2) {
                        this.img = Sprite.player_left_2.getFxImage();
                    }
                } else if (this.downPressed) {
                    this.y += speed;


                    if (spriteNum == 1) {
                        this.img = Sprite.player_down_1.getFxImage();
                    }
                    if (spriteNum == 2) {
                        this.img = Sprite.player_down_2.getFxImage();
                    }
                } else if (this.upPressed) {
                    this.y -= speed;


                    if (spriteNum == 1) {
                        this.img = Sprite.player_up_1.getFxImage();
                    }
                    if (spriteNum == 2) {
                        this.img = Sprite.player_up_2.getFxImage();
                    }
                }
            }


        spriteCount++;
        if (spriteCount > 5) {
            if (spriteNum == 1) {
                spriteNum = 2;
            } else if (spriteNum == 2) {
                spriteNum = 1;
            }
            spriteCount = 0;
        }
    }


    @Override
    public void kill() {
        if (timeShield > 0) {
            return;
        } else {
            setLife(false);
            if (life != 1)
                try {
                    audio.audioUpdate("res/sound/dead.wav",0);
                } catch (UnsupportedAudioFileException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (LineUnavailableException e) {
                    e.printStackTrace();
                }


        }
    }

    @Override
    public void afterKill() {
        setLife(true);
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public int getPoint() {
        return point;
    }

    public int getLife() {
        return life;
    }

    public void placeBomb() throws UnsupportedAudioFileException, LineUnavailableException, IOException {

        if (!isLife) return;

        Bomb bom = new Bomb((x + 24 ) / Sprite.SCALED_SIZE,
                (y + 24) / Sprite.SCALED_SIZE,Sprite.bomb.getFxImage(), bomberman);
        bomList.add(bom);
        stillObjects.add(bom);
        audio.audioUpdate("res/sound/place_bomb.wav",0);
    }

}



