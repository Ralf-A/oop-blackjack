public class Card {
    private String suit; //suit of a card
    private String value; //value of a card

    public Card(String suit, String value) {
        this.suit = suit;
        this.value = value;
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