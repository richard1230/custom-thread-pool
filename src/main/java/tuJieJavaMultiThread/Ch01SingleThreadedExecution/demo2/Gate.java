package tuJieJavaMultiThread.Ch01SingleThreadedExecution.demo2;

public class Gate {
    private int counter = 0;
    private String name = "Nobody";
    private String address = "Nowhere";

    @Override
    public synchronized String toString() {
        return
                "No." + counter +
                ": '" + name + '\'' +
                ", " + address;
    }

    public synchronized void pass(String name, String address){
        this.counter++;
        this.name = name;
        try{
            Thread.sleep(1000);
        }catch(InterruptedException e){
        }
        this.address = address;
        check();
    }

    private void check(){
        if (name.charAt(0) != address.charAt(0)){
            System.out.println("***BROKEN***" + toString());
        }
    }
}
