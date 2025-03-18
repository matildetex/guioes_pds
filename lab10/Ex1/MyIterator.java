import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyIterator<T> implements Iterator<T> {
    protected T[] vec;
    protected int currentIndex;
    protected int nElem;

    public MyIterator(T[] vec, int nElem) {
        this.vec = vec;
        this.nElem = nElem;
        this.currentIndex = 0;
    }

    public boolean hasNext() {
        return currentIndex < nElem;
    }

    public T next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return vec[currentIndex++];
    }
}
