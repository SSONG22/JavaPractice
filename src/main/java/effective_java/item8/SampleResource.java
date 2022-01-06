package effective_java.item8;

import java.lang.ref.Cleaner;

public class SampleResource implements AutoCloseable {
    private static final Cleaner CLEANER = Cleaner.create();

    private boolean closed;

    private final Cleaner.Cleanable cleanable;
    private final ResourceCleaner resourceCleaner;

    public SampleResource() {
        this.resourceCleaner = new ResourceCleaner();
        this.cleanable = CLEANER.register(this, resourceCleaner);
    }

    @Override
    public void close() throws Exception {
        if (this.closed) {
            throw new IllegalStateException();
        }
        closed = true;
        cleanable.clean();
    }

    public void hello() {
        System.out.println("hello");
    }

    private static class ResourceCleaner implements Runnable {

        @Override
        public void run() {
            // 정리할 작업
            // ResourceCleaner는 정리할 대상인 인스턴스(SampleResource)를 참조하면 안된다.
            // 순환 참조가 생겨 GC 대상이 되질 못한다.
            System.out.println("Clean");
        }
    }
}
