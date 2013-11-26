import java.awt.*;
import java.applet.*;
import java.awt.event.*;

import java.util.Random;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.*;
import java.applet.*;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

class CardPanel {
	
	private int length, x, y, width;
	private Image image;
	private boolean dealer, turn;
	private Graphics g;
	private Hand h;
	private Dimension appletSize;

	public CardPanel(int x, int y, int length, int width, Hand h, boolean dealer, boolean turn, Image image, Graphics g, Dimension appletSize) {
		this.x = x;
		this.y = y;
		this.length = length;
		this.width = width;
		this.dealer = dealer;
		this.turn = turn;
		this.g = g;
		this.image = image;
		this.h = h;
		this.appletSize = appletSize;
	}

	public void setHand(Hand h) {
		this.h = h;
	}

	//Draws panels based on screen size
	public void draw() {
		for (int i = 0; i <= h.cardsInHand(); i++) {
			if (dealer) {
				if (turn) {
					g.drawImage(image, (appletSize.width / 2) - (x * 3), appletSize.height/2 - (int)(appletSize.height * 0.05), 100, 140, null);
					g.drawImage(h.card(1).image(), (appletSize.width / 2)  - (x * 3) + ((200/h.cardsInHand())) - 100, appletSize.height/2 - (int)(appletSize.height * 0.05), 100, 140, null);
				} else {
					g.drawImage(h.card(i).image(), (i * (200/(h.cardsInHand()+ 1))) + (appletSize.width / 2)  - (x * 3), appletSize.height/2 - (int)(appletSize.height * 0.05), 100, 140, null);
				}
			} else {
				g.drawImage(h.card(i).image(), (i * (200/(h.cardsInHand()+ 1))) + (appletSize.width / 2)  - (x * 3), appletSize.height/2 - (int)(appletSize.height * 0.25), 100, 140, null);
			}
		}
	}

}