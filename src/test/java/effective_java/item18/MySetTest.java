package effective_java.item18;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class MySetTest {

    @Test
    void setSize(){
        MySet<Integer> mySet = new MySet<>();
        mySet.addAll(Arrays.asList(1,2,3));
        assertThat(mySet.getAddCount()).isNotEqualTo(3);
    }
}