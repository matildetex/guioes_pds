public class TextDecorator implements InterfaceTextReader {
    protected InterfaceTextReader reader;

    public TextDecorator(InterfaceTextReader reader) {
        this.reader = reader;
    }

    @Override
    public boolean hasNext() {
        return this.reader.hasNext();
    }

    @Override
    public String next() {
        return this.reader.next();
    }
    
}
