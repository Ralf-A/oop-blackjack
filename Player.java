import java.util.ArrayList;

public class Player extends People{
    private String name;
    private Hand hand;
    private Float balance;

    public Player(String name, ArrayList<String>[] hand, Float balance) {
        super();
        this.name = name;
        this.balance = balance;
    }

    public Hand getHand() {
        return hand;
    }

    public String getName() {
        return name;
    }

    public Float getBalance() {
        return balance;
    }


    }

