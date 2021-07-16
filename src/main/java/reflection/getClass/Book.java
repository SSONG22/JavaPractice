package reflection.getClass;

import reflection.annotation.AnotherAnnotation;
import reflection.annotation.MyAnnotation;

@MyAnnotation(name = "Book", number = 1)
public class Book {
    private static String B = "BOOK";

    private static final String C = "BOOK";

    private String a = "a";

    @AnotherAnnotation
    public String d = "d";

    protected String e = "e";

    public Book(){}

    @AnotherAnnotation
    public Book(String a, String d, String e) {
        this.a = a;
        this.d = d;
        this.e = e;
    }
    private void f(){
        System.out.println("F");
    }
    @AnotherAnnotation
    public void g(){
        System.out.println("g");
    }
    public int h(){
        return 100;
    }
}
