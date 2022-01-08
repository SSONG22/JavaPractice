package effective_java.item21;

public interface SampleInterface {
    default void print() {
        System.out.println("default method");
    }
}
