package generic.superTypeToken;

import java.lang.reflect.Type;
import java.lang.reflect.ParameterizedType;
import java.util.*;

public class SuperTypeSafe {
    static class TypeSafeMap {
        Map<TypeReference<?>, Object> map = new HashMap<>();


        <T> void put(TypeReference<T> tr, T value) {
            map.put(tr, value);
        }

        <T> T get(TypeReference<T> tr) {
            if (tr.type instanceof Class<?>)
                return ((Class<T>) tr.type).cast(map.get(tr));
            else
                return ((Class<T>) ((ParameterizedType) tr.type).getRawType()).cast(map.get(tr));
        }
    }

    // Sup 과 같음
    static class TypeReference<T> {
        Type type;

        public TypeReference() {
            Type stype = getClass().getGenericSuperclass();
            if (stype instanceof ParameterizedType) {
                this.type = ((ParameterizedType) stype).getActualTypeArguments()[0];
            } else throw new RuntimeException();
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass().getSuperclass() != o.getClass().getSuperclass()) return false;
            TypeReference<?> that = (TypeReference<?>) o;
            return type.equals(that.type);
        }

        @Override
        public int hashCode() {
            return Objects.hash(type);
        }
    }

    public static void main(String[] args) {
//        new TypeReference<String>() // runtimeException
//        TypeReference t = new TypeReference<String>() {
//        }; // class java.lang.String
//        System.out.println(t.type);

        // SUPER TYPE TOKEN
        TypeSafeMap m = new TypeSafeMap();
        // 익명 클래스를 만드는 것이 핵심
        m.put(new TypeReference<Integer>() {
        }, 1);
        m.put(new TypeReference<String>() {
        }, "String");
        m.put(new TypeReference<List<Integer>>() {
        }, Arrays.asList(1, 2, 3));
        m.put(new TypeReference<List<String>>() {
        }, Arrays.asList("1", "2", "3"));

        // equals hashcode 재정의 해야한다.
        System.out.println(m.get(new TypeReference<Integer>() {
        }));
        System.out.println(m.get(new TypeReference<String>() {
        }));
        System.out.println(m.get(new TypeReference<List<Integer>>() {
        }));
        System.out.println(m.get(new TypeReference<List<String>>() {
        }));
    }
}
