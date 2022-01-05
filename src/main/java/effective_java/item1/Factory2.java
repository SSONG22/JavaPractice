package effective_java.item1;

// 4. 입력 매개 변수에 따라 매번 다른 클래스의 객체를 반환할 수 있다.
public abstract class Factory2 {
//    private Factory2() {
//    } // 단점. 상속을 하려면 생성자는 public 이거나 protected 여야 한다.

    protected Factory2(){

    }
    public static Factory2 getInstance(String arg) {
        return new A2();
    }

    public static Factory2 getInstance(String arg1, String arg2) {
        return new B2();
    }

}

class A2 extends Factory2 {

}

class B2 extends Factory2 {
}
