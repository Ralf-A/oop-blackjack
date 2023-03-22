import java.util.ArrayList;

public class Player {
    private String name;
    private Hand hand;

    public String getName() {
        return name;
    }

    public Float getBalance() {
        return balance;
    }

    private Float balance;

    public Player(String name, ArrayList<String>[] hand, Float balance) {
        this.name = name;
        this.hand = new Hand();
        this.balance = balance;
    }

    public Hand getHand() {
        return hand;
    }
}
