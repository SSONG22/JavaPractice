package effective_java.item1;

public interface FooInterface {
    static Factory getFoo() {
        return new Factory();
    } // 자바 9 부터 private static default 메서드를 쓸 수 있다.
}
/**
 * private static 메서드가 필요한 이유 ?
 * private 메서드가 필요한 이유와 동일하다.
 * 단지 static (scope) 일뿐
 */
