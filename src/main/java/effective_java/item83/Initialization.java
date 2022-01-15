package effective_java.item83;

public class Initialization {

    // 일반 초기화
    private final FieldType field1 = computeFieldValue();

    // 지연 초기화가 초기화 순환성을 깨뜨릴 것 같으면 synchronized 를 써라
    private FieldType field2;
    private synchronized FieldType getField2() {
        if (field2 == null)
            field2 = computeFieldValue();
        return field2;
    }

    // 정적 필드 지연 초기화 - 홀더 클래스 관용구
    private static class FieldHolder {
        static final FieldType field = computeFieldValue();
    }

    private static FieldType getField() { return FieldHolder.field; }


    // 이중 검사 관용구
    private volatile FieldType field4;
    // NOTE: The code for this method in the first printing had a serious error (see errata for details)!
    private FieldType getField4() {
        FieldType result = field4;
        if (result != null)    // First check (no locking)
            return result;

        synchronized(this) {
            if (field4 == null) // Second check (with locking)
                field4 = computeFieldValue();
            return field4;
        }
    }



    // Single-check idiom - can cause repeated initialization! - Page 334
    private volatile FieldType field5;

    private FieldType getField5() {
        FieldType result = field5;
        if (result == null)
            field5 = result = computeFieldValue();
        return result;
    }

    private static FieldType computeFieldValue() {
        return new FieldType();
    }
}