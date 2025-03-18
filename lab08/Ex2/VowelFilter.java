public class VowelFilter extends TextDecorator{

    public VowelFilter(InterfaceTextReader reader) {
        super(reader);
    }

    public boolean hasNext() {
        return super.hasNext();
    }

    public String next() {
        if(reader.hasNext()){
            String next = super.next();
            if (next != null) {
                return next.replaceAll("[aeiouAEIOU]", "");
            }
        }
        return null;
    }
    
}
