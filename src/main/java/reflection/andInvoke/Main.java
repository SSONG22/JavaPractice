package reflection.andInvoke;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {
        Class<?> bookClass = Class.forName("reflection.andInvoke.Book");
        // newInstance 는 쓰지말자, 권장- constructor 사용
//        Constructor<?> constructor = bookClass.getConstructor(null);
//        Book book = (Book) constructor.newInstance();
        Constructor<?> constructor = bookClass.getConstructor(String.class);
        Book book = (Book) constructor.newInstance("myBook");
        System.out.println(book);

        Field a = Book.class.getDeclaredField("A");
        // static 하기 때문에 null 을 넘겨주면 된다.
        System.out.println(a.get(null));
        a.set(null, "AAAAA");
        System.out.println(a.get(null));

        Field b = Book.class.getDeclaredField("B");
        b.setAccessible(true); // private 접근 지시자 무시
        System.out.println(b.get(book)); // 인스턴스가 있어야지 사용가능한 필드기 때문에 null 사용불가
        b.set(book, "BBBBB");
        System.out.println(b.get(book));

        Method c = Book.class.getDeclaredMethod("c");
        c.setAccessible(true);
        // 실행할때 invoke
        c.invoke(book); // 특정 인스턴스의 메소드면 그 인스턴스를 넘겨줘야 한다, 메서드에 필요한 파라미터도 넘겨준다.

        Method sum = Book.class.getDeclaredMethod("sum", int.class, int.class); // int/Integer 구분한다.
        int invoke = (int) sum.invoke(book, 1, 2); // 특정 인스턴스의 메소드면 그 인스턴스를 넘겨줘야 한다, 메서드에 필요한 파라미터도 넘겨준다.
        System.out.println(invoke);

    }
}
