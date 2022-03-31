package effective_java.item18;

import java.util.Collection;
import java.util.HashSet;

public class MySet<E> extends HashSet<E> {
    private int addCount;

    @Override
    public boolean add(E e) {
        addCount++;
        System.out.println("Add " + addCount);
        return super.add(e);
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        addCount += c.size();
        System.out.println("Add All " + addCount);
        return super.addAll(c);
    }

    public int getAddCount() {
        return addCount;
    }
}

