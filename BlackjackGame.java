import com.sun.tools.javac.Main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

public class BlackjackGame {
    private Deck deck;
    private int aceCountDealer = 0;
    private int aceCountPlayer = 0;
    Player player = new Player(null, 50);

    public BlackjackGame() {
        deck = new Deck();
    }

    public void startGame(Player player1) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter your wager: ");
        float bet = Float.parseFloat(scanner.nextLine());
        player1.setBalance(player1.getBalance() - bet);
        // Shuffle the deck and deal two cards to each player and the dealer
        deck.shuffle();
        // Add one card to dealer
        ArrayList<Card> dealerHand = new ArrayList<Card>();
        dealerHand.add(deck.drawCard());
        System.out.println("Dealer's hand: " + dealerHand.get(0));
        ArrayList<Card> playerHand = new ArrayList<Card>();
        playerHand.add(deck.drawCard());
        playerHand.add(deck.drawCard());
        System.out.println(player1.getNimi() + "'s hand: " + playerHand.get(0) + "-" + playerHand.get(1));
        System.out.println();
        while (true){
            System.out.print("Do you want to hit or stand? ");
            String action = scanner.nextLine();
            if (action.toLowerCase(Locale.ROOT).equals("hit")){
                playerHand.add(deck.drawCard());
                System.out.println(player1.getNimi() + "'s hand: ");
            }
            if (action.toLowerCase(Locale.ROOT).equals("stand")){
                playerHand.add(deck.drawCard());
                System.out.println(player1.getNimi() + "'s hand: ");
            }
        }
    }

    private int sumCalculate(String[] hand, int aceCount) { // Used to calculate sum of each hand
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
                    case 'A' -> {
                        sum += 11;
                        aceCount++;
                    }
                }
                if (sum > 21 && aceCount > 0) {
                    sum = sum - 10;
                    aceCount--;
                }
            }
            return sum;
        }
    }



    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter your name: ");
        String name = scanner.nextLine();
        System.out.print("Please enter your bank balance: ");
        float balance = Float.parseFloat(scanner.nextLine());

    }

        /*game starts - choose bet -> balance -= bet
        initial cards - Dealer: one shown one hidden Player: two shown
        player plays -> hits or stands -> dealer plays
        if dealerSum => 17 - no hit
        if dealerSum < 17 - hit
        find winner:
        if dealerSum = playerSum - draw - balance = balance + bet
        if playerSum < dealerSum <= 21 - player loses - balance = balance - bet */

}