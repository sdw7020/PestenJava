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
	
	public String getName() {
		return name;
	}
	
	public Set<Card> getCards() {
		return cards;
	}
	
	public void addCard(Card card) {
		cards.add(card);
	}
}
