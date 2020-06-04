package tuJieJavaMultiThread.Ch00Introduction1.Thread_StartUp.StartupByJucThreadFactory;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

public class Main {
    public static void main(String[] args) {
        ThreadFactory factory = Executors.defaultThreadFactory();
        factory.newThread(new Printer("Nice!")).start();
        for (int i = 0; i < 1000; i++) {
            System.out.print("Good!");
        }
    }
}
