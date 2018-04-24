package game;

import java.util.HashSet;
import java.util.Set;

public class Player {
	
	private String name;
	private Set<Card> cards;
	
	public Player(String name) {
		this.name = name;
		cards = new HashSet<Card>();
	}
	
	public Set<Card> getCards() {
		return cards;
	}
	
	public void addCard(Card card) {
		cards.add(card);
	}
	
	public String toString() {
		return name;
	}
}
