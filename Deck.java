import java.util.ArrayList;
import java.util.Collections;

public class Deck {
    private ArrayList<Card> Deck;
    private int Mitmes;

    public Deck() {
        ArrayList<Card> vahe= new ArrayList<Card>(0);
        String[] suits = {"S","H","C","D"};
        String[] values = {"2","3","4","5","6","7","8","9","10","P","Q","K","A"};
        for (String suit: suits) {
            for (String value : values) {
                vahe.add(new Card(suit,value));
            }
        }
        Deck = vahe;
        Mitmes = 0;
    }

    public void shuffle(){
        Collections.shuffle(this.Deck);
        this.Mitmes = 0;
    }

    public Card drawCard(){
        this.Mitmes++;
        return Deck.get(this.Mitmes-1);
    }


}
