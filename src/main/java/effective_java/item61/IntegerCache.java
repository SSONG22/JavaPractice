package effective_java.item61;

public class IntegerCache {
    /* https://www.geeksforgeeks.org/java-integer-cache/ */
    public static void main(String[] args) {
        Integer a = 9;
        Integer b = 9;
        // Java 는 -128 에서 127 까지 범위의 정수를 캐싱한다.
        // autoboxing(int->Integer)일 때만 캐싱이 적용된다.

        if (a == b) {
            System.out.println("a==b");
        } else {
            System.out.println("a!=b");
        }
        // a == b

        // -128 ~ 127 범위가 아니면
        Integer x = 396;
        Integer y = 396;
        if (x == b) {
            System.out.println("x==y");
        } else {
            System.out.println("x!=y");
        }
        // x!=y
        // Java 5에서는 메모리를 절약하고, Integer 유형 객체 처리 성능을 향상시키는 새로운 기능이 도입되었다.
        // 정수 개체는 내부적으로 캐싱되고 동일한 참조 객체를 통해 재사용된다.
        // IntegerCache 클래스에서 해당 내용을 알 수 있다.
    }
}
