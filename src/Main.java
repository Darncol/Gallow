import java.util.Random;
import java.util.Scanner;

import static java.lang.System.out;

public class Main {
    public static void main(String[] args) {
        Game game = new Game();
        game.startGame();
    }
}

class Game {
    boolean isWin = false;
    int mistakesLeft = 6;
    String word = Words.getRandomWord();
    StringBuilder hiddenWord = new StringBuilder();
    String character = "";

    void startGame() {
        hiddenWord = hideWord();
        Render.StartInfo();

        while (mistakesLeft > 0) {
            out.println(word);
            Render.info(mistakesLeft, hiddenWord);
            out.print("Input character: ");
            character = Input.get();
            check(character);

            chekVictoryCondition();

            if (isWin) {
                out.println();
                out.println("CONGRATULATIONS YOU WIN !!!");
                break;
            }
        }

        if (!isWin) {
            out.println();
            out.println("You LOSE !");
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

        if (!isCharFounded) {
            --mistakesLeft;
        }
    }

    private void chekVictoryCondition() {
        if (word.contentEquals(hiddenWord)) {
            isWin = true;
        }
    }

    private StringBuilder hideWord() {
        return hiddenWord.append("*".repeat(word.length()));
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
                out.println("Only 1 character !");
            }

        } while (!valid);

        return chekedChar;
    }
}

class Words {
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

    static String getRandomWord() {
        Random random = new Random();
        int randomIndex = random.nextInt(nouns.length);
        return nouns[randomIndex];
    }
}

class Render {
    static void info(int mistakes, StringBuilder wordToRender) {
        out.println("Mistakes left: " + mistakes);
        word(wordToRender);
    }

    static void StartInfo() {
        out.println("Hello lets start the game !");
        out.println();
    }

    static void word(StringBuilder word) {
        StringBuilder hiddenWord = new StringBuilder();

        for (int i = 0; i < word.length(); i++) {
            char character = word.charAt(i);
            hiddenWord.append("|").append(character).append("|");
        }

        out.println(hiddenWord);
    }

    // TODO: Finish
    static void gallows() {

    }
}