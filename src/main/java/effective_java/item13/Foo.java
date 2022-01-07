package effective_java.item13;

public class Foo implements Cloneable {

    public Foo() {
        System.out.println("constructor");
    }

    @Override
    protected Foo clone() throws CloneNotSupportedException {
        System.out.println("clone");
        return (Foo) super.clone();
    }
}
