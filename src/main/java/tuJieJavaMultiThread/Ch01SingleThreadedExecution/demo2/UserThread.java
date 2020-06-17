package tuJieJavaMultiThread.Ch01SingleThreadedExecution.demo2;

public class UserThread extends Thread {
    private final  Gate gate;
    private final String myname;
    private final String myaddress;

    public UserThread(Gate gate, String myname, String myaddress) {
        this.gate = gate;
        this.myname = myname;
        this.myaddress = myaddress;
    }

    public void run() {
        System.out.println(myname + " BEGIN");
        while (true) {
            gate.pass(myname, myaddress);
        }
    }
}



//*
//* Testing Gate, hit CTRL+C to exit.
// * Alice BEGIN
// * Bobby BEGIN
// * Chris BEGIN
// * ***BROKEN***No.4: 'Chris', Canada
// * ***BROKEN***No.4: 'Chris', Canada
// * ***BROKEN***No.6: 'Bobby', Canada
// * ***BROKEN***No.7: 'Chris', Alaska
// * ***BROKEN***No.7: 'Chris', Alaska
// * ***BROKEN***No.9: 'Alice', Brazil
// * ***BROKEN***No.9: 'Alice', Brazil
// * ***BROKEN***No.9: 'Alice', Brazil
// * ***BROKEN***No.12: 'Chris', Brazil
// * ***BROKEN***No.12: 'Chris', Brazil
// * ***BROKEN***No.12: 'Chris', Brazil
// * ***BROKEN***No.16: 'Alice', Brazil
// * ...
//*
//*
