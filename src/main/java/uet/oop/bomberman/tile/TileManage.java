package uet.oop.bomberman.tile;

import uet.oop.bomberman.graphics.Sprite;

public class TileManage {
    public static Tile[] tile = new Tile[20];

    public TileManage() {

    }

    public static void createTile() {
        tile[0] = new Tile();
        tile[0].img = Sprite.wall.getFxImage(); // wall = 0
        tile[0].collision = true;

        tile[1] = new Tile();
        tile[1].img = Sprite.brick.getFxImage(); // brick = 1
        tile[1].collision = true;

        tile[2] = new Tile();
        tile[2].img = Sprite.grass.getFxImage(); // grass = 2

        tile[3] = new Tile();
        tile[3].img = Sprite.balloom_left1.getFxImage();

        tile[4] = new Tile();
        tile[4].img = Sprite.oneal_right1.getFxImage();

        tile[5] = new Tile();
        tile[5].img = Sprite.kondoria_right1.getFxImage();

        tile[6] = new Tile();
        tile[6].img = Sprite.powerup_bombs.getFxImage();
        tile[6].item = true;

        tile[8] = new Tile();
        tile[8].img = Sprite.powerup_flamepass.getFxImage();
        tile[8].item = true;


        tile[7] = new Tile();
        tile[7].img = Sprite.powerup_speed.getFxImage();
        tile[7].item = true;


        tile[11] = new Tile();
        tile[11].img = Sprite.powerup_detonator.getFxImage();
        tile[11].item = true;


        tile[10] = new Tile();
        tile[10].img = Sprite.doll_right1.getFxImage();

        tile[9] = new Tile();
        tile[9].img = Sprite.portal.getFxImage();
        tile[9].levelUp = true;
    }
}
