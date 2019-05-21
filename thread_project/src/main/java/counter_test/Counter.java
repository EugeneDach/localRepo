package counter_test;

import java.util.concurrent.locks.ReentrantLock;

public class Counter {
    private int i;
    private ReentrantLock reentrantLock = new ReentrantLock();

    public int getI() {
        return i;
    }

    public void increment() {
        reentrantLock.lock();
        try {
            this.i++;
        }finally {
            reentrantLock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        final Counter counter = new Counter();

        Thread thread1 = new Thread() {
            public void run() {
                for (int i = 0; i < 100; i++) {
                    counter.increment();
                }
            }
        };

        Thread thread2 = new Thread() {
            public void run() {
                for (int i = 0; i < 100; i++) {
                    counter.increment();
                }
            }
        };
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();

        System.out.println(counter.getI());
    }
}
