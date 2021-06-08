package whiteship.generic2;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GenericDao<E extends Entity<K>, K> {

    private Class<E> entityClass;

    public GenericDao(){
        if (this.getClass().getGenericSuperclass() instanceof Class) {

            entityClass = (Class<E>) this.getClass().getGenericSuperclass();

        } else if (this.getClass().getGenericSuperclass() instanceof ParameterizedType) { // supports generic of generic

            Type rawType = ((ParameterizedType) this.getClass().getGenericSuperclass()).getRawType();

            entityClass = (Class<E>) rawType;

        }
        // class java.lang.class cannot be cast to class java.lang.reflect.parameterizedtype Error
//        this.entityClass = (Class<E>)((ParameterizedType)this.getClass().getGenericSuperclass())
//                .getActualTypeArguments()[0];
    }
    public Class<E> getEntityClass(){
        return entityClass;
    }

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
