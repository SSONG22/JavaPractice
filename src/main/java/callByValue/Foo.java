package callByValue;

public class Foo {
    String s;

    Foo(String s) {
        this.s = s;
    }

    public void change(String change) {
        this.s = change;
    }

    public String get() {
        return s;
    }
}
