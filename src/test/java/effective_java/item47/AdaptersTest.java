package effective_java.item47;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;


import static org.assertj.core.api.Assertions.assertThat;

class AdaptersTest {
    @Test
    public void givenIterable_whenConvertedToStream_thenNotNull() {
        Iterable<String> iterable
                = Arrays.asList("Testing", "Iterable", "conversion", "to", "Stream");

        // stream 은 재사용할 수 없지만 iterable 은 재사용 가능하다.
        assertThat(StreamSupport.stream(iterable.spliterator(), false)).isNotEqualTo(null);
    }

    @Test
    public void whenConvertedToList_thenCorrect() {
        Iterable<String> iterable
                = Arrays.asList("Testing", "Iterable", "conversion", "to", "Stream");

        List<String> result = StreamSupport.stream(iterable.spliterator(), false)
                .map(String::toUpperCase)
                .collect(Collectors.toList());

        assertThat(result).contains("TESTING", "ITERABLE", "CONVERSION", "TO", "STREAM");
    }
}