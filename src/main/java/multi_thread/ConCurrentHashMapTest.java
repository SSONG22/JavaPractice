package multi_thread;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.LongAdder;

/*http://blog.breakingthat.com/2019/04/04/java-collection-map-concurrenthashmap/*/
public class ConCurrentHashMapTest {
    public static void main(String[] args) {
        int loopSize = 30;
        CountDownLatch countDownLatch = new CountDownLatch(loopSize);
        ExecutorService tp = Executors.newFixedThreadPool(10);

        Map<String, LongAdder> testMap = new ConcurrentHashMap<>();

        for (int i = 0; i < loopSize; i++) {
            int selector = (i % 3);
            String type = (selector == 0) ? "HR" : (selector == 1) ? "SALES" : "IT";
            tp.submit(new Runner(type, countDownLatch, testMap));
        }

        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(testMap.toString());
        tp.shutdown();
    }

    static class Runner implements Runnable {
        private final String runnerNo;
        private final CountDownLatch countDownLatch;
        private Map<String, LongAdder> testMap;

        Runner(String runnerNo, CountDownLatch countDownLatch, Map<String, LongAdder> testMap) {
            this.runnerNo = runnerNo;
            this.countDownLatch = countDownLatch;
            this.testMap = testMap;
        }

        @Override
        public void run() {
            try {
                testMap.computeIfAbsent(runnerNo, (value) -> new LongAdder()).increment();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                countDownLatch.countDown();
            }

        }
    }
}

// {HR=6, IT=7, SALES=8}, {HR=7, IT=8, SALES=9}, {HR=7, IT=7, SALES=7}
// {HR=10, IT=10, SALES=10}, {HR=10, IT=10, SALES=10}, {HR=10, IT=10, SALES=10}