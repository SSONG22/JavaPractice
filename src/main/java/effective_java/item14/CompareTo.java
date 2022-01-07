package effective_java.item14;

import effective_java.item11.PhoneNumber;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class CompareTo {

    public static void main(String[] args) {

        // equals 와 compareTo
        BigDecimal a = new BigDecimal("1.0");
        BigDecimal b = new BigDecimal("1.00");
        Set<BigDecimal> set = new HashSet<>();
        set.add(a);
        set.add(b);
        System.out.println(set.size()); // 2
        Set<BigDecimal> set2 = new TreeSet<>(set);
        System.out.println(set2.size()); // 1

    }


    static Comparator<Object> hashCodeOrder = new Comparator<>() {
        @Override
        public int compare(Object o1, Object o2) {
            return Integer.compare(o1.hashCode(), o2.hashCode());
        }
    };

    static Comparator<Object> hashCodeOrder2 = Comparator.comparingInt(o -> o.hashCode());
}
