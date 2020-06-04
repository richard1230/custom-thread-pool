package tuJieJavaMultiThread.Ch00Introduction1.Thread_StartUp.startUpByRunnable;

public class Main {
    public static void main(String[] args) {
        new Thread(new Printer("Good!")).start();
        new Thread(new Printer("Nice!")).start();
    }
}

