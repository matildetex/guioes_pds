package Ex3;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> collection = new ArrayList<>();
        Invoker commandManager = new Invoker();

        Command addCommand1 = new AddCommand<>(collection, "Maria");
        Command addCommand2 = new AddCommand<>(collection, "João");

        commandManager.executeCommand(addCommand1);
        commandManager.executeCommand(addCommand2);

        System.out.println("Após adicionar: " + collection);

        Command removeCommand = new RemoveCommand<>(collection, "Maria");

        commandManager.executeCommand(removeCommand);

        System.out.println("Após remover: " + collection);

        commandManager.undo();

        System.out.println("Após desfazer remoção: " + collection);

        commandManager.undo();

        System.out.println("Após desfazer adição: " + collection);
    }
}
