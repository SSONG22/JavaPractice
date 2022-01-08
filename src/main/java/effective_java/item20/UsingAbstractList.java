package effective_java.item20;

import java.util.AbstractList;
import java.util.List;
import java.util.Objects;

public class UsingAbstractList {

    static List<Integer> intArrayAsList(int[] array) {
        Objects.requireNonNull(array);

        return new AbstractList<Integer>() {
            @Override
            public Integer get(int index) {
                return array[index];
            }

            @Override
            public int size() {
                return array.length;
            }

            @Override
            public Integer set(int index, Integer element) {
                int old = array[index];
                array[index] = element; // 오토 언박싱 (Integer->int)
                return old; // 오토 박싱 (int->Integer)
            }
        };
    }
}
