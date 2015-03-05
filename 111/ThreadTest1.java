class ThreadType1 extends Thread {
    private int id;
    private int counter = 5;

    public ThreadType1(int id) {
        this.id = id;
        System.out.println("thread #" + id + " created");
    }

    @Override
        public void run() {
            while (this.counter > 0) {
                try {
                    System.out.println("thread #" + this.id + " counter: " + this.counter);
                    Thread.sleep(100);
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
                this.counter--;

            }
    }
}

public class ThreadTest1 {
    public static void main(String[] args) {
        for (int id = 0; id < 10; id ++) {
            new ThreadType1(id).start();
        }
    }
}

