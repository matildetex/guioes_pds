import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TermFilter extends TextDecorator {
    private List<String> currentWords = new ArrayList<>();
    private int currentWordIndex = 0;

    public TermFilter(InterfaceTextReader reader) {
        super(reader);
    }

    public boolean hasNext() {
        return currentWordIndex < currentWords.size() || reader.hasNext();
    }

    public String next() {
        if (currentWordIndex >= currentWords.size()) {
            String nextSentence = super.next();
            if (nextSentence != null) {
                currentWords = Arrays.asList(nextSentence.split("\\s"));
                currentWordIndex = 0;
            } else {
                return null; //null se próxima frase for null
            }
        }

        if (currentWordIndex < currentWords.size()) {
            return currentWords.get(currentWordIndex++);
        } else {
            return null; // se não há mais palavras na frase atual
        }
    }
}
