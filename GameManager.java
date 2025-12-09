public class GameManager {

    private MoveList moves;

    public GameManager() {
        moves = new MoveList();
    }

    public void start() {
        System.out.println("Game started!");

        moves.addMove("Player moved forward");
        moves.addMove("Player picked up an item");

        moves.printMoves();
    }
}
