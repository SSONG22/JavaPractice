package callByValue;

public class CallBy {
    public static void main(String[] args) {
        Foo foo = new Foo("foo");

        changeReference(foo);
        System.out.println(foo.get()); // foo

        modifyReference(foo);
        System.out.println(foo.get()); // change
        // 주소 "값" 으로 전달해 실제 참조가 아닌 변수의 복사본으로 전달한다.

        setNull(foo);
        System.out.println(foo.get()); // change NPE 가 발생하지 않는다.
    }

    private static void setNull(Foo d){
        d = null;
        // 참조 사본만 전달하기 때문에 NPE 가 발생하지 않는다.
    }

    private static void modifyReference(Foo c) {
        // 참조변수 c 를 통해 객체의 내용이 수정된다.
        c.change("change");
    }

    private static void changeReference(Foo a) {
        Foo b = new Foo("other");
        a = b; // 참조 사본을 바꾸는 것뿐이다.
    }


}
