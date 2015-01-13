class Arrays4 {

    public static void main(String[] args) {
        int[][] array;

        array = new int[10][20];

        for (int i=0; i < array.length; i++) {
            for (int j=0; j < array[i].length; j++) {
                array[i][j] = (i+1)*(j+1);
            }
        }

        for (int i=0; i < array.length; i++) {
            for (int j=0; j < array[i].length; j++) {
                System.out.print(array[i][j] + "\t");
            }
            System.out.println();
        }
    }

}

