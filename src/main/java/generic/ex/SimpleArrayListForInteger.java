package generic.ex;

public class SimpleArrayListForInteger {
    private int size;
    private int[] elementData = new int[5];
    public void add(int value){
        elementData[size++] = value;
    }
    public int get(int size){
        return elementData[size];
    }
}
