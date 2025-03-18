public class CapitalizationFilter extends TextDecorator{

    public CapitalizationFilter(InterfaceTextReader reader) {
        super(reader);
    }

    public boolean hasNext() {
        return super.hasNext();
    }

    public String next() {
        if(reader.hasNext()){
            String next = super.next();
            if (next != null) {
                return next.toUpperCase();
            }
        }
        return null;
    }
}
