//Dylan Hamilton
////12-4-25

import java.util.LinkedList;

public class MoveList {

    private LinkedList<Move> moveHistory;

    public MoveList() {
        moveHistory = new LinkedList<>();
    }

    public void addMove(String text) {
        moveHistory.add(new Move(text));
    }

    public void printMoves() {
        for (Move move : moveHistory) {
            System.out.println(move.getDescription());
        }
    }
}
