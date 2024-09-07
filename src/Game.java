class Game {
    Word word = new Word();
    GameStatus gameStatus = new GameStatus();

    void startGame() {
        Renderer.StartInfo();

        while (gameStatus.attempts > 0) {
            Renderer.gallows(gameStatus.attempts);
            Renderer.info(gameStatus.attempts, word.hidden);

            gameStatus.check(Input.get(), word);
            gameStatus.chekVictoryCondition(word);

            Renderer.freeSpace();

            if (gameStatus.winCondition()) {
                break;
            }
        }

        gameStatus.loseCondition();
    }
}