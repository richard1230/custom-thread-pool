package tuJieJavaMultiThread.Ch00Introduction1.Synchronized.ReentrancyOfSynchorized;

public class AccountingSync implements Runnable {
    static AccountingSync instance = new AccountingSync();
    static int i = 0;
    static int j = 0;

    @Override
    public void run() {
        for (int j = 0; j < 5; j++) {

            //this,当前实例对象锁
            synchronized (this) {
                i++;
                increase(); //synchronized的可重入性
            }
        }
    }

    private synchronized void increase() {
        j++;
    }


    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(instance);
        Thread t2 = new Thread(instance);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(i);
        System.out.println(j);

    }
}


/**
 * 这里有两个实例,
 * 每个实例都使得i,j加5
 * 最终输出结果:
 * i:10
 * j:10
 */
