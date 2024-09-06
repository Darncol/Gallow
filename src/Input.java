import java.util.Scanner;

class Input {
    private static final Scanner scanner = new Scanner(System.in);

    static String get() {
        boolean valid = false;
        String chekedChar = "";

        do {
            Render.inputChar();
            String input = scanner.nextLine().toLowerCase();

            if (input.length() == 1) {
                chekedChar = input;
                valid = true;
            } else {
                Render.invalidChar();
            }

        } while (!valid);

        return chekedChar;
    }
}

