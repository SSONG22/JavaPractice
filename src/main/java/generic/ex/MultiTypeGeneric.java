package generic.ex;

import java.util.Map;

class MultiTypeGeneric<K, V> implements Map.Entry<K,V> {
    private K key;
    private V value;
    @Override
    public K getKey() {
        return null;
    }

    @Override
    public V getValue() {
        return null;
    }

    @Override
    public V setValue(V value) {
        return null;
    }
}
