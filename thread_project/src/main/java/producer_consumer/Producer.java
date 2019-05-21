package producer_consumer;

public class Producer extends Thread {
    private Bucket bucket;

    public Producer(Bucket bucket) {
        this.bucket = bucket;
    }

    public void run() {
        try {
            for (int i = 0; i < 10; i++) {
              bucket.setValue(i);
              Thread.sleep(100);
            }
        } catch (Exception e) {
            System.out.println("producer>>> " + e.getMessage());
        }

    }
}
