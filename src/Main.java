public class Main {
    public static void main(String[] args) {
        boolean isRestarting;

        do {
            Renderer.freeSpace();

            Game game = new Game();
            game.startGame();

            Renderer.askRestart();

            isRestarting = Input.getLetter().equals("y");
        } while (isRestarting);
    }
}