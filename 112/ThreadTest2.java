class ThreadType2 extends Thread {
    private int id;

    public ThreadType2(int id) {
        this.id = id;
        System.out.println("thread #" + id + " created");
    }

    // some intensive computation
    public int computeNthPrimeNumber(int n) {
        int prime, count;
        for(prime = 2, count = 0; count < n; prime++) {
            if (isPrimeNumber(prime)) {
                ++count;
            }
        }
        return prime-1;
    }

    private static boolean isPrimeNumber(int n) {
        for(int i = 2; i < n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    @Override
        public void run() {
            System.out.println("thread #" + this.id + " finishes, the result is: " + computeNthPrimeNumber(40000));
        }
}

public class ThreadTest2 {
    public static void main(String[] args) {
        for (int id = 0; id < 10; id ++) {
            new ThreadType2(id).start();
        }
    }
}

