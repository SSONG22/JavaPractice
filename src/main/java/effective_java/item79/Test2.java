package effective_java.item79;

import java.util.HashSet;

public class Test2 {

    public static void main(String[] args) {
        ObservableSet<Integer> set =
                new ObservableSet<>(new HashSet<>());

        set.addObserver(new SetObserver<>() {
            public void added(ObservableSet<Integer> s, Integer e) {
                System.out.println(e);
                if (e == 23)
                    s.removeObserver(this); // 람다는 자신을 넘길 수 없기 때문에 익명클래스 사용
                // 리스트에서 원소를 제거하려 하는데 마침 리스트를 순회중이므로 ConcurrentModificationException 발생
            }
        });

        for (int i = 0; i < 100; i++)
            set.add(i);
    }
}
