package effective_java.item20;

import java.util.AbstractList;
import java.util.List;
import java.util.Objects;

public class UsingAbstractList {

    // 익명 내부 클래스(아이템 24) -> 정적 팩토리 메서드
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
