import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.Image;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Game {

	private Deck d = new Deck();
	private Hand h = new Hand(d);
	private Image[] playerCards = new Image[11];
	private Image deck;
	
	public Game() {
		for (int i = 0; i < 2; i++) {
			if (h.card(i).number() < 11 && h.card(i).number() > 1) {
				if (h.card(i).suit() == 1) {
					playerCards[i] = Game.loadImage(new String(Integer.toString(h.card(i).number()) + "Hearts"));
				} else if (h.card(i).suit() == 2) {
					playerCards[i] = Game.loadImage(new String(Integer.toString(h.card(i).number()) + "Spades"));
				} else if (h.card(i).suit() == 3) {
					playerCards[i] = Game.loadImage(new String(Integer.toString(h.card(i).number()) + "Diamonds"));
				} else {
					playerCards[i] = Game.loadImage(new String(Integer.toString(h.card(i).number()) + "Clubs"));
				}
			} else if (h.card(i).number() == 11) {
				if (h.card(i).suit() == 1) {
					playerCards[i] = Game.loadImage(new String("JHearts"));
				} else if (h.card(i).suit() == 2) {
					playerCards[i] = Game.loadImage(new String("JSpades"));
				} else if (h.card(i).suit() == 3) {
					playerCards[i] = Game.loadImage(new String("JDiamonds"));
				} else {
					playerCards[i] = Game.loadImage(new String("JClubs"));
				}
			} else if (h.card(i).number() == 12) {
				if (h.card(i).suit() == 1) {
					playerCards[i] = Game.loadImage(new String("QHearts"));
				} else if (h.card(i).suit() == 2) {
					playerCards[i] = Game.loadImage(new String("QSpades"));
				} else if (h.card(i).suit() == 3) {
					playerCards[i] = Game.loadImage(new String("QDiamonds"));
				} else {
					playerCards[i] = Game.loadImage(new String("QClubs"));
				}
			} else if (h.card(i).number() == 13) {
				if (h.card(i).suit() == 1) {
					playerCards[i] = Game.loadImage(new String("KHearts"));
				} else if (h.card(i).suit() == 2) {
					playerCards[i] = Game.loadImage(new String("KSpades"));
				} else if (h.card(i).suit() == 3) {
					playerCards[i] = Game.loadImage(new String("KDiamonds"));
				} else {
					playerCards[i] = Game.loadImage(new String("KClubs"));
				}
			} else {
				if (h.card(i).suit() == 1) {
					playerCards[i] = Game.loadImage(new String("AHearts"));
				} else if (h.card(i).suit() == 2) {
					playerCards[i] = Game.loadImage(new String("ASpades"));
				} else if (h.card(i).suit() == 3) {
					playerCards[i] = Game.loadImage(new String("ADiamonds"));
				} else {
					playerCards[i] = Game.loadImage(new String("AClubs"));
				}
			}
		}
	}

	public Image sortImage(Card card) {
		for (int i = 0; i < 2; i++) {
			if (h.card(i).number() < 11 && h.card(i).number() > 1) {
				if (h.card(i).suit() == 1) {
					playerCards[i] = Game.loadImage(new String(Integer.toString(h.card(i).number()) + "Hearts"));
				} else if (h.card(i).suit() == 2) {
					playerCards[i] = Game.loadImage(new String(Integer.toString(h.card(i).number()) + "Spades"));
				} else if (h.card(i).suit() == 3) {
					playerCards[i] = Game.loadImage(new String(Integer.toString(h.card(i).number()) + "Diamonds"));
				} else {
					playerCards[i] = Game.loadImage(new String(Integer.toString(h.card(i).number()) + "Clubs"));
				}
			} else if (h.card(i).number() == 11) {
				if (h.card(i).suit() == 1) {
					playerCards[i] = Game.loadImage(new String("JHearts"));
				} else if (h.card(i).suit() == 2) {
					playerCards[i] = Game.loadImage(new String("JSpades"));
				} else if (h.card(i).suit() == 3) {
					playerCards[i] = Game.loadImage(new String("JDiamonds"));
				} else {
					playerCards[i] = Game.loadImage(new String("JClubs"));
				}
			} else if (h.card(i).number() == 12) {
				if (h.card(i).suit() == 1) {
					playerCards[i] = Game.loadImage(new String("QHearts"));
				} else if (h.card(i).suit() == 2) {
					playerCards[i] = Game.loadImage(new String("QSpades"));
				} else if (h.card(i).suit() == 3) {
					playerCards[i] = Game.loadImage(new String("QDiamonds"));
				} else {
					playerCards[i] = Game.loadImage(new String("QClubs"));
				}
			} else if (h.card(i).number() == 13) {
				if (h.card(i).suit() == 1) {
					playerCards[i] = Game.loadImage(new String("KHearts"));
				} else if (h.card(i).suit() == 2) {
					playerCards[i] = Game.loadImage(new String("KSpades"));
				} else if (h.card(i).suit() == 3) {
					playerCards[i] = Game.loadImage(new String("KDiamonds"));
				} else {
					playerCards[i] = Game.loadImage(new String("KClubs"));
				}
			} else {
				if (h.card(i).suit() == 1) {
					playerCards[i] = Game.loadImage(new String("AHearts"));
				} else if (h.card(i).suit() == 2) {
					playerCards[i] = Game.loadImage(new String("ASpades"));
				} else if (h.card(i).suit() == 3) {
					playerCards[i] = Game.loadImage(new String("ADiamonds"));
				} else {
					playerCards[i] = Game.loadImage(new String("AClubs"));
				}
			}
		}
	}

	public void draw(Graphics g) {
		g.drawImage(image, r.x, r.y, r.width, r.height, null);
	}

	private static Image loadImage(String name) {
		String path = null;
		Image image = null;

		try {
			path = "images" + File.separator + name + ".jpg";
			image = ImageIO.read(new File(path));
		} catch(IOException e){
			System.out.println("Could not load image at path: " + path);
			System.exit(1);
		}

		return image;
	}

}