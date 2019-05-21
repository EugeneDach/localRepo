package producer_consumer;

public class Bucket {

    private boolean wasChangedValue;
    private int value;

    //метод для consumer(потребителя)
    synchronized public int getValue() throws InterruptedException {
        if(!wasChangedValue) {
            wait();
        }
        System.out.println("get>>>>" + value);
        wasChangedValue = false;
        notifyAll();
        return value;
    }

    synchronized public void setValue(int value) throws InterruptedException {
        if(wasChangedValue) {
            wait();
        }
        wasChangedValue = true;
        this.value = value;
        System.out.println("set>>>" + value);
        notifyAll();//все потребители которые
        // ждут новое значение (value) -> должны проснуться
    }
}
