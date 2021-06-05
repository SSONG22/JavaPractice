package effective_java.item30;

import java.util.function.BinaryOperator;

public class GenericSingletonFactoryEx {
    private static BinaryOperator<Object> FIRST = (t1, t2) -> t1;

    @SuppressWarnings("unchecked")
    public static <T> BinaryOperator<T> firstFunction() {
        return (BinaryOperator<T>) FIRST;
    }

    public static void main(String[] args) {
        String[] strings = {"a", "b"};
        String c = "c";
        BinaryOperator<String> binaryOperator = firstFunction();
        for (String s : strings)
            System.out.println(binaryOperator.apply(s, c));

        int[] numbers = {1,2,3};
        int other = 4;
        BinaryOperator<Integer> binaryOperatorNum = firstFunction();
        for(int n : numbers)
            System.out.println(binaryOperatorNum.apply(n, other));
    }
}
