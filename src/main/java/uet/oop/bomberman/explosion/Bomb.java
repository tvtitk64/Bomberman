package uet.oop.bomberman.explosion;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import uet.oop.bomberman.BombermanGame;
import uet.oop.bomberman.audio.Audio;
import uet.oop.bomberman.collision.CollisionChecker;
import uet.oop.bomberman.entities.Entity;
import uet.oop.bomberman.entities.mob.Mob;
import uet.oop.bomberman.entities.mob.Player;
import uet.oop.bomberman.entities.mob.enemy.Doll;
import uet.oop.bomberman.entities.mob.enemy.Kondoria;
import uet.oop.bomberman.entities.notmoving.Brick;
import uet.oop.bomberman.entities.notmoving.Grass;
import uet.oop.bomberman.entities.notmoving.Wall;
import uet.oop.bomberman.graphics.Sprite;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

import static uet.oop.bomberman.BombermanGame.*;

public class Bomb extends Entity {
    private int timeExplode = 120;// 3s thì nổ
    private int timeDic = 30;// 3s thì nổ
    public boolean isExploded = false;
    protected DirectionalExplosion[] _explosions = null;
    private Mob mob;
    private Audio audio = new Audio();

    public Bomb(int x, int y, Image img, Mob mob) {
        super(x,y,img);
        this.mob = mob;
    }

    public void setExploded(boolean exploded) {
        isExploded = exploded;
    }

    public void renderExplosions(GraphicsContext gc) {
        for (int i = 0; i < _explosions.length; i++) {
            _explosions[i].render(gc);
        }
    }

    public void createExplostion() {
        if (mob instanceof Kondoria) {
            _explosions = new DirectionalExplosion[4];
            for (int i = 0; i < 4; i++) {
                _explosions[i] = new DirectionalExplosion(x, y, i, 2);
            }
        } else {
            _explosions = new DirectionalExplosion[4];
            for (int i = 0; i < 4; i++) {
                _explosions[i] = new DirectionalExplosion(x, y, i, BombermanGame.bomRadius);
            }
        }

    }

    public void explosiveEffect() {
        for (int i = 0; i < _explosions.length; i++) {
            Explosion[] explosions = _explosions[i].getExplosions();
            explosionMob(explosions);
        }
    }

    public void explosionMob(Explosion[] explosions) {
        if (explosions.length > 0) {
            Explosion bg = explosions[0];
            Explosion end = explosions[explosions.length - 1];
            for (Entity e : entities) {
                if (!isDoll) {
                    if (mob instanceof Kondoria && e instanceof Player) {
                        if (e.getX() > bg.getX() && e.getX() < end.getMaxX()
                                && e.getY() >= bg.getY() && e.getY() < bg.getMaxY()
                                || e.getX() > bg.getX() && e.getX() < end.getMaxX()
                                && e.getMaxY() >= bg.getY() && e.getMaxY() < bg.getMaxY() + 5) {
                            if (((Mob) e).isLife()) {
                                ((Mob) e).kill();
                            }
                        }

                        if (e.getMaxX() - 5 > end.getX() && e.getMaxX() - 5 < bg.getMaxX()
                                && e.getY() >= bg.getY() && e.getY() < bg.getMaxY() - 5
                                || e.getMaxX() - 5 > end.getX() && e.getMaxX() < bg.getMaxX()
                                && e.getMaxY() >= bg.getY() && e.getMaxY() < bg.getMaxY()) {
                            if (((Mob) e).isLife()) {
                                ((Mob) e).kill();
                            }
                        }

                        if (e.getY() < end.getMaxY() - 5 && e.getY() >= bg.getY()
                                && e.getX() > bg.getX() && e.getX() < bg.getMaxX()
                                || e.getY() < end.getMaxY() - 5 && e.getY() >= bg.getY()
                                && e.getMaxX() - 5 < bg.getMaxX() && e.getMaxX() - 5 > bg.getX()) {
                            if (((Mob) e).isLife()) {
                                ((Mob) e).kill();
                            }
                        }

                        if (e.getMaxY() - 5 > end.getY() && e.getMaxY() < bg.getMaxY() + 5
                                && e.getX() >= bg.getX() && e.getX() < bg.getMaxX()
                                || e.getMaxY() - 5 > end.getY() && e.getMaxY() < bg.getMaxY() + 5
                                && e.getMaxX() < bg.getMaxX() && e.getMaxX() > bg.getX()) {
                            if (((Mob) e).isLife()) {
                                ((Mob) e).kill();
                            }
                        }
                    }

                    if (e instanceof Mob && !(e instanceof Doll) && !(mob instanceof Kondoria)) {
                        if (e.getX() > bg.getX() && e.getX() < end.getMaxX()
                                && e.getY() >= bg.getY() && e.getY() < bg.getMaxY()
                                || e.getX() > bg.getX() && e.getX() < end.getMaxX()
                                && e.getMaxY() >= bg.getY() && e.getMaxY() < bg.getMaxY() + 5) {
                            if (((Mob) e).isLife()) {
                                ((Mob) e).kill();
                            }
                        }

                        if (e.getMaxX() - 5 > end.getX() && e.getMaxX() - 5 < bg.getMaxX()
                                && e.getY() >= bg.getY() && e.getY() < bg.getMaxY() - 5
                                || e.getMaxX() - 5 > end.getX() && e.getMaxX() < bg.getMaxX()
                                && e.getMaxY() >= bg.getY() && e.getMaxY() < bg.getMaxY()) {
                            if (((Mob) e).isLife()) {
                                ((Mob) e).kill();
                            }
                        }

                        if (e.getY() < end.getMaxY() - 5 && e.getY() >= bg.getY()
                                && e.getX() > bg.getX() && e.getX() < bg.getMaxX()
                                || e.getY() < end.getMaxY() - 5 && e.getY() >= bg.getY()
                                && e.getMaxX() - 5 < bg.getMaxX() && e.getMaxX() - 5 > bg.getX()) {
                            if (((Mob) e).isLife()) {
                                ((Mob) e).kill();
                            }
                        }

                        if (e.getMaxY() - 5 > end.getY() && e.getMaxY() < bg.getMaxY() + 5
                                && e.getX() >= bg.getX() && e.getX() < bg.getMaxX()
                                || e.getMaxY() - 5 > end.getY() && e.getMaxY() < bg.getMaxY() + 5
                                && e.getMaxX() < bg.getMaxX() && e.getMaxX() > bg.getX()) {
                            if (((Mob) e).isLife()) {
                                ((Mob) e).kill();
                            }
                        }
                    }
                } else {
                    if (e instanceof Mob)
                        if (e.getX() > bg.getX() && e.getX() < end.getMaxX()
                                && e.getY() >= bg.getY() && e.getY() < bg.getMaxY()
                                || e.getX() > bg.getX() && e.getX() < end.getMaxX()
                                && e.getMaxY() >= bg.getY() && e.getMaxY() < bg.getMaxY() + 5) {
                            if (((Mob) e).isLife()) {
                                ((Mob) e).kill();
                            }
                        }

                    if (e.getMaxX() - 5 > end.getX() && e.getMaxX() - 5 < bg.getMaxX()
                            && e.getY() >= bg.getY() && e.getY() < bg.getMaxY() - 5
                            || e.getMaxX() - 5 > end.getX() && e.getMaxX() < bg.getMaxX()
                            && e.getMaxY() >= bg.getY() && e.getMaxY() < bg.getMaxY()) {
                        if (((Mob) e).isLife()) {
                            ((Mob) e).kill();
                        }
                    }

                    if (e.getY() < end.getMaxY() - 5 && e.getY() >= bg.getY()
                            && e.getX() > bg.getX() && e.getX() < bg.getMaxX()
                            || e.getY() < end.getMaxY() - 5 && e.getY() >= bg.getY()
                            && e.getMaxX() - 5 < bg.getMaxX() && e.getMaxX() - 5 > bg.getX()) {
                        if (((Mob) e).isLife()) {
                            ((Mob) e).kill();
                        }
                    }

                    if (e.getMaxY() - 5 > end.getY() && e.getMaxY() < bg.getMaxY() + 5
                            && e.getX() >= bg.getX() && e.getX() < bg.getMaxX()
                            || e.getMaxY() - 5 > end.getY() && e.getMaxY() < bg.getMaxY() + 5
                            && e.getMaxX() < bg.getMaxX() && e.getMaxX() > bg.getX()) {
                        if (((Mob) e).isLife()) {
                            ((Mob) e).kill();
                        }
                    }
                }
            }
        }
    }

    public void exploded() {
        setExploded(true);
        createExplostion();
        explosiveEffect();
    }

    @Override
    public void render(GraphicsContext gc) {
        if (isExploded) {
            img = Sprite.bomb_exploded2.getFxImage();
            if (timeDic > 0) {
                timeDic--;
                renderExplosions(gc);
            } else {
                try {
                    audio.audioUpdate("res/sound/bomb_explosion.wav",0);
                } catch (UnsupportedAudioFileException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (LineUnavailableException e) {
                    e.printStackTrace();
                }
                stillObjects.remove(this);
                bomList.remove(this);
            }
        }
        gc.drawImage(img,x,y);
    }

    @Override
    public void update() {
        if (timeExplode > 0 && !(mob instanceof Kondoria)) {
            switch (timeExplode % 60) {
                case 0: {
                    img = Sprite.bomb.getFxImage();
                    break;
                }
                case 20: {
                    img = Sprite.bomb_1.getFxImage();
                    break;
                }
                case 40: {
                    img = Sprite.bomb_2.getFxImage();
                    break;
                }
            }
            timeExplode--;
        } else {
            exploded();
        }
    }
}
