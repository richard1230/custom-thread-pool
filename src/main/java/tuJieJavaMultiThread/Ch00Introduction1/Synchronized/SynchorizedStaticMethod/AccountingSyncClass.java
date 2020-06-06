package tuJieJavaMultiThread.Ch00Introduction1.Synchronized.SynchorizedStaticMethod;

public class AccountingSyncClass implements Runnable {

    static int i = 0;

    /**
     * 作用于静态方法,锁是当前class对象,也就是
     * AccountingSyncClass类对应的class对象
     */
    public static synchronized void increase() {
        i++;
    }

    /**
     * 非静态,访问时锁不一样不会发生互斥
     */
//    public synchronized void increase4Obj(){
//        i++;
//    }
    @Override
    public void run() {
        for (int j = 0; j < 1000000; j++) {
            increase();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        //new新实例
        Thread t1 = new Thread(new AccountingSyncClass());
        //new新实例
        Thread t2 = new Thread(new AccountingSyncClass());
        //启动线程
        t1.start();
        t2.start();

        t1.join();
        t2.join();
        System.out.println(i);
    }
}



/**
 * 由于synchronized关键字修饰的是静态increase方法，与修饰实例方法不同的是，
 * 其锁对象是当前类的class对象。注意代码中的increase4Obj方法是实例方法，
 * 其对象锁是当前实例对象，如果别的线程调用该方法，将不会产生互斥现象，
 * 毕竟锁对象不同，但我们应该意识到这种情况下可能会发现线程安全问题(操作了共享静态变量i)。
 * <p>
 * 这里有2地方需要理解一下:
 * 1:
 * Thread代表一个线程;
 * Runnable代表一个任务(里面有个run抽象方法),可以被任何线程锁执行
 *
 * 2:
 * 如果不写t1.join(t2.join)
 * 则返回的次数只有1329320等次数;
 * 如果t1.join和t2.join都不写
 * 则返回的次数极有可能为0
 * join的作用:
 * 等待当前线程终止之后才会执行下面的执行语句;
 * 即:
 * t.join()方法只会使主线程进入等待池并等待t线程执行完毕后才会被唤醒。
 * 并不影响同一时刻处在运行状态的其他线程
 *
 *
 */
