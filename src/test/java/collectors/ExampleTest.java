package collectors;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

class ExampleTest {

    @Test
    @DisplayName("Collectors.toUnmodifiableList() 수정불가능 테스트")
    void stream_collect() {
        List<String> result = Example.getGivenList()
                .stream().collect(Collectors.toUnmodifiableList());
        // assertJ
        Assertions.assertThatThrownBy(() -> result.add("add"))
                .isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    @DisplayName("toSet")
    void toSet_test() {
        List<String> listWithDuplicates = Arrays.asList("a", "bb", "c", "d", "bb");
        Set<String> result = listWithDuplicates.stream().collect(Collectors.toSet());
        assertThat(result).hasSize(4);
    }

    @Test
    void toMap_test() {
        Map<String, Integer> result = Example.getGivenList().stream()
                .collect(Collectors.toMap(Function.identity(), String::length));

        List<String> listWithDuplicates = Arrays.asList("a", "bb", "c", "d", "bb");
        Assertions.assertThatThrownBy(() -> {
            listWithDuplicates.stream().collect(Collectors.toMap(Function.identity(), String::length));
        }).isInstanceOf(IllegalStateException.class);


    }

    @DisplayName("collectingAndThen")
    @Test
    void collectionAndTenTest() {
        Object result = Example.getGivenList().stream()
                .collect(Collectors.collectingAndThen(Collectors.toList(), Collection::toString));
    }

    @DisplayName("joining")
    @Test
    void joiningTest() {
        String result = Example.getGivenList().stream()
                .collect(Collectors.joining());
        String result2 = Example.getGivenList().stream()
                .collect(Collectors.joining(" ", "PRE-", "-POST"));
    }

    @DisplayName("counting")
    @Test
    void countingTest() {
        Long result = Example.getGivenList().stream()
                .collect(Collectors.counting());
    }
}