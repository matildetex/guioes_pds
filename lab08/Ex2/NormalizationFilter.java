import java.text.Normalizer;

public class NormalizationFilter extends TextDecorator{

    public NormalizationFilter(InterfaceTextReader reader) {
        super(reader);
    }

    public boolean hasNext() {
        return super.hasNext();
    }

    public String next() {
        if(reader.hasNext()){
            String next = super.next();
            if (next != null) {
                return Normalizer.normalize(next, Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "");
            }
        }
        return null;
    }
}

