package effective_java.item1;

public abstract class Factory {
    public static Factory getInstance(String args) {
        if ("A".equals(args)) {
            return new A();
        }
        return new B();
    }
}
