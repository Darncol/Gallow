class GameStatus {
    boolean isWin = false;
    int mistakesLeft = 7;

    void decreaseMistakes(boolean isCharFounded) {
        if (!isCharFounded) {
            --mistakesLeft;
        }
    }

    void check(String character, Word word) {
        boolean isCharFounded = false;

        for (int i = 0; i < word.value.length(); i++) {
            if (character.charAt(0) == word.value.charAt(i)) {
                word.hidden.replace(i, i + 1, character);
                isCharFounded = true;
            }
        }

        decreaseMistakes(isCharFounded);
    }

    void chekVictoryCondition(Word word) {
        if (word.value.contentEquals(word.hidden)) {
            isWin = true;
        }
    }

    Boolean winCondition() {
        if (isWin) {
            System.out.println("CONGRATULATIONS YOU WIN !!!");
            return true;
        } else {
            return false;
        }
    }

    void loseCondition() {
        if (!isWin) {
            Render.gallows(mistakesLeft);
            System.out.println("You LOSE !");
        }
    }
}