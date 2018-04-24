package game;

public class Card {
	
	public static enum SuitColor {
		RED, BLACK;
	}
	
	public static enum Suit {
		CLUBS, DIAMONDS, HEARTS, SPADES;
	}
	
	public static enum Rank {
		ACE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING;
	}
	
	private Suit suit;
	private Rank rank;
	private SuitColor suitColor;
	private boolean isJoker;
	
	public Card(Suit suit, Rank rank) {
		this.suit = suit;
		this.rank = rank;
		
		if (suit == Suit.CLUBS || suit == Suit.SPADES) {
			suitColor = SuitColor.BLACK;
		} else if (suit == Suit.DIAMONDS || suit == Suit.HEARTS) {
			suitColor = SuitColor.RED;
		}
	}
	
	public Card(SuitColor suitColor) {
		this.suitColor = suitColor;
		isJoker = true;
	}
	
	public Suit getSuit() {
		return suit;
	}
	
	public Rank getRank() {
		return rank;
	}
	
	public SuitColor getSuitColor() {
		return suitColor;
	}
	
	public boolean isJoker() {
		return isJoker;
	}
	
	public String toString() {
		if (!isJoker) {
			return String.format("%s %s", rank, suit);
		} else {
			return String.format("%s %s", suitColor, "JOKER");
		}
	}
}
