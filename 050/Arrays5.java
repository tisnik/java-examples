class Arrays5 {

    public static void main(String[] args) {
        int[][] array;

        array = new int[10][20];

        for (int i=0; i < array.length; i++) {
            for (int j=0; j < array[i].length; j++) {
                array[i][j] = (i+1)*(j+1);
            }
        }

        for (int[] vector : array) {
            for (int item : vector) {
                System.out.print(item + "\t");
            }
            System.out.println();
        }
    }

}

