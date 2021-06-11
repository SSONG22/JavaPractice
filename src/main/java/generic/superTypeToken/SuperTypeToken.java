package generic.superTypeToken;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

public class SuperTypeToken {
    static class Sup<T> {
        T value;
    }
    // NESTED CLASS -> INNER CLASS ?
//    static class Sub extends Sup<List<String>>{} //java.util.List<java.lang.String>

    public static void main(String[] args) throws Exception {
        /** LOCAL CLASS **/
//        class Sub extends Sup<List<String>> {} // 메소드 안에서 한번 사용하는거니까 익명클래스로 만들 수 있다.
//        Sub b = new Sub();

        /** ANONYMOUS CLASS **/
//        Sup b = new Sup<List<String>>(){}; // 익명클래스
        Type t = (new Sup<List<String>>(){}).getClass().getGenericSuperclass();
        ParameterizedType ptype = (ParameterizedType) t;
        System.out.println(ptype.getActualTypeArguments()[0]); // string
    }
}
