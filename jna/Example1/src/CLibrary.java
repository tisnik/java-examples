import com.sun.jna.*;

public class CLibrary {
    static {
        System.out.println("Registering libc...");
        Native.register("c");
        System.out.println("Done");
    }
    native public int ioctl(int fd, int cmd, int[] arg);
}
