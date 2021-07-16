package reflection.annotation;

import reflection.getClass.Book;
import reflection.getClass.MyBook;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // 아무값도 출력하지 않는다.
//        Arrays.stream(Book.class.getAnnotations()).forEach(System.out::println);
//        Arrays.stream(Book2.class.getAnnotations()).forEach(System.out::println);
//        Arrays.stream(MyBook.class.getAnnotations()).forEach(System.out::println);

        Arrays.stream(Book.class.getDeclaredFields()).forEach(f->{
            Arrays.stream(f.getAnnotations()).forEach(a->{
                if(a instanceof AnotherAnnotation){
                    AnotherAnnotation annotation = (AnotherAnnotation) a;
                    System.out.println(annotation.value());
                    System.out.println(annotation.name());
                }
            });
        });
    }
}
