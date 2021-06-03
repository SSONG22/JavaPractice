package generic;

public class SimpleArrayList {
    private int size;
    private Object[] elementData = new Object[5];
    public void add(Object value){
        elementData[size++] = value;
    }
    public Object get(int idx){
        return elementData[idx];
    }
}// 좋은 해결 방법은 아니다.
