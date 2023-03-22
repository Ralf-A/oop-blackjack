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
                this.Score+=10;
                if (this.Score>21 && this.Acecount>0){
                    this.Acecount--;
                    this.Score-=10;
                }
                break;
            case "K":
                this.Score+=10;
                if (this.Score>21 && this.Acecount>0){
                    this.Acecount--;
                    this.Score-=10;
                }
                break;
            case "Q":
                this.Score+=10;
                if (this.Score>21 && this.Acecount>0){
                    this.Acecount--;
                    this.Score-=10;
                }
                break;
            default:
                this.Score+=Integer.parseInt(a.getValue());
                if (this.Score>21 && this.Acecount>0){
                    this.Acecount--;
                    this.Score-=10;
                }
        }
    }

    public ArrayList<Card> getHand() {
        return Hand;
    }

    public getScore(){
        return this.Score;

    }
}
