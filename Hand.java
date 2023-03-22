import java.util.ArrayList;

public class Hand {
    private ArrayList<Card> Hand;
    private int Score;
    private int Acecount;

    public Hand() {
        Hand = new ArrayList<Card>(0);
        Score = 0;
        Acecount = 0;
    }

    public void addCard(Card a){
        this.Hand.add(a);
        switch (a.getValue()){
            case "A":
                if (this.Score+11>21){
                    this.Score++;
                    break;
                }else {
                    this.Score+=11;
                    Acecount++;
                    break;
                }
            case "J":
                if this.Score
        }
    }

    public ArrayList<Card> getHand() {
        return Hand;
    }

    public getScore(){

    }
}
