package effective_java.item84;

import java.util.concurrent.CountDownLatch;
import java.util.stream.IntStream;

/* https://imasoftwareengineer.tistory.com/100 */

public class CountDownLatchDemo {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatchDemo demo = new CountDownLatchDemo();
        demo.runWorkers();
    }

    private void runWorkers() throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(5); // 최대 5개의 쓰레드 동시 실행
        IntStream.range(0, 5)
                .mapToObj(i -> new Worker(i, countDownLatch))
                .map(Thread::new)
                .forEach(Thread::start);

        countDownLatch.await(); // 2. 이 줄 추가

        System.out.println("Done awaiting..");
    }

    public class Worker implements Runnable { //쓰레드
        private CountDownLatch countDownLatch;
        private int index;

        public Worker(final int index, final CountDownLatch countDownLatch) {
            this.index = index;
            this.countDownLatch = countDownLatch;
        }

        @Override
        public void run() {
            try {
                System.out.println("Starting thread... " + index);
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println("Finishing Thread... " + index);
                countDownLatch.countDown(); // 1. 이 줄 추가
            }
        }
    }
}
