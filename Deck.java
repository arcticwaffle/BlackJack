import java.util.Random;

class Deck {
	
	private Card blank = new Card();
	//private Card[] cards = new Card[52];
	private Card[] cards = {new Card(), new Card(), new Card(), new Card(), new Card(), new Card(), new Card(), new Card(), new Card(), new Card(), new Card(), new Card(), new Card(), new Card(), new Card(), new Card(), new Card(), new Card(), new Card(), new Card(), new Card(), new Card(), new Card(), new Card(), new Card(), new Card(), new Card(), new Card(), new Card(), new Card(), new Card(), new Card(), new Card(), new Card(), new Card(), new Card(), new Card(), new Card(), new Card(), new Card(), new Card(), new Card(), new Card(), new Card(), new Card(), new Card(), new Card(), new Card(), new Card(), new Card(), new Card(), new Card()};
	private Random r = new Random();
	private int card;

	public Deck() {
		//System.out.println(cards.length);
		// for (int i = 0; i < 52; i++) {
		// 	System.out.println(cards[i]);
		// }
		for (int i = 0; i < cards.length; i++) {
			cards[i].setNumber((i % 13) + 1);
			if (i < 13) {
				cards[i].setSuit(1);
			} else if (i < 26) {
				cards[i].setSuit(2);
			} else if (i < 39) {
				cards[i].setSuit(3);
			} else {
				cards[i].setSuit(4);
			}
			//System.out.println(" " + cards[i].number() + " " + cards[i].suit());
		}
		card = -1;
	}

	public void print() {
		for (int i = 0; i < cards.length; i++) {
			if (cards[i].suit() == 1) {
				System.out.println(cards[i].number() + " of hearts ");
			} else if (cards[i].suit() == 2) {
				System.out.println(cards[i].number() + " of spades ");
			} else if (cards[i].suit() == 3) {
				System.out.println(cards[i].number() + " of diamonds ");
			} else {
				System.out.println(cards[i].number() + " of clubs ");
			}
			
		}
	}

	public void printSimple(){
		for (int i = 0; i < cards.length; i++) {
			System.out.println(" " + cards[i].number() + " " + cards[i].suit());
		}
	}

	public void shuffle() {
		int n;
		Card temp;
		for (int i = 0; i < cards.length; i++) {
			n = r.nextInt(51);
			temp = cards[n];
			cards[n] = cards[i];
			cards[i] = temp;
		}
	}

	public Card deal() {
		card++;
		return cards[card];
	}

	public static void main(String[] args) {
		Deck d1 = new Deck();
		d1.shuffle();
		d1.print();
	}

}