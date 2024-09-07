import java.util.Scanner;

class Input {
    private static final Scanner scanner = new Scanner(System.in);

    static String get() {
        boolean valid = false;
        String chekedChar = "";

        do {
            Renderer.inputChar();
            String input = scanner.nextLine().toLowerCase();

            if (input.length() == 1) {
                chekedChar = input;
                valid = true;
            } else {
                Renderer.invalidChar();
            }

        } while (!valid);

        return chekedChar;
    }
}

