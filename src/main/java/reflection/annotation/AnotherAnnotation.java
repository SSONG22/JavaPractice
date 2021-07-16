package reflection.annotation;

import java.lang.annotation.*;

// annotation 만들기
@Retention(RetentionPolicy.RUNTIME)
@Inherited // 상속이 되는 어노테이션
public @interface AnotherAnnotation {
    // 제한된 타입만 사용 가능
    String name() default "name";
    int number() default 100; // 기본값도 사용 가능

    String value() default "hi"; // value 라는 키워드를 쓰면 그냥 써도 된다.

}
