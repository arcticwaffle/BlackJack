import java.awt.*;
import java.applet.*;
import java.awt.event.*;

import java.util.Random;

import javax.swing.*;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import java.util.Scanner;

public class Game extends Applet implements ActionListener {

	private Deck d = new Deck();
	private Player h = new Player(d, 10, 20);
	private Hand hC = new Hand(d);
	private Graphics g;
	private String score1, score2, result;
	private JButton hit, stay, restart, bank, increase, decrease, dd, ban;
	// private Image[] playerCards = new Image[11];
	// private Image[] computerCards = new Image[11];
	private Image backside;
	private boolean playerTurn = true;
	private CardPanel player;
	private CardPanel comp;
	private Scanner reader = new Scanner(System.in);
	private Dimension appletSize;
	private int pot = 0;
	private int bet, netWorth;
	private GridLayout layout = new GridLayout(2,4); 
	
	public void init() {
		if (h.netWorth() >= h.bet()) {
			pot += h.bet();
			h.placeBet();	
		}

		//GUI
		layout.setHgap(0);
		layout.setVgap(550);
		this.setLayout(layout);

		hit = new JButton("Hit");
		hit.setActionCommand("hit");
		hit.addActionListener(this);
		this.add(hit);

		dd = new JButton("Double Down");
		dd.setActionCommand("dd");
		dd.addActionListener(this);
		this.add(dd);

		stay = new JButton("Stay");
		stay.setActionCommand("stay");
		stay.addActionListener(this);
		this.add(stay);

		restart = new JButton("New Game");
		restart.setActionCommand("restart");
		restart.addActionListener(this);
		this.add(restart);

		increase = new JButton("Increase Bet");
		increase.setActionCommand("add");
		increase.addActionListener(this);
		this.add(increase);

		bank = new JButton("Rob Bank");
		bank.setActionCommand("rob");
		bank.addActionListener(this);
		this.add(bank);

		//Spacing Button
		ban = new JButton("Rob Bank");
		ban.setActionCommand("ro");
		ban.addActionListener(this);
		this.add(ban);
		ban.setVisible(false);

		decrease = new JButton("Decrease Bet");
		decrease.setActionCommand("subtract");
		decrease.addActionListener(this);
		this.add(decrease);

		score1 = "Your Score = " + h.value();
		score2 = "Dealer Score = " + hC.value();
		
		//Setting Up Images
		backside = Game.loadImage("back-blue");
		for (int i = 0; i < h.cardsInHand() + 1; i++) {
			h.card(i).setImage(Game.loadImage(h.card(i).toString()));
		}
		for (int i = 0; i < hC.cardsInHand() + 1; i++) {
			hC.card(i).setImage(Game.loadImage(hC.card(i).toString()));
		}

		if (hC.value() == 21) {
			hC = h.stay(hC, d);
		}
	}

	//GUI
	public void actionPerformed (ActionEvent e) {
		if (playerTurn) {
			if ("stay".equals(e.getActionCommand())) {
				playerTurn = false;
				hC = h.stay(hC, d);
				score1 = "Your Score = " + h.value();
				score2 = "Dealer Score = " + hC.value();
				result = result(h, hC);
				repaint();
			} else if ("hit".equals(e.getActionCommand())) {
				h.hit(d);
				h.card(h.cardsInHand()).setImage(Game.loadImage(h.card(h.cardsInHand()).toString()));
				player.setHand(h);
				player.draw();
				score1 = "Your Score = " + h.value();
				repaint();
			} else if ("dd".equals(e.getActionCommand())) {
				h.doubleDown(d);
				pot += h.bet();
				h.placeBet();
				h.card(h.cardsInHand()).setImage(Game.loadImage(h.card(h.cardsInHand()).toString()));
				player.setHand(h);
				player.draw();
				playerTurn = false;
				hC = h.stay(hC, d);
				score1 = "Your Score = " + h.value();
				score2 = "Dealer Score = " + hC.value();
				result = result(h, hC);
				repaint();
			}
		} else if ("restart".equals(e.getActionCommand())) {
			bet = h.bet();
			netWorth = h.netWorth();
			playerTurn = true;
			d = new Deck();
			h = new Player(d, bet, netWorth);
			hC = new Hand(d);
			if (h.netWorth() >= h.bet()) {
				pot = 0;
				pot += h.bet();
				h.placeBet();	
			}
			score1 = "Your Score = " + h.value();
			score2 = "Dealer Score = " + hC.value();
			for (int i = 0; i < h.cardsInHand() + 1; i++) {
				h.card(i).setImage(Game.loadImage(h.card(i).toString()));
			}
			//this.stay();
			for (int i = 0; i < hC.cardsInHand() + 1; i++) {
				hC.card(i).setImage(Game.loadImage(hC.card(i).toString()));
			}
			repaint();
		}
		if ("rob".equals(e.getActionCommand())) {
			h.funding(100);
			repaint();
		} if ("add".equals(e.getActionCommand())) {
			if (h.bet() < 10) {
				h.setBet(h.bet() + 1);
			} else {
				h.setBet(h.bet() + 10);
			}
			repaint();
		} if ("subtract".equals(e.getActionCommand())) {
			if (h.bet() <= 10) {
				h.setBet(h.bet() - 1);
			} else {
				h.setBet(h.bet() - 10);
			}
			repaint();
		} 
	}

	public void paint(Graphics g) {
		super.paint(g);
		this.g = g;	
		appletSize = this.getSize();
		//GUI: Setting up when buttons are visible and invisible
		if (h.netWorth() < h.bet() && h.netWorth() <= 10) {
			restart.setVisible(false);
			bank.setVisible(true);
		} else {
			bank.setVisible(false);
			if (h.netWorth() < h.bet()) {
				restart.setVisible(false);
			} else {
				restart.setVisible(true);
			}
		}
		if (h.netWorth() >= pot) {
			dd.setVisible(true);
		} else {
			dd.setVisible(false);
		}
		if (h.cardsInHand() == 10) {
			hit.setVisible(false);
		} else {
			hit.setVisible(true);
		}
		g.setFont(new Font("Serif", Font.BOLD, 16));
		g.drawString(score1, appletSize.width/2 - ((int)(appletSize.width * 0.2)), appletSize.height/2 - ((int)(appletSize.width * 0.1)));
		g.drawString("Next Bet = " + h.bet(), appletSize.width/2 - ((int)(appletSize.width * 0.05)), appletSize.height/2 + ((int)(appletSize.width * 0.16)));
		g.drawString("Net Worth = " + h.netWorth(), appletSize.width/2 - ((int)(appletSize.width * 0.05)), appletSize.height/2 + ((int)(appletSize.width * 0.18)));
		if (!playerTurn) {
			g.drawString(score2, appletSize.width/2 - ((int)(appletSize.width * 0.2)), appletSize.height/2 + ((int)(appletSize.width * 0.05)));
			g.setFont(new Font("Serif", Font.BOLD, 22));
			g.drawString(result, appletSize.width/2 - ((int)(appletSize.width * 0.05)), appletSize.height/2 + ((int)(appletSize.width * 0.13)));
		}

		//Drawing Card Panels for player and dealer
		for (int i = 0; i < h.cardsInHand() + 1; i ++) {
			player = new CardPanel(50, 50, 600, 160, h, false, playerTurn, backside, g, appletSize);
			player.draw();
		}
		for (int i = 0; i < hC.cardsInHand() + 1; i ++) {
			comp = new CardPanel(50, 300, 600, 160, hC, true, playerTurn, backside, g, appletSize);
			comp.draw();
		}
	}

	public static Image loadImage(String name) {
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

	public String result(Player h, Hand hC) {
		if (hC.value() > 21 && h.value() > 21) {
			h.funding(pot);
			result = "You Tie";
		} else if (hC.value() > 21) {
			h.funding(pot * 2);
			result = "You Win";
		} else if (h.value() > 21) {
			result = "You Suck";
		} else if (hC.value() > h.value()) {
			result = "You Suck";
		} else if (hC.value() < h.value()) {
			h.funding(pot * 2);
			result = "You Win";
		} else {
			h.funding(pot);
			result = "You Tie";
		}
		return result;
	}

}