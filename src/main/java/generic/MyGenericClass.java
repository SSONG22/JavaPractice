package generic;

public class MyGenericClass<T> {
    T element;

    void setElement(T element) {
        this.element = element;
    }

    T getElement() {
        return element;
    }
}
