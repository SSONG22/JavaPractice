package effective_java.item38;

import java.util.Arrays;
import java.util.Collection;

public class Main {
    public static void main(String[] args) {
        double x = 10.25;
        double y = 23.1;

        // ExtendedOperation 의 class 리터럴을 넘겨 확장된 연산들이 무엇인지 알려준다.
        solution1(ExtendedOperation.class, x, y);
        solution2(Arrays.asList(ExtendedOperation.values()), x, y);
    }

    // enum 타입을 넘긴다. Class 객체가 enum 이면서 Operation 의 하위 객체
    private static <T extends Enum<T> & Operation> void solution1
            (Class<T> opEnumType, double x, double y) {
        for (Operation op : opEnumType.getEnumConstants()) {
            System.out.printf("%f %s %f = %f%n", x, op, y, op.apply(x, y));
        }
    }

    // 한정적 와일드 카드 타입을 넘긴다.
    private static void solution2(Collection<? extends Operation> opSet, double x, double y) {
        for (Operation op : opSet) {
            System.out.printf("%f %s %f = %f%n", x, op, y, op.apply(x, y));
        }
    }

}
