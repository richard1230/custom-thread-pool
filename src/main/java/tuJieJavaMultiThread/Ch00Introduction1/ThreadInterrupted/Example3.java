package tuJieJavaMultiThread.Ch00Introduction1.ThreadInterrupted;

class Example3 extends Thread {

    volatile boolean stop = false;

    public static void main(String args[]) throws Exception {
        Example3 thread = new Example3();

        System.out.println("Starting thread...");
        thread.start();

        Thread.sleep(3000);

        System.out.println("Asking thread to stop...");

        /*
         * 如果线程阻塞，将不会检查此变量,调用interrupt之后，线程就可以尽早的终结被阻
         * 塞状 态，能够检查这一变量。
         * */
        thread.stop = true;

        /*
         * 这一方法实际上完成的是，在线程受到阻塞时抛出一个中断信号，这样线程就得以退
         * 出阻 塞的状态
         * */
        thread.interrupt();

        Thread.sleep(3000);
        System.out.println("Stopping application...");
        System.exit(0);
    }

    public void run() {
        while (!stop) {
            System.out.println("Thread running...");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                // 接收到一个中断异常（InterruptedException），从而提早地终结被阻塞状态
                System.out.println("Thread interrupted...");
            }
        }

        System.out.println("Thread exiting under request...");
    }
}

/*
 * 把握几个重点：stop变量、run方法中的sleep()、interrupt()、InterruptedException。串接起
 * 来就是这个意思：当我们在run方法中调用sleep（或其他阻塞线程的方法）时，如果线程阻塞的
 * 时间过长，比如10s，那在这10s内，线程阻塞，run方法不被执行，但是如果在这10s内，stop被
 * 设置成true，表明要终止这个线程，但是，现在线程是阻塞的，它的run方法不能执行，自然也就
 * 不能检查stop，所 以线程不能终止，这个时候，我们就可以用interrupt()方法了：我们在
 * thread.stop = true;语句后调用thread.interrupt()方法， 该方法将在线程阻塞时抛出一个中断
 * 信号，该信号将被catch语句捕获到，一旦捕获到这个信号，线程就提前终结自己的阻塞状态，这
 * 样，它就能够 再次运行run 方法了，然后检查到stop = true，while循环就不会再被执行，在执
 * 行了while后面的清理工作之后，run方法执行完 毕，线程终止。
 * */
