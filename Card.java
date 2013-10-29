class Card {
	
	private int number;
	private int suit;

	public Card(int number, int suit) {
		setNumber(number);
		setSuit(suit);
	}

	public int number() {
		return this.numeber;
	}

	public int suit() {
		return this.suit;
	}

	public void setNumber(int number){
		if (number <= 13 && number >= 1) {
			this.number = number;
		}
	}

	public void setSuit(int suit){
		if (suit <= 4 && suit >= 1) {
			this.suit = suit;
		}
	}

}