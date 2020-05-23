package tuJieJavaMultiThread.Ch00Introduction1.runAndStart;

public class MyThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++){
            System.out.println("I am running in a run method and in MyThread");
        }
    }
}
