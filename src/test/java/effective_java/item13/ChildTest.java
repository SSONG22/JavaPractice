package effective_java.item13;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class ChildTest {

    @DisplayName("super.clone을 연쇄적으로 호출하면 clone이 처음 호출된 하위 클래스의 객체가 만들어진다.")
    @Test
    void test() {
        Parent parent = new Parent();
        Child child = new Child();
        assertNotEquals(child.getClass(), child.clone().getClass());
        assertEquals(parent.getClass(), parent.clone().getClass());
        assertEquals(parent.getClass(), child.clone().getClass());
    }

    @DisplayName("원본객체나 클론객체에 변화를 주면 서로 영향을 미친다.")
    @Test
    void 상속관계(){
        Parent parent = new Parent();
        Child child = new Child();
        assertEquals(child.name, "parent");

        Child clone = child.clone();
        assertEquals(child.name, "child");
        assertEquals(clone.name, "child");

        System.out.println(parent.clone().name);
        // clone 이 변하니 원본(child)도 변했다.
    }
}