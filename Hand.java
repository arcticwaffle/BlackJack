//Hand class acts as dealer class and parent class for player
public class Hand {
	
	private Card[] hand = new Card[11];
	private int cardsInHand;
	private int totalValue;

	public Hand(Deck d) {
		d.shuffle();
		this.hand[0] = d.deal();
		this.hand[1] = d.deal();
		this.cardsInHand = 1;
		totalValue = this.hand[0].value() + this.hand[1].value();
		this.reduce();
	}

	public Card card(int index) {
		if (index <= cardsInHand) {
			return hand[index];
		} else {
			return null;       
		}
	}

	public int value() {
		return totalValue;
	} 

	public int cardsInHand() {
		return cardsInHand;
	}

	
	public void hit(Deck d) {
		this.cardsInHand++;
		this.hand[this.cardsInHand] = d.deal();
		//System.out.println(this.hand[this.cardsInHand].toString());
		this.totalValue += this.hand[this.cardsInHand].value();
		this.reduce();
	}

	//The code that finds and reduces the value of ace to one if necessary
	public void reduce() {
		if (this.totalValue > 21) {
			for (int i = 0; i < this.cardsInHand; i++) {
				//System.out.println(this.hand[i].toString() + i);
				this.hand[i].reduce();
			}
		}
		this.totalValue = 0;
		for (int i = 0; i <= this.cardsInHand; i++) {
			this.totalValue += this.hand[i].value();
		}
	}

	//Debugging purposes
	
	// public void print() {
	// 	for (int i = 0; i < cardsInHand; i++) {
	// 		if (this.hand[i].suit() == 1) {
	// 			System.out.println(this.hand[i].number() + " of hearts ");
	// 		} else if (this.hand[i].suit() == 2) {
	// 			System.out.println(this.hand[i].number() + " of spades ");
	// 		} else if (this.hand[i].suit() == 3) {
	// 			System.out.println(this.hand[i].number() + " of diamonds ");
	// 		} else {
	// 			System.out.println(this.hand[i].number() + " of clubs ");
	// 		}
			
	// 	}
	// 	System.out.println(totalValue);
	// }

}