package collectors;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Example {

    static List<String> givenList = Arrays.asList("a", "bb", "ccc", "dd");

    public static List<String> getGivenList(){
        return givenList;
    }

    public static List<String> streamToList() {
        List<String> result = givenList.stream().collect(Collectors.toList());

        // toCollection
        givenList.stream().collect(Collectors.toCollection(LinkedList::new));
        return result;
    }

    public static Set<String> streamToSet(){
        Set<String> result = givenList.stream().collect(Collectors.toSet());
        return result;
    }


}
