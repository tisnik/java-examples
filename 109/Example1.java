public class Example1 {
    public static native void foo();

    public static void main(String[] args) {
        System.loadLibrary("bar");
        foo();
    }
}

