package effective_java.item41.example1;

public class Rectangle implements DeletableShape {
    // interface Shape 를 상속 받은 DeletableShape 이기 때문에
    // 다형성을 활용할 수 있다.
    @Override
    public double getArea() {
        return 0;
    }

    @Override
    public double getCircumference() {
        return 0;
    }

    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle();
        System.out.println(rectangle instanceof DeletableShape);
    }
}
