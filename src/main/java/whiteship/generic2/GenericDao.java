package whiteship.generic2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GenericDao<E extends Entity<K>, K> {
    private Map<K, E> datasource = new HashMap<>();

    public void save(E e) {
        datasource.put(e.getId(), e);
    }

    public void delete(E e) {
        datasource.remove(e.getId());
    }

    public void delete(K k) {
        datasource.remove(k);
    }

    public List<E> findAll() {
        return new ArrayList<>(datasource.values());
    }

    public E findById(K k) {
        return datasource.get(k);
    }
}
