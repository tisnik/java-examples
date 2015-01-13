class Arrays3 {

    public static void main(String[] args) {
        int[] array;

        array = new int[10];

        for (int i=0; i<array.length; i++) {
            array[i] = i*2;
        }

        for (int item : array) {
            System.out.println(item);
        }
    }

}

