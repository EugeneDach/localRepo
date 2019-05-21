package counter_test;

import java.util.HashMap;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockTest {

    public static void main(String[] args) throws InterruptedException {
       final HashMap<String, String> map = new HashMap<String, String>();
       final ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

        Thread threadWriter = new Thread() {
            public void run() {
                readWriteLock.writeLock().lock();
                try {
                    Thread.sleep(100);
                    map.put("new key", "new value");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    readWriteLock.writeLock().unlock();
                }
            }
        };

        Thread threadReader = new Thread() {
            public void run() {
                readWriteLock.readLock().lock();
                try {
                    String result = map.get("new key");
                    System.out.println(result);
                    Thread.sleep(100);
                } catch (Exception e) {
                    e.printStackTrace();
                }finally {
                    readWriteLock.readLock().unlock();
                }
            }
        };
        threadWriter.start();
        threadReader.start();

        Thread.sleep(300);


    }
}
