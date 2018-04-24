package game;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import game.Card.Rank;
import game.Card.Suit;
import game.Card.SuitColor;

public class Game {

	private List<Card> deck;
	private List<Player> players;
	
	private Player currentPlayer;
	private int currentPlayerIndex;

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
		start();
		keyInputHandler();
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
	
	private void start() {
		
	}
	
	private void keyInputHandler() {
		try (Scanner in = new Scanner(System.in)) {
			String answer = in.hasNextLine() ? in.nextLine() : null;
			if (answer != null) {
				nextPlayer();
				System.out.println(currentPlayer + ": " + currentPlayer.getCards());

				keyInputHandler();
			}
		}
	}
	
	private void nextPlayer() {
		if (currentPlayerIndex >= players.size() - 1) {
			currentPlayerIndex = 0;
		} else {
			currentPlayerIndex++;
		}
		currentPlayer = players.get(currentPlayerIndex);
	}

	private int randomIndex() {
		return (int) Math.floor(Math.random() * deck.size());
	}
}
