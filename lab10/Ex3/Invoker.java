package Ex3;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Invoker {
    private Deque<Command> commandHistory = new LinkedList<>();
    private List<Command> commandOrder = new ArrayList<>();

    public void executeCommand(Command command) {
        command.execute();
        commandHistory.push(command);
        commandOrder.add(command);
    }

    public void undo() {
        if (!commandHistory.isEmpty()) {
            Command command = commandHistory.pop();
            command.undo();
            commandOrder.remove(command); 
        }
    }

    public void undoAll() {
        while (!commandHistory.isEmpty()) {
            undo();
        }
    }
}
