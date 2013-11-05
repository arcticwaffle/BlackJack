class Hand {
	
	private Card[] hand = new Card[11];
	private int cardsInHand;
	private int totalValue;

	public Hand(Deck d) {
		this.hand[0] = d.deal();
		this.hand[1] = d.deal();
		this.cardsInHand = 2;
		totalValue = this.hand[0].value() + this.hand[1].value();
		this.reduce();
	}

	public void hit(Deck d) {
		this.hand[cardsInHand] = d.deal();
		this.totalValue += this.hand[cardsInHand].value();
		cardsInHand++;
		this.reduce();
	}

	public void reduce() {
		if (this.totalValue > 21) {
			for (int i = 0; i < cardsInHand; i++) {
				this.hand[i].reduce();
			}
		}
	}

	public void stay() {

	}

	public void print() {
		for (int i = 0; i < cardsInHand; i++) {
			if (this.hand[i].suit() == 1) {
				System.out.println(this.hand[i].number() + " of hearts ");
			} else if (this.hand[i].suit() == 2) {
				System.out.println(this.hand[i].number() + " of spades ");
			} else if (this.hand[i].suit() == 3) {
				System.out.println(this.hand[i].number() + " of diamonds ");
			} else {
				System.out.println(this.hand[i].number() + " of clubs ");
			}
			
		}
		System.out.println(totalValue);
	}

	public static void main(String[] args) {
		Deck d = new Deck();
		d.shuffle();
		Hand h = new Hand(d);
		h.hit(d);
		h.print();

	}

}