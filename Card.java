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

public class Card {
	
	private int number;
	private int suit;
	private int value;
	private Image image;

	public Card() {
		this.setNumber(1);
		this.setSuit(1);
		this.setValue();
	}

	public int number() {
		return this.number;
	}

	public int suit() {
		return this.suit;
	}

	public void setNumber(int number){
		//if (number <= 13 && number >= 1) {
			this.number = number;
			setValue();
		//}
	}

	public void setSuit(int suit){
		//if (suit <= 4 && suit >= 1) {
			this.suit = suit;
		//}
	}

	public void reduce() {
		if (this.number == 1) {
			this.value = 1;
		}
	}

	public Image image() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}

	public void setValue(){
		if (this.number < 11 && this.number > 1) {
			this.value = this.number;
		} else if (this.number > 10 && this.number <= 13) {
			this.value = 10;
		} else if (this.number == 1) {
			this.value = 11;
		}
	}

	public int value(){
		return this.value;
	}

	//Returns String of card
	public String toString() {
		if (this.number < 11 && this.number > 1) {
			if (this.suit == 1) {
				return this.number + "Hearts";
			} else if (this.suit == 2) {
				return this.number + "Spades";
			} else if (this.suit == 3) {
				return this.number + "Diamonds";
			} else {
				return this.number + "Clubs";
			}
		} else if (this.number == 11) {
			if (this.suit == 1) {
				return "JHearts";
			} else if (this.suit == 2) {
				return "JSpades";
			} else if (this.suit == 3) {
				return "JDiamonds";
			} else {
				return "JClubs";
			}
		} else if (this.number == 12) {
			if (this.suit == 1) {
				return "QHearts";
			} else if (this.suit == 2) {
				return "QSpades";
			} else if (this.suit == 3) {
				return "QDiamonds";
			} else {
				return "QClubs";
			}
		} else if (this.number == 13) {
			if (this.suit == 1) {
				return "KHearts";
			} else if (this.suit == 2) {
				return "KSpades";
			} else if (this.suit == 3) {
				return "KDiamonds";
			} else {
				return "KClubs";
			}
		} else {
			if (this.suit == 1) {
				return "AHearts";
			} else if (this.suit == 2) {
				return "ASpades";
			} else if (this.suit == 3) {
				return "ADiamonds";
			} else {
				return "AClubs";
			}
		}
	}

}