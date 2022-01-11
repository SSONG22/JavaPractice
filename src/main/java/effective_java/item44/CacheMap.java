package effective_java.item44;

import java.util.LinkedHashMap;
import java.util.Map;

public class CacheMap<K, V> extends LinkedHashMap<K, V> {
    private EldestEntryRemovalFunction<K, V> function;

    private CacheMap(EldestEntryRemovalFunction<K, V> function) {
        this.function = function;
    }

    public static <K, V> CacheMap<K, V> of(EldestEntryRemovalFunction<K, V> function) {
        return new CacheMap<K, V>(function);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return function.remove(this, eldest);
    }
}
