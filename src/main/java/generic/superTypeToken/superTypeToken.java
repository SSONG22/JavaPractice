package generic.superTypeToken;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

public class superTypeToken {
    static class Sup<T> {
        T value;
    }
    // LOCAL CLASS
    public static void main(String[] args) throws Exception {
        class Sub extends Sup<List<String>> {}
        Sup s = new Sup<String>(); // 호환성 문제때문에 정보를 삭제한다.
        Sup b = new Sub();
        Type t = b.getClass().getGenericSuperclass(); // Sup<String>
        ParameterizedType ptype = (ParameterizedType) t;
        System.out.println(ptype.getActualTypeArguments()[0]); // string
    }
}
