package ThreadBasic;

public class HowToCreateThread {
    static class MyThread extends Thread {
        @Override
        public void run() {
            System.out.println("I am created by extends thread");
        }
    }

    static class MyRun implements Runnable {

        @Override
        public void run() {
            System.out.println("I am created by implement Runnable");
        }
    }


    public static void main(String[] args) {

        new MyThread().start();

        new Thread(new MyRun()).start();

        new Thread(() -> {
            System.out.println("I am create by lambda");
        }).start();
    }
}
