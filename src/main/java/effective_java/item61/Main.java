package effective_java.item61;

import java.util.Comparator;


public class Main {
    public static void main(String[] args) {
        Integer a = new Integer(1); // (Integer) 1
        Integer b = 1; // (int) 1 ?
        int c = 1;
        Comparator<Integer> naturalOrder = (i, j) -> (i < j) ? -1 : (i == j ? 0 : 1);

        System.out.println(naturalOrder.compare(a, b)); // 0 ?????????????????????
        System.out.println(naturalOrder.compare(new Integer(1), new Integer(1))); // true
        System.out.println(naturalOrder.compare(new Integer(42), new Integer(42))); // true
    }
}
