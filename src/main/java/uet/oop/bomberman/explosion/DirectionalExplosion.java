package uet.oop.bomberman.explosion;

import javafx.scene.canvas.GraphicsContext;
import uet.oop.bomberman.BombermanGame;
import uet.oop.bomberman.entities.Entity;
import uet.oop.bomberman.entities.mob.Mob;
import uet.oop.bomberman.entities.notmoving.Brick;
import uet.oop.bomberman.entities.notmoving.Wall;
import uet.oop.bomberman.graphics.Sprite;

public class DirectionalExplosion extends Entity {

    protected int _direction;
    private int _radius;
    protected int xOrigin, yOrigin;
    protected Explosion[] _explosions;

    public DirectionalExplosion(int x, int y, int direction, int radius) {
        xOrigin = x;
        yOrigin = y;
        this.x = x;
        this.y = y;
        _direction = direction;
        _radius = radius;

        _explosions = new Explosion[ calculatePermitedDistance() ];
        createExplosions();
    }

    private void createExplosions() {
        boolean last = false;

        int x = this.x / 48;
        int y = this.y / 48;
        for (int i = 0; i < _explosions.length; i++) {
            last = i == _explosions.length -1 ? true : false;

            switch (_direction) {
                case 0: y --; break;
                case 1: x ++; break;
                case 2: y ++; break;
                case 3: x --; break;
            }
            _explosions[i] = new Explosion(x, y, _direction, last);
        }
    }

    private int calculatePermitedDistance() {
        int radius = 0;
        int x = this.x / 48;
        int y = this.y / 48;
        while(radius < _radius) {
            if(_direction == 0) y --;
            if(_direction == 1) x ++;
            if(_direction == 2) y ++;
            if(_direction == 3) x --;

            Entity entity = BombermanGame.getEntity(x * Sprite.SCALED_SIZE,y * Sprite.SCALED_SIZE);
            if(entity instanceof Brick) {
                ((Brick) entity).setDestroyed(true);
                radius++;
                break;
            }
            if (entity instanceof Wall) {
                break;
            }
            radius++;
        }
        return radius;
    }

    @Override
    public void update() {

    }

    @Override
    public void render(GraphicsContext gc) {

        for (int i = 0; i < _explosions.length; i++) {
            _explosions[i].render(gc);
        }
        gc.drawImage(img,x,y);
    }

    public Explosion[] getExplosions() {
        return _explosions;
    }
}
