package reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

public class Reflection02 {
    public static void main(String[] args) {
        // 클래스를 얻는 방법
        // 1. 직접 선언
        Class<Book> bookClass = Book.class;

        // 2. getClass()
        Book book = new Book();
        Class<? extends Book> bookClassFromInstance = book.getClass();

        //3. Class.forName()
        try {
            Class<?> bookClassFromPackageString = Class.forName("reflection");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        // 값 접근 방법
        System.out.println("----------------Fields---------------");
        getClassField(bookClass);
        System.out.println("----------------Methods---------------");
        getClassMethod(bookClass);
        System.out.println("----------------Constructors---------------");
        getClassConstructors(bookClass);
        System.out.println("----------------SuperClass---------------");
        getSuperClass();
        System.out.println("----------------Interface---------------");
        getImplementsInterface();
    }

    public static void getClassField(Class<Book> bookClass) {
        // 클래스에 선언된 필드를 반환 (public 접근지시자만)
        Field[] fields = bookClass.getFields();
        Arrays.stream(fields).forEach(System.out::println);

        // name 에 해당하는 필드를 반환
        try {
            Field field = bookClass.getField("b");
            System.out.println(field);
        } catch (NoSuchFieldException e) {
            e.printStackTrace(); // 없으면 NoSuchFieldException
        }

        // 클래스에 선언된 모든 필드들 반환 (private 포함)
        Field[] allFields = bookClass.getDeclaredFields();
        Book book = new Book();
        Arrays.stream(allFields).forEach(f -> {
            try {
                // private, protected 에 접근하려고 하는 경우 IllegalAccessException 발생
                f.setAccessible(true); // 접근지시자 무시
                System.out.printf(f + " " + f.get(book));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        });

        // Modifier 를 이용한 필드 제어자 확인
        Arrays.stream(allFields).forEach(f -> {
            int modifiers = f.getModifiers();
            System.out.printf("[%s]\n", f);
            System.out.println("abstract : "+Modifier.isAbstract(modifiers));
            System.out.println("public : "+Modifier.isPublic(modifiers));
            System.out.println("private : "+ Modifier.isPrivate(modifiers));
            System.out.println("final : "+Modifier.isFinal(modifiers));
            System.out.println("static : "+Modifier.isStatic(modifiers));
        });

        // name 에 해당하는 필드를 반환
        try {
            Field field = bookClass.getDeclaredField("b");
            System.out.println(field);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

    public static void getClassMethod(Class<Book> bookClass) {
        Method[] methods = bookClass.getMethods();
        // Object 상속 메소드 포함
        Arrays.stream(methods).forEach(System.out::println);
        // Modifier 를 이용한 메소드의 제거자 확인
        Arrays.stream(methods).forEach(m -> {
            System.out.printf("[%s]\n", m.getName());
            System.out.println(m.getReturnType());
            System.out.println(m.getDeclaredAnnotations()); // getDeclaredAnnotations, getExceptionTypes, getParameterTypes 는
            System.out.println(m.getExceptionTypes()); // Class<?>[] 배열 반환해서
            System.out.println(m.getParameterTypes()); // forEach 돌려서 확인해야함.
            System.out.println(m.getParameterCount());
        });
    }

    public static void getClassConstructors(Class<Book> bookClass) {
        Constructor[] constructors = bookClass.getConstructors();
        Arrays.stream(constructors).forEach(System.out::println);
    }

    public static void getSuperClass() {
        Class<? super MyBook> superClass = MyBook.class.getSuperclass();
        System.out.println(superClass);
    }

    public static void getImplementsInterface() {
        Class<?>[] implementsInterface = MyBook.class.getInterfaces();
        Arrays.stream(implementsInterface).forEach(System.out::println);
    }
}
