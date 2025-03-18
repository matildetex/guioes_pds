package Ex3;

import java.util.Collection;
import java.util.List;

public class RemoveCommand<E> implements Command {
    private Collection<E> collection;
    private E element;
    private int index;

    public RemoveCommand(Collection<E> collection, E element) {
        this.collection = collection;
        this.element = element;
    }

    @Override
    public void execute() {
        if (collection.contains(element)) {
            index = ((List<E>) collection).indexOf(element);
            collection.remove(element);
        }
    }

    @Override
    public void undo() {
        if (index != -1) {
            ((List<E>) collection).add(index, element);
        } else {
            collection.add(element);
        }
    }
    
    public E getElement() {
        return element;
    }
}
