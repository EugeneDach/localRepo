package thread_numbers_generation;

public class MyRunnableThread implements Runnable {
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + " -> " + i);
        }
    }
}
