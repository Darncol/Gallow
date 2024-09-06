public class Main {
    public static void main(String[] args) {
        boolean isRestarting ;

        do {
            Render.freeSpace();

            Game game = new Game();
            game.startGame();

            Render.askRestart();

            isRestarting = Input.get().equals("y");
        } while (isRestarting);
    }
}