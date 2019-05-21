package callable_test;

public class DeadLockTest {
    public static void main(String[] args) {
        final Object obj1 = new Object();
        final Object obj2 = new Object();

        Thread thread1 = new Thread() {
            public void run() {
                try {
                    synchronized (obj1) {
                        System.out.println("obj1 was synchronized by T1");
                        Thread.sleep(100);
                        synchronized (obj2) {
                            System.out.println("obj2 was synchronized by T1");
                        }

                    }
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        };

        Thread thread2 = new Thread() {
            public void run() {
                try {
                    synchronized (obj2) {
                        System.out.println("obj2 was synchronized by T2");
                        Thread.sleep(100);
                        synchronized (obj1) {
                            System.out.println("obj1 was synchronized by T2");
                        }
                    }
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        };

        thread1.start();
        thread2.start();
    }
}
