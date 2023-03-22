import java.util.List;

public class Dealer extends People{
    private Hand hand;
    private Deck deck;

    public Dealer(Deck deck) {
        super();
        this.deck = deck;
    }

    public void dealCard(People player) {
        Card card = deck.drawCard();
        player.getHand().addCard(card);
    }

    public void dealInitialCards(List<Player> players) {
        for (Player player : players) {
            dealCard(player);
        }
        dealCard(this);
        for (Player player : players) {
            dealCard(player);
        }
    }

    public void playTurn() {
        while (hand.getScore() < 17) {
            dealCard(this);
        }
    }

    public Hand getHand() {
        return hand;
    }
}