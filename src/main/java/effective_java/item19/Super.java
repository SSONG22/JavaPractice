package effective_java.item19;

public class Super {

    // 잘못된 예: 생성자가 재정의 기능 메서드를 호출한다.
    public Super(){
        overrideMe();
    }

    public void overrideMe() {
    }
}
