package effective_java.item30;

import java.util.*;

public class Union {
/*
    // raw 타입
    public static Set union(Set s1, Set s2){
        Set result = new HashSet(s1);
        result.addAll(s2);
        return result;
    }
*/

    // 제네릭 메서드
    public static <E> Set<E> union(Set<E> s1, Set<E> s2) {
        Set<E> result = new HashSet<>(s1);
        result.addAll(s2);
        return result;
    }

    // Simple program to exercise generic method
    public static void main(String[] args) {
        Set<String> guys = Set.of("Tom", "Dick", "Harry");
        Set<String> stooges = Set.of("Larry", "Moe", "Curly");
        Set<String> aflCio = union(guys, stooges);
        System.out.println(aflCio);

        List<String> stringArrayList = new ArrayList<>();
        stringArrayList.add("123"); stringArrayList.add("abc");
        stringArrayList.add("기니디");
        Collections.sort(stringArrayList);
        System.out.println(stringArrayList);

        Collections.binarySearch(stringArrayList, "123");
        System.out.println(stringArrayList);

        List<String> ex1 = Arrays.asList("a", "1", "가");
        ex1.sort(Collections.reverseOrder()); // 함수 내부에 들어가는 객체를 함수객체라 한다.
        System.out.println(ex1);

        Set<Number> empty = Collections.emptySet();
        System.out.println(empty);
    }
}