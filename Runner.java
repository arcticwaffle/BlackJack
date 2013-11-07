import java.awt.*;
import java.applet.*;

public class Runner extends Applet {

	private Game game;

	public void init() {
		game = new Game();
	}

	public void paint(Graphics g) {
		game.draw(g);
	}

}