
import java.util.ArrayList;
import java.util.List;

public class Horizontal {
    private static List<String> foundWords = new ArrayList<>();
    public static List<String> findWordsHorizontally(List<String> puzzle, List<String> words) {

        int rows = puzzle.size();

        // Itera pelas linhas do puzzle
        for (int row = 0; row < rows; row++) {
            String rowString = puzzle.get(row);
            findWordsRight(words, row, rowString);
            findWordsLeft(words, row, rowString);

        }

        return Horizontal.foundWords;
    }

    public static List<String> findWordsRight(List<String> words, int row, String rowString) {
        for (String word : words) {
            int index = rowString.indexOf(word);
            while (index != -1) {
                // Encontrou a palavra, adiciona à lista de palavras encontradas
                Horizontal.foundWords.add(word + " " + (row + 1) + " " + (index + 1) + " Right");
                index = rowString.indexOf(word, index + 1);
            }
        }
        return foundWords;
    }

    public static List<String> findWordsLeft(List<String> words, int row, String rowString) {
        for (String word : words) {
            int size=word.length();
            String wordInvertida = new StringBuilder(word).reverse().toString();
            
            int index = rowString.indexOf(wordInvertida);
            while (index != -1) {
                // Encontrou a palavra, adiciona à lista de palavras encontradas
                Horizontal.foundWords.add(word + " " + (row + 1) + " " + (size + index + 1) + " Left");
                index = rowString.indexOf(wordInvertida, index + 1);
            }
        }
        return foundWords;
    }

}