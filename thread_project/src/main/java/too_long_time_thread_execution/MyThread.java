package too_long_time_thread_execution;

public class MyThread extends Thread {

    public void run() {
        for (; ; ) {
            System.out.println(Thread.currentThread().getName());
        }
    }
}
