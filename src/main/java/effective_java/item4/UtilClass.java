package effective_java.item4;

public class UtilClass {

    // 유틸 클래스가 인스턴스를 만들지 못하게 막았습니다.
    private UtilClass() {
        throw new AssertionError();
    }

    public static String getName() {
        return "name";
    }

    public static void main(String[] args) {
        UtilClass.getName();
    }
}
