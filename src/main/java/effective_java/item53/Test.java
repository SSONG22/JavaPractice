package effective_java.item53;

/*
https://docs.oracle.com/javase/8/docs/technotes/guides/language/varargs.html
* */
public class Test {
    // 간단한 테스트 프레임 워크
    public static void main(String[] args) {
        int passed = 0;
        int failed = 0;
        for (String className : args) {
            try {
                Class c = Class.forName(className);
                c.getMethod("Test").invoke(c.newInstance());
                passed++;
            } catch (Exception ex) {
                System.out.printf("%s failed: %s%n", className, ex);
                failed++;
            }
        }
        System.out.printf("passed=%d; failed=%d%n", passed, failed);
    }
}
