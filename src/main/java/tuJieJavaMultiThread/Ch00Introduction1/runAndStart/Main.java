package tuJieJavaMultiThread.Ch00Introduction1.runAndStart;

public class Main {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.start();
        for (int i = 0; i < 100; i++) {
            System.out.println("I am running in main thread");
        }
    }
}
