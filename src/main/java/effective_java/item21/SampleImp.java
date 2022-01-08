package effective_java.item21;

public class SampleImp {
    public static void main(String[] args) {
        new A().print();
        new B().print();
    }

}

class A implements SampleInterface{
}
class B implements SampleInterface{
}