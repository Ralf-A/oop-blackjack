import java.util.ArrayList;

public class Player{
    private String nimi;
    private Float balance;

    public Player(String nimi, float balance) {
        super();
        this.nimi = nimi;
        this.balance = balance;
    }


    public String getNimi() {
        return nimi;
    }

    public Float getBalance() {
        return balance;
    }

    public void setBalance(Float balance) {
        this.balance = balance;
    }
}
