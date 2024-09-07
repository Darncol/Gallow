import java.util.Scanner;

class Input {
    private static final Scanner scanner = new Scanner(System.in);

    static String getLetter() {
        String chekedChar;

        Renderer.inputChar();
        String input = scanner.nextLine().toLowerCase();

        if (input.length() == 1) {
            chekedChar = input;
        } else {
            Renderer.invalidChar();
            chekedChar = getLetter();
        }

        return chekedChar;
    }
}

