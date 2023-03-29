import java.util.ArrayList;

public class Hand {
    private ArrayList<Card> Hand;
    private int Acecount;

    public Hand() {
        Hand = new ArrayList<Card>(0);
        Acecount = 0;
    }

    public ArrayList<Card> getHand() {
        return Hand;
    }

    public void add(Card a){
        if (a.getValue().equals("A")){
            Acecount++;
        }
        Hand.add(a);
    }

    public int getAcecount(){
        return Acecount;
    }

    public void setAcecount(int acecount) {
        Acecount = acecount;
    }

    @Override
    public String toString() {
        String cards = "";
        for (Card card:Hand) {
            cards+=card+" ";
        }
        return cards;
    }
}
