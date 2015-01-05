class BitShifts {
    public static void main(String[] args) {
        int x = 10;
        int y = -10;

        int result1 = x <<  1;
        int result2 = x >>  1;
        int result3 = x >>> 1;
        int result4 = y <<  1;
        int result5 = y >>  1;
        int result6 = y >>> 1;

        System.out.println("x       = " + x);
        System.out.println("x <<  1 = " + result1);
        System.out.println("x >>  1 = " + result2);
        System.out.println("x >>> 1 = " + result3);

        System.out.println();

        System.out.println("y       = " + y);
        System.out.println("y <<  1 = " + result4);
        System.out.println("y >>  1 = " + result5);
        System.out.println("y >>> 1 = " + result6);
    }
}

