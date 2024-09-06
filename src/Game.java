class Game {
    Word word = new Word();
    GameStatus gameStatus = new GameStatus();

    void startGame() {
        Render.StartInfo();

        while (gameStatus.mistakesLeft > 0) {
            Render.gallows(gameStatus.mistakesLeft);
            Render.info(gameStatus.mistakesLeft, word.hidden);

            gameStatus.check(Input.get(), word);
            gameStatus.chekVictoryCondition(word);

            Render.freeSpace();

            if (gameStatus.winCondition()) {
                break;
            }
        }

        gameStatus.loseCondition();
    }
}