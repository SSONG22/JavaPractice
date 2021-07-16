package reflection.andInvoke;

public class Book {
    public static String A = "A";
    private String B = "B";

    public Book(String b) {
        B = b;
    }
    public Book(){

    }
    private void c() {
        System.out.println("C");
    }

    public int sum(int left, int right) {
        return left + right;
    }
}
