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
            case "1":
                cardName = "Ace";
                break;
            case "11":
                cardName = "Jack";
                break;
            case "12":
                cardName = "Queen";
                break;
            case "13":
                cardName = "King";
                break;
            default:
                cardName = (value);
                break;
        }

        return cardName + " of " + suit;
    }
}