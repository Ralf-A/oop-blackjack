public class Card {
    private String suit;
    private String value;

    public Card(String suit, String value) {
        this.suit = suit;
        this.value = value;
    }

    public String getSuit() {
        return suit;
    }

    public String getValue() {
        return value;
    }

    public String toString() {
        String cardName = "";

        switch (value) {
            case "A":
                cardName = "Ace";
                break;
            case "P":
                cardName = "Jack";
                break;
            case "Q":
                cardName = "Queen";
                break;
            case "K":
                cardName = "King";
                break;
            default:
                cardName = (value);
                break;
        }

        return cardName + " of " + suit;
    }
}