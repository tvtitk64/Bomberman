package uet.oop.bomberman.handlelevel;
import uet.oop.bomberman.graphics.Sprite;

public class Coordinates {
	
	public static int pixelToTile(double i) {
		return (int)(i / Sprite.DEFAULT_SIZE);
	}
}
