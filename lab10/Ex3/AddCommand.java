package Ex3;

import java.util.Collection;
import java.util.List;

public class AddCommand<E> implements Command {
    private Collection<E> collection;
    private E element;
    private int index;

    public AddCommand(Collection<E> collection, E element) {
        this.collection = collection;
        this.element = element;
    }

    @Override
    public void execute() {
        if (collection instanceof List) {
            List<E> list = (List<E>) collection;
            list.add(element);
            index = list.size() - 1;
        } else {
            throw new UnsupportedOperationException("Requires List collection.");
        }
    }

    @Override
    public void undo() {
        if (index != -1) {
            ((List<E>) collection).remove(index);
            index = -1;
        }
    }

    public E getElement() {
        return element;
    }
}