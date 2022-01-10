package effective_java.item46.collectors;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import static org.junit.jupiter.api.Assertions.*;

/*
 * https://www.baeldung.com/java-collectors-tomap
 */

class BookTest {
    List<Book> bookList;

    @BeforeEach
    void setup() {
        bookList = new ArrayList<>();
        bookList.add(new Book("The Fellowship of the Ring", 1954, "0395489318"));
        bookList.add(new Book("The Two Towers", 1954, "0345339711"));
        bookList.add(new Book("The Return of the King", 1955, "0618129111"));
    }

    @DisplayName("List to Map")
    @Test
    public void whenConvertFromListToMap() {
        assertTrue(ConvertToMap.listToMap(bookList).size() == 3);
    }


    //    @Test(expected = IllegalStateException.class) // junit 4
    @DisplayName("Solving Key Conflicts")
    @Test
    public void whenMapHasDuplicateKey_without_merge_function_then_runtime_exception() {
        assertThrows(IllegalStateException.class, () -> ConvertToMap.listToMapWithDupKeyError(bookList));
    }

    @DisplayName("Solving Key Conflicts")
    @Test
    public void whenMapHasDuplicateKeyThenMergeFunctionHandlesCollision() {
        Map<Integer, Book> booksByYear = ConvertToMap.listToMapWithDupKey(bookList);
        assertEquals(2, booksByYear.size());
        assertEquals("0395489318", booksByYear.get(1954).getIsbn());
    }

    @DisplayName("List to ConcurrentMap")
    @Test
    public void whenCreateConcurrentHashMap() {
        Map<Integer, Book> map = ConvertToMap.listToConcurrentMap(bookList);
        assertTrue(ConvertToMap.listToConcurrentMap(bookList) instanceof ConcurrentHashMap);
    }

    @DisplayName("Sorted Map")
    @Test
    public void whenMapisSorted() {
        assertTrue(ConvertToMap.listToSortedMap(bookList).firstKey().equals(
                "The Fellowship of the Ring"));
    }
}