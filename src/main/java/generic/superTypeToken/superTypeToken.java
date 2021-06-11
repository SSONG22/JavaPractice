package generic.superTypeToken;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

public class superTypeToken {
    static class Sup<T> {
        T value;
    }
    // NESTED CLASS -> INNER CLASS ?
    // LOCAL CLASS
    public static void main(String[] args) throws Exception {
//        class Sub extends Sup<String> {} // 서브 클래스
        Sup b = new Sup<String>(); // 익명 클래스
        Type t = b.getClass().getGenericSuperclass(); // Sup<String>
        ParameterizedType ptype = (ParameterizedType) t;
        System.out.println(ptype.getActualTypeArguments()[0]); // string
    }
}
