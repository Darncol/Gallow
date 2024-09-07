class Game {
    Word word = new Word();
    GameStatus gameStatus = new GameStatus();

    void startGame() {
        Renderer.displayStartInfo();

        while (gameStatus.getAttemptsCount() > 0) {
            Renderer.displayGallows(gameStatus.getAttemptsCount());
            Renderer.displayInfo(gameStatus.getAttemptsCount(), word.getHiddenValue());

            gameStatus.checkLetter(Input.getLetter(), word);
            gameStatus.checkVictoryCondition(word);

            Renderer.freeSpace();

            if (gameStatus.winCondition()) {
                break;
            }
        }

        gameStatus.loseCondition();
    }
}