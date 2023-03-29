import java.util.ArrayList;

public class Hand {
    private ArrayList<Card> Hand;

    public Hand() {
        Hand = new ArrayList<Card>(0);

    }

    public ArrayList<Card> getHand() {
        return Hand;
    }
}
