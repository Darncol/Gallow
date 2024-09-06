import java.io.*;
import java.nio.file.*;
import java.util.Random;

class Word {
    private final String[] nouns;

    String value;
    StringBuilder hidden;

    Word() {
        nouns = readWordsFromFile();
        value = getRandom();
        hidden = hide();
    }

    private String[] readWordsFromFile() {
        String[] splitedWords;
        Path projectDir = Paths.get("").toAbsolutePath();
        Path filePath = projectDir.resolve("resources/Words.txt");

        try {
            String wordsFromFile = Files.readString(filePath);
            splitedWords = wordsFromFile.split(",");
        } catch (IOException e) {
            System.out.println(e.toString());
            splitedWords = new String[0];
        }

        return splitedWords;
    }

    private String getRandom() {
        Random random = new Random();
        int randomIndex = random.nextInt(nouns.length);
        return nouns[randomIndex];
    }

    private StringBuilder hide() {
        return new StringBuilder().append("*".repeat(value.length()));
    }
}