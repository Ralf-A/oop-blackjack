abstract class People {
    protected Hand Hand;

    public People() {
        Hand = new Hand();
    }
    abstract Hand getHand();
}
