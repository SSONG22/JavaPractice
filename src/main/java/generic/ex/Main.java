package generic.ex;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        MyGenericWildCard myGenericWildCard = new MyGenericWildCard();
        List<Integer> numbers = Arrays.asList(1,2,3,4);
        List<String> strings = Arrays.asList("a","b","C");
        myGenericWildCard.printList(numbers);
        myGenericWildCard.printList(strings);

    }
}
