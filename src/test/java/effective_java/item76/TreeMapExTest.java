package effective_java.item76;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class TreeMapExTest {
    TreeMapEx ex;

    @BeforeEach
    void setup() {
        ex = new TreeMapEx();
    }

    @Test
    void 예외를_던져야_한다() {
        Assertions.assertThrows(ClassCastException.class, ()->{
            ex.add("key","1");
        });
    }

    @Test
    void Integer인_값만() {
        ex.add("hi", 2);
        ex.add("key", 1);
        ex.add("hello", 3);
        ex.print();
        assertThat(Arrays.asList(3,2,1)).isEqualTo(ex.getValue());
    }

}