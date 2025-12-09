//Dylan Hamilton
//12-4-25

import java.util.LinkedList;
import java.util.Queue;

public class EventQueue {
    private Queue<Runnable> queue = new LinkedList<>();


    public void addEvent(Runnable event) {
        queue.add(event);
    }


    public void processNext() {
        if(!queue.isEmpty()) {
            Runnable event = queue.poll();
            event.run();
        }
    }


    public boolean hasEvents() {
        return !queue.isEmpty();
    }

}
