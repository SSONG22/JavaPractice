package generic.recursiveTypeBound;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("------------------paying");
        List<Pay> pays = new ArrayList<>();
        pays.add(new Pay(10));
        pays.add(new Pay(30));

        List<Card> cards = new ArrayList<>();
        cards.add(new Card(20));
        cards.add(new Card(5));

        List<Cash> cash = new ArrayList<>();
        cash.add(new Cash(50));
        cash.add(new Cash(10));
        cash.add(new Cash(30));

        System.out.println(Example.max(pays).toString());
        System.out.println("------------------paying");
        System.out.println(Example.max(cards).toString());
        System.out.println("------------------paying");
        System.out.println(Example.max(cash).toString());
    }
}
