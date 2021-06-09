package generic.ex;

import java.util.List;

public class MyGenericWildCard {
    public void printList(List<?> list) {
        for (Object obj : list)
            System.out.println(obj + " ");
    }

    public List<? super Integer> addList(List<? super Integer> list) {
        for (int i = 1; i < 5; i++) list.add(i);
        return list;
    }

    public int sum(List<? extends Number> list) {
        int sum = 0;
        for (Number i : list) {
            sum += i.doubleValue();
        }
        return sum;
    }
}
