class DLThread extends Thread {
    String s1;
    String s2;

    public DLThread(String s1, String s2) {
        this.s1 = s1;
        this.s2 = s2;
    }

    public void run() {
        for (int i = 0; i < 10000; i++) {
            synchronized(this.s1) {
                synchronized(this.s2) {
                    System.out.println(this.s1+this.s2);
                }
            }
        }
    }
}

public class DeadLock
{
    public static void main(String[] args) {
        String s1 = "Dead";
        String s2 = "Lock";
        new DLThread(s1, s2).start();
        new DLThread(s2, s1).start();
    }
}

