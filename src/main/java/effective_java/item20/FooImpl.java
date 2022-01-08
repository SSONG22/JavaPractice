package effective_java.item20;

// simulated multiple inheritance
public class FooImpl implements FooInterface {
    private FooImplInner fooImplInner = new FooImplInner();

    @Override
    public void test() {
        System.out.println("FooImpl 인터페이스를 구현한 클래스");
        fooImplInner.test(); // inner class 는 어떻게 관리해야 할까
    }

    private class FooImplInner extends FooImpl {
        @Override
        public void test() {
            // 상세 구현
            // 메서드 호출을 내부 클래스의 인스턴스에 전달한다.
            System.out.println("FooImplInner 메서드 상세 구현 ");
        }
    }
}
