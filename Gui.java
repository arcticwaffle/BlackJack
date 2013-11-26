import java.awt.*;
import java.applet.*;
import java.awt.event.*;

import java.util.Random;

import javax.swing.*;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import java.util.Scanner;

class Gui extends JPanel implements ActionListener {
	
	
	private Hand h;
	private Hand hC;
	private CardPanel player;
	private Deck d;
	private Boolean playerTurn;

	public Gui(Hand h, Hand hC, CardPanel player, Deck d, Boolean playerTurn) {
		super();

		this.h = h;
		this.hC = hC;
		this.player = player;
		this.d = d;
		this.playerTurn = playerTurn;

		
	}

	public void update(Hand h, Hand hC, CardPanel player, Deck d, Boolean playerTurn) {
		this.h = h;
		this.hC = hC;
		this.player = player;
		this.d = d;
		this.playerTurn = playerTurn;
	}

	public void setScore(int score, boolean one) {
		
	}

	public void actionPerformed(ActionEvent e) {
		
	}

}