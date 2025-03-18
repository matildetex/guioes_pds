
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
public class Diagonal {
    private static List<String> foundWords = new ArrayList<>();
    private static int startRow = 0;
    private static int startCol = 0;
    public static List<String> findWordsDiagonally(List<String> puzzle, List<String> words) {
        int linhas = puzzle.size();
        int colunas = puzzle.get(0).length();
        diagonaisUp(puzzle, linhas, colunas, words);
        List<String> puzzleInvertido = new ArrayList<>(puzzle);
        Collections.reverse(puzzleInvertido);
        diagonaisDown(puzzleInvertido, linhas, colunas, words);
        return foundWords;
    }

    public static List<String> diagonaisUp(List<String> puzzle, int linhas, int colunas, List<String> words) {
        for (String word : words) {
            for (int i = 0; i < colunas; i++) {
                StringBuilder Diagonalstr_baixo = new StringBuilder();
        
                for (int j = 0; j < linhas; j++) {
                    if (i + j < linhas) {
                        Diagonal.startRow = i + j;
                        Diagonal.startCol = j;
                        Diagonalstr_baixo.append(puzzle.get(i + j).charAt(j));
                    }
                }
                if (Diagonalstr_baixo.toString().contains(word)){
                    foundWords.add(word + " " + Diagonal.startRow + " " + Diagonal.startCol + " DownRight");
                }
                if (Diagonalstr_baixo.reverse().toString().contains(word)){
                    Diagonal.startRow=Diagonal.startRow+1;
                    Diagonal.startCol=Diagonal.startCol+1;
                    foundWords.add(word + " " + Diagonal.startRow + " " + Diagonal.startCol + " UpLeft");
                }
            }
        

        for (int i = 1; i < linhas; i++) {
            StringBuilder Diagonalstr_cima = new StringBuilder();
            
            for (int j = 0; j < linhas; j++) {
                if (i + j < linhas) {
                    Diagonal.startRow = - i + j;
                    Diagonal.startCol = j;
                    Diagonalstr_cima.append(puzzle.get(j).charAt(i + j));
                }
            }
    
                if (Diagonalstr_cima.toString().contains(word)){
                    foundWords.add(word + " " +Diagonal.startRow + " " + Diagonal.startCol+ " DownRight");
                }
                if (Diagonalstr_cima.reverse().toString().contains(word)){
                    foundWords.add(word + " " + Diagonal.startRow + " " + Diagonal.startCol + " UpLeft");
                }
        }
        }
    
    
        return foundWords;
    }

    public static List<String> diagonaisDown(List<String> puzzle, int linhas, int colunas, List<String> words) {
        for (String word : words) {
            for (int i = 0; i < colunas; i++) {
                StringBuilder Diagonalstr_baixo = new StringBuilder();
        
                for (int j = 0; j < linhas; j++) {
                    if (i + j < linhas) {
                        Diagonal.startRow = i + j;
                        Diagonal.startCol = j;
                        Diagonalstr_baixo.append(puzzle.get(i + j).charAt(j));
                    }
                }
               
                if (Diagonalstr_baixo.toString().contains(word)){
                    foundWords.add(word + " " + Diagonal.startRow + " " + Diagonal.startCol + " UpRight");
                }
                if (Diagonalstr_baixo.reverse().toString().contains(word)){
                    foundWords.add(word + " " + Diagonal.startRow + " " + Diagonal.startCol + " DownLeft");
                }
            }
        

        for (int i = 1; i < linhas; i++) {
            StringBuilder Diagonalstr_cima = new StringBuilder();
    
            for (int j = 0; j < linhas; j++) {
                if (i + j < linhas) {
                    Diagonal.startRow = i + j;
                    Diagonal.startCol = j;
                    Diagonalstr_cima.append(puzzle.get(j).charAt(i + j));
                }
            }
    
            String Diagonalstr= Diagonalstr_cima.toString();
                if (Diagonalstr_cima.toString().contains(word)){
                    foundWords.add(word + " " + Diagonal.startRow + " " + Diagonal.startCol + " UpRight");
                }
                if (Diagonalstr_cima.reverse().toString().contains(word)){
                    Diagonal.startCol=Diagonal.startCol+2;
                    Diagonal.startRow=Diagonal.startRow-linhas/2-4;
                    foundWords.add(word + " " + Diagonal.startRow + " " + Diagonal.startCol + " DownLeft");
                }
        }
        }
    
    
        return foundWords;
    }
}
