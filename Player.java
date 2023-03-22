import java.util.ArrayList;

public class Player extends People{
    private String nimi;
    private Hand hand;
    private Float balance;

    public Player(String nimi, ArrayList<String>[] hand, Float balance) {
        super();
        this.nimi = nimi;
        this.balance = balance;
    }

    public Hand getHand() {
        return hand;
    }
}
