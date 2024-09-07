class Renderer {
    static void displayInfo(int mistakes, StringBuilder wordToRender) {
        System.out.println("Mistakes left: " + mistakes);
        displayWord(wordToRender);
    }

    static void displayStartInfo() {
        System.out.println("Hello lets start the game !");
        System.out.println();
    }

    static void displayWord(StringBuilder word) {
        StringBuilder hiddenWord = new StringBuilder();

        for (int i = 0; i < word.length(); i++) {
            char character = word.charAt(i);
            hiddenWord.append("|").append(character).append("|");
        }

        System.out.println(hiddenWord);
    }

    static void freeSpace() {
        for (int i = 0; i < 100; i++) {
            System.out.println();
        }
    }

    static void askRestart() {
        System.out.println("Press y for restart");
    }

    static void inputChar() {
        System.out.print("Input character: ");
    }

    static void invalidChar() {
        System.out.println("Invalid character !");
    }

    static void displayGallows(int attemptsLeft) {
        char[][] hangman = {
                {' ', '_', '_', '_', '_', '_', '_', '_'},
                {' ', '|', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
                {' ', '|', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', '|', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', '|'},
                {'_', '|', '_', '_', '_', '_', '_', '_'}
        };

        switch (attemptsLeft) {
            case 6:
                hangman[2][8] = 'O';
                break;
            case 5:
                hangman[2][8] = 'O';
                hangman[3][7] = '/';
                break;
            case 4:
                hangman[2][8] = 'O';
                hangman[3][7] = '/';
                hangman[3][8] = '|';
                break;
            case 3:
                hangman[2][8] = 'O';
                hangman[3][7] = '/';
                hangman[3][8] = '|';
                hangman[3][9] = '\\';
                break;
            case 2:
                hangman[2][8] = 'O';
                hangman[3][7] = '/';
                hangman[3][8] = '|';
                hangman[3][9] = '\\';
                hangman[4][8] = '|';
                break;
            case 1:
                hangman[2][8] = 'O';
                hangman[3][7] = '/';
                hangman[3][8] = '|';
                hangman[3][9] = '\\';
                hangman[4][8] = '|';
                hangman[5][7] = '/';
                break;
            case 0:
                hangman[2][8] = 'O';
                hangman[3][7] = '/';
                hangman[3][8] = '|';
                hangman[3][9] = '\\';
                hangman[4][8] = '|';
                hangman[5][7] = '/';
                hangman[5][9] = '\\';
                break;
            default:
                break;
        }

        for (char[] chars : hangman) {
            for (char aChar : chars) {
                System.out.print(aChar);
            }
            System.out.println();
        }
    }
}