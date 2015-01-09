class DoWhileLoop3 {
    public static void main(String[] args) throws Exception {
        int i = 1;

        do {
            int j = 1;
            do {
                System.out.print(i*j);
                System.out.print('\t');
                j++;
            } while (j <= 10);
            i++;
            System.out.println();
        } while (i <= 10);
    }
}

