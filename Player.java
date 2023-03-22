import java.util.ArrayList;

public class Player {
    private String nimi;
    private Hand hand;
    private Float balance;

    public Player(String nimi, ArrayList<String>[] hand, Float balance) {
        this.nimi = nimi;
        this.hand = new Hand();
        this.balance = balance;
    }

    public Hand getHand() {
        return hand;
    }
}
