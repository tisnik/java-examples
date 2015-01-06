class TernaryOperator3 {
    public static void main(String[] args) {
        int x = -10;
        //int x =   0;
        //int x =  10;

        String res = x < 0 ? "negative" : x > 0 ? "positive" : "zero";

        System.out.println("x is " + res);
    }
}

