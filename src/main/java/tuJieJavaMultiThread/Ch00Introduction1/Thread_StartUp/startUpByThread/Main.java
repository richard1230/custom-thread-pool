package tuJieJavaMultiThread.Ch00Introduction1.Thread_StartUp.startUpByThread;

public class Main {
    public static void main(String[] args) {
        new PrintThread("Good!").start();
        new PrintThread("Nice!").start();
    }
}

