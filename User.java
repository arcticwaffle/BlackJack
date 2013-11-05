class User {
	
	private int score;
	private int bet;
	private Deck deck = new Deck();
	private int netWorth;

	public User(int bet) {
		setScore(0);
		setBet(bet);
	}

	public int score() {
		return this.score;
	}

	public int bet() {
		return this.bet;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public void setBet(int bet) {
		if (bet > 0) {
			this.bet = bet;
		}
	}

	public void hit() {
		score += deck.deal().value();
	}

	public void stay() {

	}

}