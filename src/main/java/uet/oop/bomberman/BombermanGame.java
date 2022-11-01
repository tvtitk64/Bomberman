package uet.oop.bomberman;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import uet.oop.bomberman.audio.Audio;
import uet.oop.bomberman.entities.*;
import uet.oop.bomberman.entities.mob.Mob;
import uet.oop.bomberman.entities.mob.enemy.*;
import uet.oop.bomberman.entities.mob.Player;
import uet.oop.bomberman.entities.notmoving.Portal;
import uet.oop.bomberman.explosion.Bomb;
import uet.oop.bomberman.entities.notmoving.Brick;
import uet.oop.bomberman.entities.notmoving.Grass;
import uet.oop.bomberman.entities.notmoving.Wall;
import uet.oop.bomberman.graphics.Sprite;
import uet.oop.bomberman.graphics.Menu;
import uet.oop.bomberman.handlelevel.Handle;
import uet.oop.bomberman.item.*;
import uet.oop.bomberman.tile.TileManage;

import javax.sound.sampled.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static javafx.scene.input.KeyCode.*;
import static javax.sound.sampled.AudioSystem.getAudioInputStream;
import static uet.oop.bomberman.graphics.Menu.*;

public class BombermanGame extends Application {

    public static final int WIDTH = 31; // have 31 columns
    public static final int HEIGHT = 13; // have 13 rows

    private GraphicsContext gc;
    public static Canvas canvas;
    public static List<Entity> entities = new ArrayList<>();
    public static List<Entity> stillObjects = new ArrayList<>();
    public static List<Bomb> bomList = new ArrayList<>();
    public static int maxBomb = 1;
    public static int maxRadius = 3;
    public static int maxSpeed = 4;
    public static int bomRadius = 1;
    public static int level = 1;
    public static int timeShield = 0;
    public static boolean isRun;
    public static boolean isLife = true;
    private long lastTime;
    private long lastTimeItem;
    public static boolean isItem = false;
    public static int enemyCount = 0;
    public static Mob mob;
    public static boolean isDoll = false;
    public static int timeNumber = 200;
    private static Audio audio = new Audio();
    public static boolean isLevel = true;
    public static Group root = new Group();

    // user defined
    int playerX = 1;
    int playerY = 1;

    public static void main(String[] args) {
        Application.launch(BombermanGame.class);
    }

    public static Player bomberman = new Player(1, 1, Sprite.player_right.getFxImage());


    @Override
    public void start(Stage stage) {
        // Tao Canvas
        TileManage.createTile();

        canvas = new Canvas(Sprite.SCALED_SIZE * WIDTH, Sprite.SCALED_SIZE * HEIGHT); // canvas size:
        canvas.setTranslateY(50);
        gc = canvas.getGraphicsContext2D();

        entities.add(bomberman);
        stillObjects.add(bomberman);

        try {
            audio.audioUpdate("res/sound/BlueBoyAdventure.wav",-1);
        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        }
        //Tao root container
        Menu.createMenu(root);

        root.getChildren().add(canvas);
        // Tao scene
        Scene scene = new Scene(root);

        //TODO: check phím nhận vào
        scene.setOnKeyPressed(KeyEvent -> {
            if (KeyEvent.getCode() == RIGHT) {
                bomberman.rightPressed = true;
                bomberman.leftPressed = false;
                bomberman.downPressed = false;
                bomberman.upPressed = false;
                bomberman.direction = "right";

            } else if (KeyEvent.getCode() == LEFT) {
                bomberman.leftPressed = true;
                bomberman.rightPressed = false;
                bomberman.downPressed = false;
                bomberman.upPressed = false;

                bomberman.direction = "left";
            } else if (KeyEvent.getCode() == KeyCode.DOWN) {
                bomberman.downPressed = true;
                bomberman.rightPressed = false;
                bomberman.leftPressed = false;
                bomberman.upPressed = false;;
                bomberman.direction = "down";
            } else if (KeyEvent.getCode() == KeyCode.UP){
                bomberman.upPressed = true;
                bomberman.rightPressed = false;
                bomberman.leftPressed = false;
                bomberman.downPressed = false;
                bomberman.direction = "up";

            } else if (KeyEvent.getCode() == KeyCode.SPACE && bomList.size() < maxBomb){
                try {
                    bomberman.placeBomb();
                } catch (UnsupportedAudioFileException e) {
                    e.printStackTrace();
                } catch (LineUnavailableException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else if (KeyEvent.getCode() == N) {
                nextMap();
            }
        });

        //TODO: check phím cuối cùng được bấm
        scene.setOnKeyReleased(KeyEvent -> {
            if (KeyEvent.getCode() == RIGHT) {
                bomberman.rightPressed = false;
                bomberman.leftPressed = false;
                bomberman.downPressed = false;
                bomberman.upPressed = false;
                bomberman.direction = "";
                bomberman.img = Sprite.player_right.getFxImage();
            } else if (KeyEvent.getCode() == LEFT) {
                bomberman.rightPressed = false;
                bomberman.leftPressed = false;
                bomberman.downPressed = false;
                bomberman.upPressed = false;
                bomberman.direction = "";
                bomberman.img = Sprite.player_left.getFxImage();

            } else if (KeyEvent.getCode() == KeyCode.DOWN) {
                bomberman.rightPressed = false;
                bomberman.leftPressed = false;
                bomberman.downPressed = false;
                bomberman.upPressed = false;
                bomberman.direction = "";
                bomberman.img = Sprite.player_down.getFxImage();
            } else if (KeyEvent.getCode() == KeyCode.UP){
                bomberman.rightPressed = false;
                bomberman.leftPressed = false;
                bomberman.downPressed = false;
                bomberman.upPressed = false;
                bomberman.direction = "";
                bomberman.img = Sprite.player_up.getFxImage();
            }
        });

        stage.setTitle("Bomberman");
        stage.setScene(scene);
        stage.show();


        AnimationTimer timer = new AnimationTimer() {
            final double drawInterval = (double) 1000000000 / 60; //TODO: khóa fps 60 lần 1s
            double delta = 0;

            long lastTime = System.nanoTime();
            long timer = 0;
            int drawCount = 0;

            @Override
            public void handle(long l) {
                delta += (l - lastTime) / drawInterval;
                timer += (l - lastTime);
                lastTime = l;

                if (delta >= 1) {
                    render();
                    if (!isRun) {
                        update();
                        delta--;
                        drawCount++;
                        getMenu();
                        if (isLevel) getLevelUp();
                        getItem();
                        if (level > 3) {
                            Menu.YouWin(root);
                            isRun = !isRun;
                        }
                        if (timeNumber < 0 || !isLife){
                            Menu.GameOver(root);
                            try {
                                audio.audioUpdate("res/sound/just_died.wav",0);
                            } catch (UnsupportedAudioFileException e) {
                                e.printStackTrace();
                            } catch (IOException e) {
                                e.printStackTrace();
                            } catch (LineUnavailableException e) {
                                e.printStackTrace();
                            }
                            isRun = !isRun;

                        }
                    }
                    else UpdateRestart();

                }
                if (timer >= 1000000000) {
                    drawCount = 0;
                    timer = 0;
                }
            }
        };
        timer.start();

        createMap();

        //TODO: check số quái trong map
        for (Entity entity : entities) {
            if (entity instanceof Enemy && !(entity instanceof Doll))
                enemyCount++;
        }

    }

    public static void nextMap() {
        for (int i = stillObjects.size() - 1; i >= 0; i--) {
            stillObjects.remove(i);
        }
        for (int i = entities.size() - 1; i >= 0; i--) {
            if (entities.get(i) instanceof Enemy)
                entities.remove(i);
        }
        isDoll = false;
        timeNumber = 200;
        level++;
        enemyCount = 0;
        if (level < 4) {
            try {
                audio.audioUpdate("res/sound/level_complete.wav",0);
            } catch (UnsupportedAudioFileException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (LineUnavailableException e) {
                e.printStackTrace();
            }
            Handle.setLevel(level);
            bomberman.setX(48);
            bomberman.setY(48);
            createMap();
            timeNumber = 200;
            for (Entity entity : entities) {
                if (entity instanceof Enemy && !(entity instanceof Doll))
                    enemyCount++;
            }
        }
    }

    public void getMenu() {
        if (timeNumber >= 0) {
            if (timeNumber == 0) {
                timeText.setText("Time Left: " + timeNumber);
                timeNumber--;
            } else {
                long now = System.currentTimeMillis();
                if (now - lastTime > 1000) {
                    lastTime = System.currentTimeMillis();

                    timeText.setText("Time Left: " + timeNumber);
                    timeNumber--;
                }
            }
        }

        lifeText.setText("Lives: " + bomberman.getLife());
        pointText.setText("Points: " + bomberman.getPoint());
        levelText.setText("Level: " + level);
    }

    public static void getLevelUp() {
        textSceen = new Text();
        textSceen.setText("Level " + level);
        textSceen.setFont(Font.font("Arial", FontWeight.BOLD, 100));
        textSceen.setFill(Color.WHITE);
        textSceen.setX((Sprite.SCALED_SIZE * WIDTH / 2) - 200);
        textSceen.setY((Sprite.SCALED_SIZE * HEIGHT / 2) + 50);

        Pane pane = new Pane();
        pane.getChildren().addAll(textSceen);
        pane.setMinSize(Sprite.SCALED_SIZE * WIDTH, Sprite.SCALED_SIZE * HEIGHT + 100);
        pane.setMaxSize(Sprite.SCALED_SIZE * WIDTH, Sprite.SCALED_SIZE * HEIGHT + 100);
        pane.setStyle("-fx-background-color: #353535");
        root.getChildren().add(pane);
        root.getChildren().remove(pane);
        isLevel = false;
    }

    public void getItem() {
        if (timeShield >= 0) {
            if (timeShield == 0){
                itemText.setText("Shield: " + timeShield);
            }
            else {
                long now = System.currentTimeMillis();
                if (now - lastTimeItem > 1000) {
                    lastTimeItem = System.currentTimeMillis();

                    itemText.setText("Shield: " + timeShield);
                    timeShield--;
                }
            }
        }
    }

    public static void createMap() {
        Handle.handleFile();
        for (int i = 0; i < Handle.r; i++) {
            for (int j = 0; j < Handle.c; j++) {
                Entity obj = new Grass(j, i, Sprite.grass.getFxImage());
                stillObjects.add(obj);
                Entity object;
                ItemUp item;
                Entity portal;
                if (Handle.matrixTile[i][j] == 0) {
                    object = new Wall(j, i, Sprite.wall.getFxImage());
                    stillObjects.add(object);
                } else if (Handle.matrixTile[i][j] == 1) {
                    object = new Brick(j, i, Sprite.brick.getFxImage());
                    stillObjects.add(object);
                } else if (Handle.matrixTile[i][j] == 3) {
                    object = new Balloom(j, i, Sprite.balloom_left1.getFxImage(),1, 100);
                    entities.add(object);
                    stillObjects.add(object);
                } else if (Handle.matrixTile[i][j] == 4) {
                    object = new Oneal(j, i, Sprite.oneal_right1.getFxImage(),2, 200);
                    entities.add(object);
                    stillObjects.add(object);
                } else if (Handle.matrixTile[i][j] == 5) {
                    object = new Kondoria(j, i, Sprite.kondoria_right1.getFxImage(),2, 500);
                    entities.add(object);
                    stillObjects.add(object);
                } else if (Handle.matrixTile[i][j] == 6) {
                    item = new ItemBomb(j, i, Sprite.powerup_bombs.getFxImage());
                    stillObjects.add(item);
                    Handle.matrixTile[i][j] = 1;
                    object = new Brick(j, i, Sprite.brick.getFxImage());
                    stillObjects.add(object);
                }
                else if (Handle.matrixTile[i][j] == 8) {
                    item = new ItemFlame(j, i, Sprite.powerup_flames.getFxImage());
                    stillObjects.add(item);
                    Handle.matrixTile[i][j] = 1;
                    object = new Brick(j, i, Sprite.brick.getFxImage());
                    stillObjects.add(object);
                }
                else if (Handle.matrixTile[i][j] == 9) {
                    portal = new Portal(j, i, Sprite.portal.getFxImage());
                    stillObjects.add(portal);
                    Handle.matrixTile[i][j] = 1;
                    object = new Brick(j, i, Sprite.brick.getFxImage());
                    stillObjects.add(object);

                } else if (Handle.matrixTile[i][j] == 10) {
                    object = new Doll(j, i, Sprite.doll_left1.getFxImage(), 1, 1000);
                    entities.add(object);
                    stillObjects.add(object);
                }
                else if (Handle.matrixTile[i][j] == 11) {
                    item = new ItemShield(j, i, Sprite.powerup_flamepass.getFxImage());
                    stillObjects.add(item);
                    Handle.matrixTile[i][j] = 1;
                    object = new Brick(j, i, Sprite.brick.getFxImage());
                    stillObjects.add(object);
                }
                else if (Handle.matrixTile[i][j] == 7) {
                    item = new ItemSpeed(j, i, Sprite.powerup_speed.getFxImage());
                    stillObjects.add(item);
                    Handle.matrixTile[i][j] = 1;
                    object = new Brick(j, i, Sprite.brick.getFxImage());
                    stillObjects.add(object);
                }
            }
        }
    }

    public static Entity getEntity(int x, int y) {
        if (getBrick(x,y) != null) {
            return getBrick(x,y);
        } else {
            for (Entity entity : stillObjects) {
                if (entity instanceof Wall) {
                    if (entity.getX() == x && entity.getY() == y) {
                        return (Wall) entity;
                    }
                }
            }
        }
        return new Grass(x,y,Sprite.grass.getFxImage());
    }

    public static Brick getBrick(int x, int y) {
        for (Entity entity : stillObjects) {
            if (entity instanceof Brick) {
                if (entity.getX() == x && entity.getY() == y) {
                    return (Brick) entity;
                }
            }
        }
        return null;
    }

    public void update() {

        for (int i = 0 ; i < entities.size(); i++) {
            entities.get(i).update();
        }
        for (int i = 0 ; i < bomList.size(); i++) {
            bomList.get(i).update();
        }

    }

    public void render() {
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());

        for (int i = 0 ; i < stillObjects.size(); i++) {
            stillObjects.get(i).render(gc);
        }
        for (int i = 0 ; i < entities.size(); i++) {
            entities.get(i).render(gc);
        }
        for (int i = 0 ; i < bomList.size(); i++) {
            bomList.get(i).render(gc);
        }
    }

    public static void restartGame()
    {
        maxBomb = 1;
        maxRadius = 3;
        maxSpeed = 4;
        bomRadius = 1;
        level = 0;
        timeShield = 0;
        isRun = false;
        isLife = true;
        isItem = false;
        enemyCount = 0;
        isDoll = false;
        timeNumber = 200;
        nextMap();
        bomberman.SetRestart();
    }
}
