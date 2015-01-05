class BitOperators {
    public static void main(String[] args) {
        int x = 0b0011;
        int y = 0b0101;

        int result1 = x & y;
        int result2 = x | y;
        int result3 = x ^ y;

        System.out.println("result1 = " + result1);
        System.out.println("result2 = " + result2);
        System.out.println("result3 = " + result3);
    }
}

