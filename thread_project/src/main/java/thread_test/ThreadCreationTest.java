package thread_test;

public class ThreadCreationTest {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName());
        new MyThread().run();
        new MyThread().start();


    }
}


class MyThread extends Thread {
    public void run() {
        System.out.println("Hello my name is " + this.getName() +
                " " + Thread.currentThread().getName());
    }
}
