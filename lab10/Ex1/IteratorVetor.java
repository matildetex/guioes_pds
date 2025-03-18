import java.util.Iterator;
import java.util.ListIterator;


public interface IteratorVetor<T> {
    Iterator<T> iterator();
    ListIterator<T> listIterator();
    ListIterator<T> listIterator(int index);
}
