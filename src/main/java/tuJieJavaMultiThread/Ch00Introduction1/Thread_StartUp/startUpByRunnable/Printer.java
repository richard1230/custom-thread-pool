package tuJieJavaMultiThread.Ch00Introduction1.Thread_StartUp.startUpByRunnable;

public class Printer implements Runnable {
    private String message;

    public Printer(String message) {
        this.message = message;
    }

    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.print(message);
        }
    }
}
