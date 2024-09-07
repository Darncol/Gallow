class GameStatus {
    private boolean isWin = false;
    private int attempts = 7;

    void checkLetter(String character, Word word) {
        boolean isCharFounded = false;
        StringBuilder hiddenValue = word.getHiddenValue();

        for (int i = 0; i < word.getValue().length(); i++) {
            if (character.charAt(0) == word.getValue().charAt(i)) {
                hiddenValue.replace(i, i + 1, character);
                isCharFounded = true;
            }
        }

        decreaseMistakes(isCharFounded);
    }

    void checkVictoryCondition(Word word) {
        if (word.getValue().contentEquals(word.getHiddenValue())) {
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
            Renderer.displayGallows(attempts);
            System.out.println("You LOSE !");
        }
    }

    int getAttemptsCount() {
        return attempts;
    }

    private void decreaseMistakes(boolean isCharFounded) {
        if (!isCharFounded) {
            --attempts;
        }
    }
}