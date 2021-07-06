package effective_java.item58;

import java.util.*;

public class Card {
    private final Suit suit;
    private final Rank rank;
    enum Suit { CLUB, DIAMOND, HEART, SPADE }
    enum Rank { ACE, DEUCE, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT,
        NINE, TEN, JACK, QUEEN, KING }

    static Collection<Suit> suits = Arrays.asList(Suit.values());
    static Collection<Rank> ranks = Arrays.asList(Rank.values());

    Card(Suit suit, Rank rank ) {
        this.suit = suit;
        this.rank = rank;
    }

    public static void main(String[] args) {
        List<Card> deck = new ArrayList<>();

        for (Iterator<Suit> i = suits.iterator(); i.hasNext(); ) {
            Suit s = i.next();

            for (Iterator<Rank> j = ranks.iterator(); j.hasNext(); ) {
                Rank r = j.next();
                System.out.println(s + " " + r);
                deck.add(new Card(s, r));
            }
        }
    }

}
