package effective_java.item38;

import java.util.Arrays;
import java.util.Collection;

public class Main {
    public static void main(String[] args) {
        double x = 10.25;
        double y = 23.1;

        solution1(ExtendedOperation.class, x, y);
        solution2(Arrays.asList(ExtendedOperation.values()), x, y);
    }

    private static <T extends Enum<T> & Operation> void solution1
            (Class<T> opEnumType, double x, double y) {
        for (Operation op : opEnumType.getEnumConstants()) {
            System.out.printf("%f %s %f = %f%n", x, op, y, op.apply(x, y));
        }
    }

    private static void solution2(Collection<? extends Operation> opSet, double x, double y) {
        for (Operation op : opSet) {
            System.out.printf("%f %s %f = %f%n", x, op, y, op.apply(x, y));
        }
    }

}
