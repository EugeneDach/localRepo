package thread_numbers_generation;

public class MyThreadTest {
    public static void main(String[] args) throws InterruptedException {
        MyThread myThread1 = new MyThread();//THREAD-0
        MyThread myThread2 = new MyThread();//THREAD-1
        myThread1.start();
        myThread1.join();
        //myThread1.setPriority();
        myThread2.start();
    }
}
