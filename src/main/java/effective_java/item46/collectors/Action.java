package effective_java.item46.collectors;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Action {
    public Map<String, String> listToMap(List<Book> books) {
        return books.stream().collect(Collectors.toMap(Book::getIsbn, Book::getName));
    }

    public Map<Integer, Book> listToMapWithDupKeyError(List<Book> books) {
        return books.stream().collect(
                Collectors.toMap(Book::getReleaseYear, Function.identity()));
    }

}
