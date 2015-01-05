class LongConstants {
    public static void main(String[] args) {
        long i1 = 1000000000000L;
        long i2 = 1_000_000_000_000L;
        long i3 = 0x1fff_0000_0000_0000L;
        long i4 = 0b01000000_00000000_00000000_00000000_10000000L;

        System.out.println("i1=" + i1);
        System.out.println("i2=" + i2);
        System.out.println("i3=" + i3);
        System.out.println("i4=" + i4);
    }
}

