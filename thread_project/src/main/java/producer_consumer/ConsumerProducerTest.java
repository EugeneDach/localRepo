package producer_consumer;

public class ConsumerProducerTest {
    public static void main(String[] args) {
        Bucket bucket = new Bucket();
        Consumer consumer = new Consumer(bucket);
        Producer producer = new Producer(bucket);
        producer.start();
        consumer.start();
    }
}
