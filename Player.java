class Player extends Hand {
	
	private Deck d;
	private int bet;
	private int netWorth;
	private Hand hC;

	public Player(Deck d, int bet, int netWorth) {
		super(d);
		this.bet = bet;
		this.netWorth = netWorth;
	}

	public void setBet(int bet) {
		if (bet > 0) {
			this.bet = bet;
		}
	}

	public int bet() {
		return bet;
	}

	public void placeBet() {
		this.netWorth -= this.bet;
	}

	public int netWorth() {
		return netWorth;
	}

	public void funding(int n) {
		this.netWorth += n;
	}

	public void doubleDown(Deck d) {
		super.hit(d);
	}

	public Hand stay (Hand hC, Deck d) {
		this.hC = hC;
		int i = 0;
		while (hC.value() < 17) {
			hC.hit(d);
			hC.card(hC.cardsInHand()).setImage(Game.loadImage(hC.card(hC.cardsInHand()).toString()));
			hC.reduce();
			i++;
		}
		return hC;
	}

}