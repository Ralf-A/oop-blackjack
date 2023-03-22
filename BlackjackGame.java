import java.util.ArrayList;
import java.util.Scanner;

public class BlackjackGame {
    private Deck deck;
    private Dealer dealer;
    private ArrayList<Player> players;
    private Scanner scanner;

    public BlackjackGame(int numPlayers) {
        deck = new Deck();
        dealer = new Dealer();
        players = new ArrayList<>();
        scanner = new Scanner(System.in);

        // Add the specified number of players to the game
        for (int i = 0; i < numPlayers; i++) {
            System.out.print("Enter name for player " + (i+1) + ": ");
            String name = scanner.nextLine();
            players.add(new Player(name, null, null));
        }
    }

    public void startGame() {
        // Shuffle the deck and deal two cards to each player and the dealer
        deck.shuffle();
        for (Player player : players) {
            // Add two cards for every player
        }

        // Add two cards to dealer

        // Display the initial hands
        for (Player player : players) {
            System.out.println(player.getName() + "'s hand: " + player.getHand());
        }
        System.out.println("Dealer's hand: " + dealer.getHand);

    }
}
