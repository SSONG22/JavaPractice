package generic.recursiveTypeBound;

import java.util.Collection;

/*https://cla9.tistory.com/51 참고*/
public class Example {
    //step 1.
    /*
    public static <T> T max(Collection<T> cols){
        // compareTo 메소드를 사용하기 위해서는 해당 클래스의 Comparable 인터페이스가 구현되어야 한다.
        // 하지만 T 타입에는 어떤 타입도 허용가능하므로 문제가 발생할 수 있다. <- 따라서 허용되지 않는다.
        // 이 문제를 해결하기 위해 Comparable 인터페이스가 구현된 타입만 지정되도록 경계를 정의해야 한다.
        // return cols.stream().max((o1, o2) -> o1.compareTo(o2)).get(); // 컴파일 에러
    }
    */
    // step 2
    public static <T extends Comparable<T>> T max1(Collection<T> cols) {
        // 메서드 레벨에서 타입 경계를 Comparable로 지정하면 Comparble SubType만 지정 될 수 있다.
        return cols.stream().max((o1, o2) -> o1.compareTo(o2)).get();
    }

    // step 3 GET and Put 원리 적용
    public static <T extends Comparable<? super T>> T max2(Collection<? extends T> cols) {
        // Collection 내부에서 바깥으로 T의 SubType을 꺼낸다.
        return cols.stream().max((o1,o2) -> o1.compareTo(o2)).get();
    }

    // step 4 Method Reference :: 적용
    public static <T extends Comparable<? super T>> T max(Collection<? extends T> cols){
        return cols.stream().max(T::compareTo).get();
    }
}
