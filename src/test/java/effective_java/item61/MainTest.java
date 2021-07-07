package effective_java.item61;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/* https://stackoverflow.com/questions/13098143/why-does-the-behavior-of-the-integer-constant-pool-change-at-127 */
class MainTest {

    @Test
    void vsString(){
        int x = 10;
        int y = x+1;
        Integer z = y; // Not a compile-time constant
        Integer constant = 11;
        System.out.println(z == constant);
        assertThat(z).isEqualTo(constant);
    }

    @DisplayName("두번째 답변")
    @Test
    void constantPool(){
        Integer i1 = 127; // <- Integer.valueOf(127);
        Integer i2 = 127; // <- Integer.valueOf(127);  :: Same reference as first

        /*
        *  Integer.valueOf
        *  if (i >= IntegerCache.low && i <= IntegerCache.high)
            return IntegerCache.cache[i + (-IntegerCache.low)];
            return new Integer(i);
        * */

        Integer i3 = 128;
        Integer i4 = Integer.valueOf(128);

        System.out.println(i1 == i2); // true, reference pointing to same literal
        System.out.println(i3 == i4); // false, reference pointing to different objects
        assertThat(i3).isNotSameAs(i4);
    }
}