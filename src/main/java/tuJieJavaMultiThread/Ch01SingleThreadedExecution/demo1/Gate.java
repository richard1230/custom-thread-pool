package tuJieJavaMultiThread.Ch01SingleThreadedExecution.demo1;

public class Gate {
    private int counter = 0;
    private String name = "Nobody";
    private String address = "Nowhere";

    @Override
    public String toString() {
        return
                "No." + counter +
                ": '" + name + '\'' +
                ", " + address;
    }

    public void pass(String name, String address){
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
