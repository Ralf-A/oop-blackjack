import java.util.ArrayList;
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
        while(player.getBalance() > 0) {
            new BlackjackGame().startGame(player);
        }
    }

    public void startGame(Player player1) {
        Scanner scanner = new Scanner(System.in);
        int playerScore = 0;
        int dealerScore = 0;
        System.out.print("Please enter your wager: ");
        float bet = Float.parseFloat(scanner.nextLine());
        player1.setBalance(player1.getBalance() - bet);
        // Shuffle the deck and deal two cards to each player and the dealer
        deck.shuffle();
        // Add one card to dealer
        Hand dealerHand = new Hand();
        dealerHand.add(deck.drawCard());
        System.out.println("Dealer's hand: " + dealerHand.toString() + "and ? of ?");
        dealerScore = sumCalculate(dealerHand);
        System.out.println("Dealer's score currently: " + dealerScore);
        Hand playerHand = new Hand();
        playerHand.add(deck.drawCard());
        playerHand.add(deck.drawCard());
        playerScore = sumCalculate(playerHand);
        System.out.println(player1.getNimi() + "'s hand: " + playerHand.toString());
        System.out.println("Player's score currently: " + playerScore);

        while (true) {
            if (playerScore >= 21){
                break;
            }
            System.out.print("Do you want to hit or stand? ");
            String action = scanner.nextLine();
            if (action.toLowerCase(Locale.ROOT).equals("hit")) {
                playerHand.add(deck.drawCard());
                System.out.println(player1.getNimi() + "'s hand: " + playerHand.toString());
                playerScore = sumCalculate(playerHand);
                System.out.println("Player's score currently: " + playerScore);
            }
            if (action.toLowerCase(Locale.ROOT).equals("stand")) {
                System.out.println(player1.getNimi() + "'s hand: " + playerHand.toString());
                playerScore = sumCalculate(playerHand);
                System.out.println("Player's score currently: " + playerScore);
                break;
            }
        }
        if (playerScore > 21){
            System.out.println("Player has gone bust and lost the game!");
            System.out.println("Player " + player1.getNimi() + " balance is now: " + player1.getBalance());
        }
        while (dealerScore < 17){
            dealerHand.add(deck.drawCard());
            dealerScore = sumCalculate(dealerHand);
            System.out.println("Dealer has drawn a card: " + dealerHand.toString());
            System.out.println("Dealer's score is currently: " + dealerScore);
        }
        if (dealerScore < playerScore && playerScore <= 21){
            System.out.println("Player has won the game!");
            player1.setBalance(player1.getBalance() + 2*bet);
            System.out.println("Player's " + player1.getNimi() + " balance is now: " + player1.getBalance());
        }
        if (dealerScore == playerScore){
            System.out.println("It is a push!");
            player1.setBalance(player1.getBalance() + bet);
            System.out.println("Player's " + player1.getNimi() + " balance is now: " + player1.getBalance());
        }
        if (dealerScore > playerScore && dealerScore <= 21){
            System.out.println("Player has lost the game!");
            System.out.println("Player's " + player1.getNimi() + " balance is now: " + player1.getBalance());
        }
    }

    private int sumCalculate(Hand hand) { // Used to calculate sum of each hand
        int sum = 0;
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
        if (sum > 21 && hand.getAcecount() > 0) {
            sum = sum - 10;
        }
        return sum;
    }

}
