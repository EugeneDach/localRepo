package thread_numbers_generation;

public class MyRunnableThreadTest {
    public static void main(String[] args) {
        MyRunnableThread myRunnableThread = new MyRunnableThread();
       // myRunnableThread.run();
        new Thread(myRunnableThread).start();

    }
}
