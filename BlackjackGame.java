import java.util.Locale;
import java.util.Scanner;

public class BlackjackGame {
    private Deck deck;

    public BlackjackGame() {
        deck = new Deck();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter your name: ");
        String name = scanner.nextLine();
        System.out.print("Please enter your bank balance: ");
        float balance = Float.parseFloat(scanner.nextLine());
        Player player = new Player(name, balance);
        while(player.getBalance() > 0) { // While player has balance > 0, can start game
            new BlackjackGame().startGame(player);
        }
    }

    public void startGame(Player player1) {
        Scanner scanner = new Scanner(System.in);
        int playerScore = 0;
        int dealerScore = 0;
        System.out.print("Please enter your wager: ");
        float bet = Float.parseFloat(scanner.nextLine());
        player1.setBalance(player1.getBalance() - bet); // Remove bet from player's balance
        deck.shuffle(); // Shuffle the deck and deal two cards to each player and the dealer
        Hand dealerHand = new Hand(); // Creates instance for dealer's hand
        dealerHand.add(deck.drawCard()); // Add one card to dealer
        System.out.println("Dealer's hand: " + dealerHand.toString() + "and ? of ?");
        dealerScore = sumCalculate(dealerHand); // Variable to keep track of dealer's score
        System.out.println("Dealer's score currently: " + dealerScore);
        Hand playerHand = new Hand(); // Creates instance for player's hand
        playerHand.add(deck.drawCard()); // Adds two cards to player
        playerHand.add(deck.drawCard());
        playerScore = sumCalculate(playerHand); // Variable to keep track of player's score
        System.out.println(player1.getNimi() + "'s hand: " + playerHand.toString());
        System.out.println("Player's score currently: " + playerScore);

        while (true) {
            if (playerScore >= 21){ // Player can't hit when score >= 21, they have either bust or won already
                break;
            }
            System.out.print("Do you want to hit or stand? ");
            String action = scanner.nextLine();
            if (action.toLowerCase(Locale.ROOT).equals("hit")) { // Hit to draw next card
                playerHand.add(deck.drawCard());
                System.out.println(player1.getNimi() + "'s hand: " + playerHand.toString());
                playerScore = sumCalculate(playerHand);
                System.out.println("Player's score currently: " + playerScore);
            }
            if (action.toLowerCase(Locale.ROOT).equals("stand")) { // Stand for dealer's turn
                System.out.println(player1.getNimi() + "'s hand: " + playerHand.toString());
                playerScore = sumCalculate(playerHand);
                System.out.println("Player's score currently: " + playerScore);
                break;
            }
        }
        if (playerScore > 21){ // Player has busted
            System.out.println("Player has gone bust and lost the game!");
            System.out.println("Player " + player1.getNimi() + " balance is now: " + player1.getBalance());
        }
        while (dealerScore < 17){ // Dealer must hit below 17
            dealerHand.add(deck.drawCard());
            dealerScore = sumCalculate(dealerHand);
            System.out.println("Dealer has drawn a card: " + dealerHand.toString());
            System.out.println("Dealer's score is currently: " + dealerScore);
        }
        if (dealerScore < playerScore && playerScore <= 21){ // Player has more than dealer and their score is less or 21
            System.out.println("Player has won the game!");
            player1.setBalance(player1.getBalance() + 2*bet);
            System.out.println("Player's " + player1.getNimi() + " balance is now: " + player1.getBalance());
        }
        if (dealerScore == playerScore){ // Player and dealer tied the game
            System.out.println("It is a push!");
            player1.setBalance(player1.getBalance() + bet);
            System.out.println("Player's " + player1.getNimi() + " balance is now: " + player1.getBalance());
        }
        if (dealerScore > playerScore && dealerScore <= 21){ // Dealer has more than player and their score is less than 21
            System.out.println("Player has lost the game!");
            System.out.println("Player's " + player1.getNimi() + " balance is now: " + player1.getBalance());
        }
    }

    private int sumCalculate(Hand hand) { // Used to calculate sum of each hand
        int sum = 0;
        int aces = hand.getAcecount();
        for (Card card : hand.getHand()) {
            try {
                if (card.getValue().charAt(0) == '1') {
                    sum += 9; // 10 parsed as 1, so adds 9 to make 10
                }
                sum += Integer.parseInt(String.valueOf(card.getValue().charAt(0))); // Parses string to int and adds to sum
            } catch (Exception e) {
                switch (card.getValue().charAt(0)) { // Add values to sum for face cards
                    case 'J', 'K', 'Q' -> sum += 10;
                    case 'A' -> sum += 11;
                }
            }

        }
        while (sum > 21 && aces > 0) { // If player has an ace and has > 21 score, subtracts 10 to keep game going
            sum = sum - 10;
            aces--;
        }
        return sum;
    }

}
