package effective_java.item41.example2;

public class MyImpl implements TestInterface{
    public static void main(String[] args) {
        MyImpl my = new MyImpl();
        System.out.println(my.getClass().isAnnotationPresent(SongI.class));
    }
}
