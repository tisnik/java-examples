class DecrementOperator {
    public static void main(String[] args) {
        int x = 10;
        int y = 10;

        System.out.println("old x = " + x);
        System.out.println("old y = " + y);

        int result1 = x--;
        int result2 = --y;

        System.out.println("result1 = " + result1);
        System.out.println("result2 = " + result2);

        System.out.println("new x = " + x);
        System.out.println("new y = " + y);
    }
}

