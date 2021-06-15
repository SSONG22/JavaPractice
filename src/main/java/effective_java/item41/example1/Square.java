package effective_java.item41.example1;

public class Square extends Rectangle {

    public static void main(String[] args) {
        Square s = new Square();
        System.out.println(s.getArea());
        System.out.println(s instanceof DeletableShape);
    }
}
