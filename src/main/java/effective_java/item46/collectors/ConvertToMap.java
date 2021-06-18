package effective_java.item46.collectors;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.stream.Collectors;

public final class ConvertToMap {
    // list -> map
    public static Map<String, String> listToMap(List<Book> books) {
        return books.stream().collect(Collectors.toMap(Book::getIsbn, Book::getName));
    }

    // not working
    public static Map<Integer, Book> listToMapWithDupKeyError(List<Book> books) {
        return books.stream().collect(
                Collectors.toMap(Book::getReleaseYear, Function.identity()));
    }

    // 중복 키 처리 (기존에 있던것, 새로들어오는 것)
    public static Map<Integer, Book> listToMapWithDupKey(List<Book> books) {
        return books.stream().collect(Collectors.toMap(Book::getReleaseYear, Function.identity(),
                (existing, replacement) -> existing));
    }

    // 중복처리, list -> concurrentHashMap
    public static Map<Integer, Book> listToConcurrentMap(List<Book> books) {
        return books.stream().collect(Collectors.toMap(Book::getReleaseYear, Function.identity(),
                (existing, replacement) -> existing, ConcurrentHashMap::new));
    }

    // list -> sortedMap (treeMap)
    public static TreeMap<String, Book> listToSortedMap(List<Book> books) {
        return books.stream()
                .collect(
                        Collectors.toMap(Book::getName, Function.identity(), (o1, o2) -> o1, TreeMap::new));
    }
}
