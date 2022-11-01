package uet.oop.bomberman.collision;

import uet.oop.bomberman.BombermanGame;
import uet.oop.bomberman.entities.Entity;
import uet.oop.bomberman.entities.mob.Mob;
import uet.oop.bomberman.entities.mob.Player;
import uet.oop.bomberman.entities.mob.enemy.Balloom;
import uet.oop.bomberman.entities.mob.enemy.Enemy;
import uet.oop.bomberman.entities.mob.enemy.Oneal;
import uet.oop.bomberman.entities.notmoving.Portal;
import uet.oop.bomberman.graphics.Sprite;
import uet.oop.bomberman.handlelevel.Handle;
import uet.oop.bomberman.item.ItemBomb;
import uet.oop.bomberman.item.ItemSpeed;
import uet.oop.bomberman.item.ItemUp;
import uet.oop.bomberman.tile.TileManage;

import static uet.oop.bomberman.BombermanGame.*;
import static uet.oop.bomberman.entities.mob.Player.speed;
import static uet.oop.bomberman.graphics.Sprite.SCALED_SIZE;


public class CollisionChecker {

    // constructor
    public CollisionChecker() {
    }

    // TODO: check va chạm với item
    public void collisionItem(Player p) {
        for (Entity e : BombermanGame.stillObjects) {
            if (e instanceof ItemUp) {
                if (p.getMaxX() > e.getX() + 12 && p.getMaxX() < e.getMaxX() - 1
                        && p.getY() > e.getY()  && p.getY() < e.getMaxY() - 5
                        || p.getMaxX() > e.getX() + 12 && p.getMaxX() < e.getMaxX() - 1
                        && p.getMaxY() > e.getY() + 5 && p.getMaxY() < e.getMaxY()) {
                    ((ItemUp) e).remove();
                    return;
                }
                if (p.getX() > e.getX() - 1 && p.getX() < e.getMaxX() - 1
                        && p.getY() > e.getY()  && p.getY() < e.getMaxY() - 5
                        || p.getX() > e.getX() && p.getX() < e.getMaxX() - 1
                        && p.getMaxY() > e.getY() + 5  && p.getMaxY() < e.getMaxY() + 1) {
                    ((ItemUp) e).remove();
                    return;
                }
            }
        }
    }

    public boolean collisionPlayer(Player player) {
        int entityLeftWorldX = player.x + player.solidArea.x;
        int entityRightWorldX = player.x + player.solidArea.x + player.solidArea.width;
        int entityTopWorldY = player.y + player.solidArea.y;
        int entityBottomWorldY = player.y + player.solidArea.y + player.solidArea.height;


        int entityLeftCol = entityLeftWorldX / Sprite.SCALED_SIZE; //
        int entityRightCol = entityRightWorldX / Sprite.SCALED_SIZE;
        int entityTopRow = entityTopWorldY / Sprite.SCALED_SIZE; // = 5
        int entityBottomRow = entityBottomWorldY / Sprite.SCALED_SIZE;

        int tileNum1;
        int tileNum2;

        switch (player.direction) {
            case "up":
                entityTopRow = (entityTopWorldY - player.speed) / Sprite.SCALED_SIZE;
                tileNum1 = Handle.matrixTile[entityTopRow][entityLeftCol];
                tileNum2 = Handle.matrixTile[entityTopRow][entityRightCol];
                collisionItem(player);

                if (TileManage.tile[tileNum1].collision || TileManage.tile[tileNum2].collision) {
                    return true;
                }
                if (TileManage.tile[tileNum1].levelUp || TileManage.tile[tileNum2].levelUp) {
                    if (!isDoll && enemyCount != 0) {
                        return true;
                    } else {
                        nextMap();
                        return false;
                    }
                }
                break;
            case "down":
                entityBottomRow = (entityBottomWorldY + player.speed) / Sprite.SCALED_SIZE;
                tileNum1 = Handle.matrixTile[entityBottomRow][entityLeftCol]; // matrixTile[5][5]
                tileNum2 = Handle.matrixTile[entityBottomRow][entityRightCol];
                collisionItem(player);
                if (TileManage.tile[tileNum1].collision || TileManage.tile[tileNum2].collision) {
                    return true;
                }
                if (TileManage.tile[tileNum1].levelUp || TileManage.tile[tileNum2].levelUp) {
                    if (!isDoll && enemyCount != 0) {
                        return true;
                    } else {
                        nextMap();
                        return false;
                    }
                }
                break;
            case "right":
                entityRightCol = (entityRightWorldX + player.speed) / Sprite.SCALED_SIZE;
                tileNum1 = Handle.matrixTile[entityTopRow][entityRightCol]; // matrixTile[5][5]
                tileNum2 = Handle.matrixTile[entityBottomRow][entityRightCol];
                collisionItem(player);

                if (TileManage.tile[tileNum1].collision || TileManage.tile[tileNum2].collision) {
                    return true;
                }
                if (TileManage.tile[tileNum1].levelUp || TileManage.tile[tileNum2].levelUp) {
                    if (!isDoll && enemyCount != 0) {
                        return true;
                    } else {
                        nextMap();
                        return false;
                    }
                }
                break;
            case "left":
                entityLeftCol = (entityLeftWorldX - player.speed) / Sprite.SCALED_SIZE;
                tileNum1 = Handle.matrixTile[entityTopRow][entityLeftCol]; // matrixTile[5][5]
                tileNum2 = Handle.matrixTile[entityBottomRow][entityLeftCol];
                collisionItem(player);
                //collisionEnemy(player);

                if (TileManage.tile[tileNum1].collision || TileManage.tile[tileNum2].collision) {
                    return true;
                }
                if (TileManage.tile[tileNum1].levelUp || TileManage.tile[tileNum2].levelUp) {
                    if (!isDoll && enemyCount != 0) {
                        return true;
                    } else {
                        nextMap();
                        return false;
                    }
                }
                break;
        }
        return false;
    }
}


