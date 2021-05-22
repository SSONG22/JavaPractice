package effective_java.item15;

public class Main {
    public static void main(String[] args) {
        StaticNestedClass Outer = new StaticNestedClass();
        Outer.setOuter("outer");
//        StaticNestedClassInner 클래스는 외부에서 부를 수 없다.
        StaticNestedClass.StaticNestedClassInner2 = new StaticNestedClass.StaticNestedClassInner2();
    }
}
