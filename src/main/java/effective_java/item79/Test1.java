package effective_java.item79;

import java.util.HashSet;

public class Test1 {
    /**
     * public void addObserver(SetObserver<E> observer) {
     *      synchronized(observers) {
     *          observers.add(observer);
     *      }
     * }
     */
    public static void main(String[] args) {
        ObservableSet<Integer> set =
                new ObservableSet<>(new HashSet<>());

        set.addObserver((s, e) -> System.out.println(e)); // add 된 원소를 호출한다.
        // 제어로직이 람다식 밖에 있다.

        for (int i = 0; i < 100; i++)
            set.add(i);
    }
}
