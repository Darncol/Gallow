import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Game game = new Game();
        game.startGame();
    }
}

class Game {
    boolean isWin = false;
    int mistakesLeft = 7;

    String word = Word.getRandom();
    String character = "";
    StringBuilder hiddenWord;

    void startGame() {
        hiddenWord = Word.hide(word);
        Render.StartInfo();

        while (mistakesLeft > 0) {
            Render.gallows(mistakesLeft);
            Render.info(mistakesLeft, hiddenWord);
            System.out.print("Input character: ");
            character = Input.get();
            check(character);

            chekVictoryCondition();

            Render.freeSpace();

            if (isWin) {
                System.out.println("CONGRATULATIONS YOU WIN !!!");
                break;
            }
        }

        if (!isWin) {
            Render.gallows(mistakesLeft);
            System.out.println("You LOSE !");
        }
    }

    private void check(String character) {
        boolean isCharFounded = false;

        for (int i = 0; i < word.length(); i++) {
            if (character.charAt(0) == word.charAt(i)) {
                hiddenWord.replace(i, i + 1, character);
                isCharFounded = true;
            }
        }

        decreaseMistakes(isCharFounded);
    }

    private void decreaseMistakes(boolean isCharFounded) {
        if (!isCharFounded) {
            --mistakesLeft;
        }
    }

    private void chekVictoryCondition() {
        if (word.contentEquals(hiddenWord)) {
            isWin = true;
        }
    }
}

class Input {
    private static final Scanner scanner = new Scanner(System.in);

    static String get() {
        boolean valid = false;
        String chekedChar = "";

        do {
            String input = scanner.nextLine();

            if (input.length() == 1) {
                chekedChar = input;
                valid = true;
            } else {
                System.out.println("Only 1 character !");
            }

        } while (!valid);

        return chekedChar;
    }
}

class Word {
    private static final String[] nouns = {
            "apple", "banana", "car", "dog", "elephant", "fish", "guitar", "house", "ice", "jungle",
            "kite", "lion", "mountain", "night", "ocean", "piano", "queen", "river", "star", "tree",
            "umbrella", "village", "whale", "xylophone", "yacht", "zebra", "actor", "bridge", "camera",
            "diamond", "engine", "flower", "garden", "hammer", "insect", "jacket", "key", "lamp",
            "mirror", "notebook", "orange", "pencil", "quilt", "robot", "squirrel", "telephone", "universe",
            "violin", "window", "yogurt", "ball", "cloud", "desk", "egg", "forest", "glass",
            "hat", "island", "jeep", "knife", "letter", "moon", "nest", "owl", "pearl", "ring",
            "ship", "tiger", "volcano", "watch", "x-ray", "year", "zipper", "angel", "beach",
            "cake", "dinosaur", "eagle", "farm", "ghost", "honey", "icecream", "jewel", "kangaroo", "lizard",
            "needle", "octopus", "pumpkin", "quiver", "rose", "snake", "turtle", "unicorn",
            "vulture", "whisker", "xenon", "yard", "zeppelin", "airplane", "book", "coin", "drum",
            "engineer", "feather", "giraffe", "horse", "igloo", "lemon", "microphone",
            "oyster", "planet", "quartz", "rabbit", "snow", "television", "ufo", "vase",
            "water", "arch", "bicycle", "cup", "doughnut", "envelope",
            "fountain", "helmet", "internet", "jelly", "ladder", "magnet",
            "nebula", "parrot", "question", "rocket", "stone",
            "train", "yak", "ant", "bottle", "cat", "doll",
            "globe", "joker", "paint", "rainbow", "spider",
            "tornado", "van", "yard", "zeppelin", "angle", "baker", "deer",
            "hill", "iguana", "nut", "plum", "squirrel",
            "trunk", "vine", "bench", "clown", "door", "fruit",
            "mouse", "robot", "straw", "archer", "bench", "clown", "door", "eagle",
            "angle", "archer", "bench", "clown", "door", "eagle", "fruit",
            "grape", "house", "igloo", "jelly", "kite", "ladder", "mouse", "nest", "owl",
            "plum", "quartz", "straw", "violin", "vulture", "window",
            "xenon", "yellow", "archer", "bench", "clown", "door",
            "fruit", "giraffe", "hat", "ice", "kite", "ladder", "mouse", "nest",
            "owl", "plum", "quartz", "robot", "straw", "violin",
            "window", "yak", "archer", "bench", "clown", "door",
            "fruit", "grape", "house", "igloo", "jelly", "kite", "ladder",
            "mouse", "nest", "owl", "plum", "quartz", "straw",
            "violin", "window", "yak", "archer", "bench", "clown",
            "door", "fruit", "grape", "house", "igloo", "jelly",
            "kite", "ladder", "mouse", "nest", "owl", "plum",
            "quartz", "robot", "straw", "violin", "window", "yak"
    };

    static String getRandom() {
        Random random = new Random();
        int randomIndex = random.nextInt(nouns.length);
        return nouns[randomIndex];
    }

    static StringBuilder hide(String word) {
        return new StringBuilder().append("*".repeat(word.length()));
    }
}

class Render {
    static void info(int mistakes, StringBuilder wordToRender) {
        System.out.println("Mistakes left: " + mistakes);
        word(wordToRender);
    }

    static void StartInfo() {
        System.out.println("Hello lets start the game !");
        System.out.println();
    }

    static void word(StringBuilder word) {
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

    static void gallows(int mistakesLeft) {
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

        switch (mistakesLeft) {
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