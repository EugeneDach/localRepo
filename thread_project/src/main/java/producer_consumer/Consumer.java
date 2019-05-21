package producer_consumer;

public class Consumer extends Thread {
    private Bucket bucket;

    public Consumer(Bucket bucket) {
        this.bucket = bucket;
    }

    public void run() {
        try {
            for (int i = 0; i < 10; i++) {
                bucket.getValue();
            }
        } catch (Exception e) {
            System.out.println("consumer exception>>" + e.getMessage());
        }

    }
}
