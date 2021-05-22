package effective_java.item15;

public class StaticNestedClass {
    /*
        중첩 클래스 (Static Nested Class)
        클래스 선언 안에 또 다른 클래스 선언이 있는 상태
        정적 멤버로 등록된 중첩 클래스
        */
    private String outer;

    public void setOuter(String outer) {
        this.outer = outer;
    }

    private static class StaticNestedClassInner {
        private String inner;

        public void setInner(String inner) {
            this.inner = inner;
        }
    }

    public static Object StaticNestedClassInner2;
    public static class StaticNestedClassInner2{
        private String inner;

        public void setInner(String inner) {
            this.inner = inner;
        }
    }
}
