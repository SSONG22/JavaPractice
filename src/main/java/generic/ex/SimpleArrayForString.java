package generic.ex;

public class SimpleArrayForString {
    private int size;
    private String[] elementData = new String[5];
    public void add(String value){
        elementData[size++] = value;
    }
    public String get(int size){
        return elementData[size];
    }
} // 좋은 해결 방법은 아니다.
