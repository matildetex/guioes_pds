
import java.util.ArrayList;
import java.util.List;

public class Vertical {
    private static List<String> foundWords = new ArrayList<>();

    public static List<String> findWordsVertically(List<String> puzzle, List<String> words) {
        int rows = puzzle.size();
        int cols = puzzle.get(0).length();

        // Itera pelas colunas
        for (int col = 0; col < cols; col++) {
            StringBuilder columnStringBuilder = new StringBuilder();
            // Constrói a string vertical da coluna
            for (int row = 0; row < rows; row++) {
                columnStringBuilder.append(puzzle.get(row).charAt(col));
            }
            String column = columnStringBuilder.toString();
            // Itera pelas palavras para encontrar correspondências na coluna
            findWordsDown(words, column, col);
            findWordsUp(words, column, col);
        }

        return Vertical.foundWords;
    }

    public static List<String> findWordsDown(List<String> words, String column, int col) {
        for (String word : words) {
            if (column.contains(word)) {
                // Encontrou a palavra, adiciona à lista de palavras encontradas
                Vertical.foundWords.add(word + " " + (column.indexOf(word) + 1) + " " + (col + 1) + " Down");
            }
        }
        return foundWords;
    }

    public static List<String> findWordsUp(List<String> words, String column, int col) {
        for (String word : words) {
            int size=word.length();
            String wordreversed = new StringBuilder(word).reverse().toString();
            if (column.contains(wordreversed)) {
                // Encontrou a palavra, adiciona à lista de palavras encontradas
                Vertical.foundWords.add(word + " " + (column.indexOf(wordreversed)+size) + " " + (col + 1) + " Up");
            }
        }
        return foundWords;
    }


}