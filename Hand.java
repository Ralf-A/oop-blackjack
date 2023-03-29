import java.util.ArrayList;

public class Hand {
    private ArrayList<Card> Hand;

    public Hand() {
        Hand = new ArrayList<Card>(0);

    }

    public ArrayList<Card> getHand() {
        return Hand;
    }

    @Override
    public String toString() {
        String cards = "";
        for (Card card:Hand) {
            cards+=card+"";
        }
        return cards;
    }
}
