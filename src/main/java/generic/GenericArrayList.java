package generic;

public class GenericArrayList<T> {
    private Object[] elementData = new Object[5];
    private int size;
    public void add(T value){
        elementData[size++] = value;
    }
    public T get(int idx){
        return (T) elementData[idx];
    }
}
