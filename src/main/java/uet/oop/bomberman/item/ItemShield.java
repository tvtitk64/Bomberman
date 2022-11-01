package uet.oop.bomberman.item;

import javafx.scene.image.Image;
import uet.oop.bomberman.BombermanGame;
import uet.oop.bomberman.audio.Audio;
import uet.oop.bomberman.graphics.Sprite;
import uet.oop.bomberman.handlelevel.Handle;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

import static uet.oop.bomberman.BombermanGame.timeShield;

public class ItemShield extends ItemUp {

    private Audio audio = new Audio();
    public ItemShield(int x, int y, Image img) {
        super(x, y, img);
    }

    @Override
    public void remove() {
        timeShield += 30;
        Handle.matrixTile[y / Sprite.SCALED_SIZE][x / Sprite.SCALED_SIZE] = 2;
        System.out.println("itemShield");
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
}
