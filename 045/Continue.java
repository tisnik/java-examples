class Continue {

    public static void main(String[] args) {
        int i = 0;

        while (true) {  // endless loop
            i++;
            if (i % 2 == 1) continue;
            if (i >= 20) break;
            System.out.println(i);
        }
    }

}

