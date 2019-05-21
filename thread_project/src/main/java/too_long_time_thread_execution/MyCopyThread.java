package too_long_time_thread_execution;

public class MyCopyThread extends Thread {

    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName());
        }
    }
}
