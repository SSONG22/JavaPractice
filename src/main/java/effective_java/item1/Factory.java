package effective_java.item1;

// 3. 반환 타입의 하위 객체를 반환할 수 있다. (유연성)
public class Factory {
    public static Factory getInstance(String args) {
        if ("A".equals(args)) {
            return new A();
        }
        return new B();
    }
}
