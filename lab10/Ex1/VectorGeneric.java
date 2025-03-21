import java.util.Iterator;
import java.util.ListIterator;

public class VectorGeneric<T> implements IteratorVetor<T> {
    private T[] vec;
    private int nElem;
    private final static int ALLOC = 50;
    private int dimVec = ALLOC;

    @SuppressWarnings("unchecked")
    public VectorGeneric() {
        vec = (T[]) new Object[dimVec];
        nElem = 0;
    }

    public boolean addElem(T elem) {
        if (elem == null)
            return false;
        ensureSpace();
        vec[nElem++] = elem;
        return true;
    }

    private void ensureSpace() {
        if (nElem >= dimVec) {
            dimVec += ALLOC;
            @SuppressWarnings("unchecked")
            T[] newArray = (T[]) new Object[dimVec];
            System.arraycopy(vec, 0, newArray, 0, nElem);
            vec = newArray;
        }
    }

    public boolean removeElem(T elem) {
        for (int i = 0; i < nElem; i++) {
            if (vec[i].equals(elem)) {
                if (nElem - i - 1 > 0) // not last element
                    System.arraycopy(vec, i + 1, vec, i, nElem - i - 1);
                vec[--nElem] = null; 
                return true;
            }
        }
        return false;
    }

    public int totalElem() {
        return nElem;
    }

    public T getElem(int i) {
        return vec[i];
    }

    @Override
    public Iterator<T> iterator() {
        return new MyIterator<>(vec, nElem);
    }

    @Override
    public ListIterator<T> listIterator() {
        return new MyListIterator<>(this, 0);
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        if (index < 0 || index > nElem) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        return new MyListIterator<>(this, index);
    }
}
