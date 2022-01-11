package effective_java.item38;

// 타입 안전 열거 패턴
public class TypeSafePattern {
    private final String type;

    public TypeSafePattern(String type) {
        this.type = type;
    }

    public static final TypeSafePattern TERMINAL = new TypeSafePattern("Terminal");
    public static final TypeSafePattern PROCESS = new TypeSafePattern("Process");
    public static final TypeSafePattern DECISION = new TypeSafePattern("Decision");
}
