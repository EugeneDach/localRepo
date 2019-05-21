package diff_opinion;

public class EggThread {

    public static void main(String[] args) throws InterruptedException {
        HenThread henThread = new HenThread();
        henThread.start();

        for (int i = 0; i < 10; i++) {
            System.out.println("---->>> egg");
            Thread.sleep(100);
        }

        if (henThread.isAlive()) {
            henThread.join();
            System.out.println("winner is hen");
        } else {
            System.out.println("winner is egg");
        }
    }
}
