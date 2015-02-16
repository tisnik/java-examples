import java.lang.management.*;
import javax.management.*;

public class Main {
    public static void main(String[] args) throws Throwable {
        MBeanServer mbs = ManagementFactory.getPlatformMBeanServer(); 
        ObjectName name = new ObjectName("Test:type=Test"); 
        Test mbean = new Test(); 
        mbs.registerMBean(mbean, name); 
        System.out.println("Waiting forever...");
        Thread.sleep(Long.MAX_VALUE); 
    }
}
