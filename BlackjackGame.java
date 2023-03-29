import java.util.ArrayList;
import java.util.Scanner;

public class BlackjackGame {
    private Deck deck;
    private Dealer dealer;
    private ArrayList<Player> players;
    private Scanner scanner;
    private int aceCount = 0;

    public BlackjackGame() {
        deck = new Deck();
        players = new ArrayList<>();
    }

    public void startGame() {
        scanner = new Scanner(System.in);
        System.out.print("Please enter your name: ");
        String name = scanner.nextLine();
        Player player = new Player(name, ,  );
        // Shuffle the deck and deal two cards to each player and the dealer
        deck.shuffle();
        // Add two cards to dealer

        // Display the initial hands
        System.out.println(player.getName() + "'s hand: " + player.getHand());
        System.out.println("Dealer's hand: " + dealer.getHand);
    }
    /*private int sumCalculate(String[] hand){ // Used to calculate sum of each hand
        int sum = 0;
        for (String s : hand) {
            try {
                if (s.charAt(0) == '1') {
                    sum += 9; // 10 parsed as 1, so adds 9 to make 10
                }
                sum += Integer.parseInt(String.valueOf(s.charAt(0))); // Parses string to int and adds to sum
            } catch (Exception e) {
                switch (s.charAt(0)) { // Add values to sum for face cards
                    case 'J', 'K', 'Q' -> sum += 10;
                    case 'A'-> {
                        sum += 11;
                        aceCount++;
                    }
                }

            }
        }
        return sum;
    }

        game starts - choose bet -> balance -= bet
        initial cards - Dealer: one shown one hidden Player: two shown
        player plays -> hits or stands -> dealer plays
        if dealerSum => 17 - no hit
        if dealerSum < 17 - hit
        find winner:
        if dealerSum = playerSum <= 21 - draw - balance = balance + bet
        if playerSum < dealerSum <= 21 - player loses
     */
}
