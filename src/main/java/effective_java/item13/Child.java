package effective_java.item13;

public class Child extends Parent {

    @Override
    public void print() {
        System.out.println("child print " + name);
        name = "child";
    }

    @Override
    protected Child clone() {
        Child clone = (Child) super.clone();
        return clone;
    }
}
