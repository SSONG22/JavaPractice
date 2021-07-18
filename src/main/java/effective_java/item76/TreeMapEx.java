package effective_java.item76;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class TreeMapEx {
    private Map<String, Integer> map = new TreeMap<>();

    public void add(String key, Object value) {
        if (!(value instanceof Integer))
            throw new ClassCastException(value.toString());
        map.put(key, (Integer) value);
    }
    public List<Integer> getValue(){
        return map.values().stream().collect(Collectors.toList());
    }
    public void print(){
        map.values().forEach(m->
                System.out.println(m));
        System.out.println(map);
    }
}
