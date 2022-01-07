package effective_java.item13;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StackTest {

    @DisplayName("원본이나 복제본 중 하나를 수정하면 다른 하나도 수정되어 불변식을 해친다.")
    @Test
    void 가변객체_복사() {
        Stack stack = new Stack();
        Stack cloneStack = stack.clone();
        stack.push("HI");
        cloneStack.push("HI2");

        Object origin = stack.peek();
        Object clone = cloneStack.peek();

        System.out.println(origin + " " + clone);// HI2 HI2

        assertEquals(origin, clone);
    }

}