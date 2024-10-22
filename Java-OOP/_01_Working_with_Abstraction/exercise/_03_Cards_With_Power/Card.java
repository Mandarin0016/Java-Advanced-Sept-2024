package _03_Cards_With_Power;

public class Card {

    private CardRank cardRank;
    private CardSuit cardSuit;

    public Card(CardRank cardRank, CardSuit cardSuit) {
        this.cardRank = cardRank;
        this.cardSuit = cardSuit;
    }

    public int getCardPower() {
        return cardRank.getPower() + cardSuit.getPower();
    }

    @Override
    public String toString() {
        return String.format(
        "Card name: %s of %s; Card power: %d",
        this.cardRank,
        this.cardSuit,
        this.getCardPower());
    }
}
