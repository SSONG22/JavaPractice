package effective_java.item13;

public class Parent implements Cloneable {
    String name;

    Parent() {
        name = "parent";
    }

    public void print() {
        System.out.println("parent print "+name);
    }

    @Override
    protected Parent clone() {
        try {
            print();
            return (Parent) super.clone();
        }catch (CloneNotSupportedException e){
            throw new RuntimeException();
        }
    }
}
