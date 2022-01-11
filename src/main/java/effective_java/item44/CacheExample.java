package effective_java.item44;

import java.util.LinkedHashMap;
import java.util.Map;

// 참조 https://madplay.github.io/post/favor-the-use-of-standard-functional-interfaces
public class CacheExample {
    public static void main(String[] args) {
        // 옛날 방식
        Map<String, Integer> map = new LinkedHashMap<String, Integer>() {
            @Override
            protected boolean removeEldestEntry(Map.Entry<String, Integer> eldest) {
                return size() > 3;
            }
        };

        map.put("a", 1);
        map.put("b", 2);
        map.put("c", 3);
        map.put("d", 4);
        System.out.println(map); // 2,3,4

        // 요즘 방식
        Map<String, Integer> now = CacheMap.of((map1, eldest) -> map1.size() > 3);
        for (int i = 1; i <= 5; i++) {
            now.put(String.valueOf(i), i);
        }
        System.out.println(now); // 3,4,5
    }

}
