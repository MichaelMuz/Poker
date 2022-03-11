public class Game {

	DeckOfCards gameDeck;

	Player p1;

	Player p2;

	public Game() {

		gameDeck = new DeckOfCards();

		gameDeck.shuffle();

		p1 = new Player();

		p2 = new Player();

		deal();
		// with deal is how the game should be played but may be commented out for testing
		
		
		//riggedFlush(p1);
		//riggedStraight(p2);
		
		

	}

	public void play() {

		p1.getTotalHandValue();

		p2.getTotalHandValue();

		System.out.println("Player 1's hand : " + p1);

		System.out.println("Player 2's hand : " + p2);

		if (p1.getTotalHandValue() > p2.getTotalHandValue()) {

			System.out.println("p1 wins");

		}

		else if (p2.getTotalHandValue() > p1.getTotalHandValue()) {

			System.out.println("p2 wins");

		}

		else if (p2.getTotalHandValue() == p1.getTotalHandValue()) {

			System.out.println("its a tie");

		}

		//System.out.println("p1: " + p1.getTotalHandValue());

		//System.out.println("p2: " + p2.getTotalHandValue());

	}

	public void deal() {

		for (int i = 0; i < 5; i++) {

			p1.addCard(gameDeck.dealCard());

			p2.addCard(gameDeck.dealCard());

		}

	}
	
	public void riggedFlush(Player p) {
		//String suits[] = { "Hearts", "Diamonds", "Clubs", "Spades"};
		//static private String [] allValues = {"Deuce", "Three", "Four", "Five", "Six", "Seven", 
        //"Eight", "Nine", "Ten", "Jack", "Queen", "King", "Ace"}; 



			p.addCard(new Card("Deuce", "Hearts"));
			p.addCard(new Card("Ace", "Hearts"));
			p.addCard(new Card("Five", "Hearts"));
			p.addCard(new Card("Seven", "Hearts"));
			p.addCard(new Card("Nine", "Hearts"));
			

			

	
	}
	
	public void riggedStraight(Player p) {
		p.addCard(new Card("Ten", "Clubs"));
		p.addCard(new Card("Jack", "Diamonds"));
		p.addCard(new Card("Queen", "Hearts"));
		p.addCard(new Card("King", "Hearts"));
		p.addCard(new Card("Ace", "Spades"));
	}
	
	public void riggedThreeOfAKind(Player p) {
		p.addCard(new Card("Ten", "Clubs"));
		p.addCard(new Card("Jack", "Diamonds"));
		p.addCard(new Card("Ten", "Hearts"));
		p.addCard(new Card("King", "Hearts"));
		p.addCard(new Card("Ten", "Spades"));
	}
	
	public void riggedTwoPair(Player p) {
		p.addCard(new Card("Ten", "Clubs"));
		p.addCard(new Card("Eight", "Diamonds"));
		p.addCard(new Card("Eight", "Hearts"));
		p.addCard(new Card("King", "Hearts"));
		p.addCard(new Card("Ten", "Spades"));
	}
	
	public void riggedPair(Player p) {
		p.addCard(new Card("Ten", "Clubs"));
		p.addCard(new Card("Jack", "Diamonds"));
		p.addCard(new Card("Ten", "Hearts"));
		p.addCard(new Card("King", "Hearts"));
		p.addCard(new Card("Eight", "Spades"));
	}
	
	public void riggedHighCard(Player p) {
		p.addCard(new Card("Ten", "Clubs"));
		p.addCard(new Card("Jack", "Diamonds"));
		p.addCard(new Card("Deuce", "Hearts"));
		p.addCard(new Card("King", "Hearts"));
		p.addCard(new Card("Three", "Spades"));
	}
	
	public void riggedHighCard2(Player p) {
		p.addCard(new Card("Ten", "Clubs"));
		p.addCard(new Card("Jack", "Diamonds"));
		p.addCard(new Card("Deuce", "Hearts"));
		p.addCard(new Card("Ace", "Hearts"));
		p.addCard(new Card("Three", "Spades"));
	}
	

}
