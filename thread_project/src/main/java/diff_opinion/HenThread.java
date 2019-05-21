package diff_opinion;

public class HenThread extends Thread {

    public void run() {
        try {
            for (int i = 0; i < 10; i++) {
                System.out.println("->>> hen");
                Thread.sleep(100);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
