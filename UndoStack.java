//Dylan Hamilton
//12-4-25

import java.util.Stack;

public class UndoStack {
    private Stack<ActionState> stack = new Stack<>();

    public void save(ActionState state) {
        stack.push(state);
    }

    public ActionState undo() {
        if (!stack.isEmpty()) {
            return stack.pop();
        }
        return null;
    }

    public boolean hasUndo() {
        return !stack.isEmpty();
    }
}
