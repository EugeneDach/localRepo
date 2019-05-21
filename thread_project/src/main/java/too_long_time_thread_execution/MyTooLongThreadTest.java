package too_long_time_thread_execution;

public class MyTooLongThreadTest {
    public static void main(String[] args) {
        MyCopyThread myCopyThread = new MyCopyThread();
        myCopyThread.start();

        MyThread myThread = new MyThread();
        myThread.setDaemon(true);
        myThread.start();
    }
}
