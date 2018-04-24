package game;

import java.util.ArrayList;
import java.util.List;

import game.Card.Rank;
import game.Card.Suit;
import game.Card.SuitColor;

public class Game {

	private List<Card> deck;
	private List<Player> players;

	public static void main(String[] args) {
		new Game();
	}

	public Game() {
		deck = new ArrayList<Card>();
		players = new ArrayList<Player>();
		initCards();

		// hard code
		Player p0 = new Player("Sytze");
		Player p1 = new Player("Tijmen");
		players.add(p0);
		players.add(p1);

		assignCards();

		
	}

	public void initCards() {
		for (Suit suit : Suit.values()) {
			for (Rank rank : Rank.values()) {
				Card card = new Card(suit, rank);
				deck.add(card);
			}
		}
		for (SuitColor suitColor : SuitColor.values()) {
			Card card = new Card(suitColor);
			deck.add(card);
		}
	}

	public void assignCards() {
		for (int i = 0; i < 7; i++) {
			for (Player player : players) {
				int randomIndex = randomIndex();
				player.addCard(deck.get(randomIndex));
				deck.remove(randomIndex);
			}
		}
	}

	private int randomIndex() {
		return (int) Math.floor(Math.random() * deck.size());
	}
}
