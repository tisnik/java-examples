public class Test implements TestMBean {

    private int value = 42;

    public void callMethod() {
        System.out.println("callMethod");
    }

    public String getName() {
        return "This is test";
    }

    public int getNumericValue() {
        System.out.println("Returning value: " + this.value);
        return this.value;
    }

    public void setNumericValue(int value) {
        System.out.println("Setting value: " + value);
        this.value  = value;
    }

}
