import java.util.ArrayList;

public class Player {
    String nimi;
    ArrayList<String>[] hand;
    Float balance;

    public Player(String nimi, ArrayList<String>[] hand, Float balance) {
        this.nimi = nimi;
        this.hand = hand;
        this.balance = balance;
    }
}
