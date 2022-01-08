package effective_java.item20;

import java.util.Map;

// 골격 구현 클래스
public class AbstractMapEntry<K,V> implements Map.Entry<K,V> {
    @Override
    public K getKey() {
        return null;
    }

    @Override
    public V getValue() {
        return null;
    }

    // 변경 가능한 엔트리는 이 메서드를 반드시 재정의 해야 한다.
    @Override
    public V setValue(V value) {
        throw new UnsupportedOperationException();
    }

    // Map.Entry.hasCode 의 일반 규약을 구현한다.
    @Override
    public int hashCode() {
        return super.hashCode();
    }

    // Map.Entry.equals 의 일반 규약을 구현한다.
    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
