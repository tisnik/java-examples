class Switch3 {
    public static void main(String[] args) throws Exception {
        System.out.println("h: help   f: format disk  q: quit");

        char input = (char)System.in.read();

        switch (input) {
            case 'H':
            case 'h': System.out.println("Help ...");
                      break;
            case 'F':
            case 'f': System.out.println("Formatting / ...");
                      break;
            case 'Q':
            case 'q': System.out.println("Good bye ...");
                      break;
            default: System.out.println("Unknown option!");
                      break;
        }
        System.out.println(input);

    }
}

