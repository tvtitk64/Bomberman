package uet.oop.bomberman.item;

import javafx.scene.image.Image;
import uet.oop.bomberman.BombermanGame;
import uet.oop.bomberman.audio.Audio;
import uet.oop.bomberman.graphics.Sprite;
import uet.oop.bomberman.handlelevel.Handle;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

public class ItemBomb extends ItemUp {

    private Audio audio = new Audio();
    public ItemBomb(int x, int y, Image img) {
        super(x,y,img);
    }

    @Override
    public void remove() {
        Handle.matrixTile[y / Sprite.SCALED_SIZE][x / Sprite.SCALED_SIZE] = 2;
        if (BombermanGame.maxBomb < 3) BombermanGame.maxBomb++;
        System.out.println("itemBomb");
        try {
            audio.audioUpdate("res/sound/power_up.wav",0);
        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        }
        BombermanGame.stillObjects.remove(this);
    }

    @Override
    public void update() {

    }
}
