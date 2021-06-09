package generic;

import generic.ex.SimpleArrayList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SimpleArrayListTest {

    @DisplayName("컴파일 에러없이 잘 동작한다.")
    @Test
    void 제네릭_테스트_로우타입(){
        SimpleArrayList list = new SimpleArrayList();
        list.add(50);
        list.add(100);
        Integer value1 = (Integer) list.get(0);
        Integer value2 = (Integer) list.get(1);
        System.out.println(value1+value2);
    }

    @DisplayName("컴파일 에러는 없지만 런타임에러가 발생한다.")
    @Test
    void 제네릭_테스트2_로우타입(){
        SimpleArrayList list = new SimpleArrayList();
        // Object 타입은 모두 받을 수 있으니까 String, Integer 모두 인자로 줄 수 있다.
        list.add("50");
        list.add("100"); // 문법적으로 문제가 없다.
        Integer value1 = (Integer) list.get(0);
        Integer value2 = (Integer) list.get(1);
        System.out.println(value1+value2);
    }
}