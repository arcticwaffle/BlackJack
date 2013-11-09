import java.awt.*;
import java.applet.*;
import java.awt.event.*;

import java.util.Random;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Game extends Applet/* implements ActionListener*/ {

	private Deck d = new Deck();
	private JPanel buttonPanel;
	private Hand h = new Hand(d);
	private Hand hC = new Hand(d);
	private Image[] playerCards = new Image[11];
	private Image[] computerCards = new Image[11];
	private Image deck;
	
	public void init() {
		// buttonPanel.setLayout(new FlowLayout());

		// JButton button = new JButton("Hit");
		// button.addActionListener(this);
		// button.setActionCommand("Hit");
		// button.setPreferredSize(new Dimension(50, 15));
		// buttonPanel.add(button);

		//this.setLayout(new GridLayout(1,1));
		//this.add(buttonPanel);
		for (int i = 0; i < h.cardsInHand() + 1; i++) {
			playerCards[i] = Game.loadImage(h.card(i).toString());
		}
		this.stay();
		for (int i = 0; i < hC.cardsInHand() + 1; i++) {
			computerCards[i] = Game.loadImage(hC.card(i).toString());
		}
		System.out.println(hC.value());
	}

	// public void actionPreformed (ActionEvent e) {
	// 	if ("Hit".equals(e.getActionCommand())) {
	// 		h.hit(d);
	// 		playerCards[h.cardsInHand()] = Game.loadImage(h.card(h.cardsInHand()).toString());
	// 	}
	// }

	public void paint(Graphics g) {
		for (int i = 0; i < h.cardsInHand() + 1; i ++) {
			g.drawImage(playerCards[i], (i * 120) + 50, 50, 100, 140, null);
		}
		for (int i = 0; i < hC.cardsInHand() + 1; i ++) {
			g.drawImage(computerCards[i], (i * 120) + 50, 300, 100, 140, null);
		}
	}

	public void stay () {
		int t = 0;
		while (hC.value() < 17) {
			hC.hit(d);
			computerCards[hC.cardsInHand()] = Game.loadImage(hC.card(hC.cardsInHand()).toString());
			t++;
			if (t > 100) {
				System.out.println("Infinite Loop");
				System.exit(1);
			}
		}
	}

	private static Image loadImage(String name) {
		String path = null;
		Image image = null;

		try {
			path = "cards" + File.separator + name + ".png";
			image = ImageIO.read(new File(path));
		} catch(IOException e){
			System.out.println("Could not load image at path: " + path);
			System.exit(1);
		}

		return image;
	}

}