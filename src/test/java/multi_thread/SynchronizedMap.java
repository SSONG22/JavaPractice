package multi_thread;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

import static org.junit.jupiter.api.Assertions.*;

class SynchronizedMap {

    @DisplayName("HashMap은 Thread-safe 하지않기 때문에 반복하는 동안 업데이트를 하면 ConcurrentModificationException이 발생한다." +
            "synchronizedMap()을 사용해도 발생한다.")
    @Test
    void hashmap() {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "hello");
        map.put(2, "HashMap");

        Map<Integer, String> synchronizedMap = Collections.synchronizedMap(map);
        Iterator<Map.Entry<Integer, String>> iterator = synchronizedMap.entrySet().iterator();
        assertThrows(ConcurrentModificationException.class, () -> {
            while (iterator.hasNext()) {
                synchronizedMap.put(3, "Modification");
                iterator.next();
            }
        });
    }

    @DisplayName("ConcurrentHashMap 은 key, value에 null을 허용하지 않는다.")
    @Test
    void null_currentHashMap() {
        Map<String, Integer> map = new ConcurrentHashMap<>();
        assertThrows(NullPointerException.class, () -> map.put(null, 1));
    }

    @DisplayName("Collections.synchronizedMap 을 사용할 떄 HashMap, LinkedHashMap 은 null 을 키값으로 가질 수 있다.")
    @Test
    void null_synchronizedMap() {
        Map<String, Integer> map = Collections.synchronizedMap(new HashMap<>());
        map.put(null, 1);
        assertTrue(map.get(null).equals(1));
    }

    @DisplayName("Collections.synchronizedMap 을 사용할 떄 HashMap, TreeMap 은 null 을 키값으로 가질 수 있다.")
    @Test
    void null_synchronizedMap_treeMap() {
        Map<String, Integer> map = Collections.synchronizedMap(new TreeMap<>());
        assertThrows(NullPointerException.class, () -> map.put(null, 1)); // key 값으로 null 은 불가
        assertDoesNotThrow(() -> map.put("1", null)); // value 값으로 null 은 허용
    }

}