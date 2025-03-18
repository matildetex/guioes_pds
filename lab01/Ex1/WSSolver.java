
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WSSolver {
    private static final int MAX_SIZE = 40;
    private static List<String> puzzle = new ArrayList<String>();
    public static  List<String> palavrasSearchFor = new ArrayList<String>();
    private static StringBuilder rowBuilder=new StringBuilder();

    private static List<String> readFile(String filename) throws FileNotFoundException { //ler sopa
        Scanner scanner = new Scanner(new File(filename));
        

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine().trim();
            if (!line.isEmpty()) { // se linha vazia dá skip
                if (line.length() > MAX_SIZE) { // se o puzzle exceder as 40 colunas
                    throw new IllegalArgumentException("Tamanho do puzzle excede o máximo permitido");
                }
                if (!line.matches("[A-Z]+")) { //maiusculass
                    if(line.matches(".*[;,\\s]+.*")){ //ver delimitadores das palavras
                        while(!line.matches(".*\\s\\s.*")){ // corre até aparecerem 2 espaços seguidos aka fim das palavras
                            readWords(line);
                            break;
                       }
                       continue;
                    }
                    throw new IllegalArgumentException("Sopa contêm letras que não são maiúsculas");
                }
                else{
                    puzzle.add(line);
                }
            }
        }

        if (WSSolver.puzzle.size() > MAX_SIZE) { //se puzzle exceder 40 linhas
            throw new IllegalArgumentException("Tamanho do puzzle excede o máximo permitido");
        }
        int size = puzzle.size(); //verificar se é quadrado
       
        if (size > 40) {
            System.out.println("Puzzle size is too large. Maximum size is 40x40.");
        }
        if (puzzle.size() != puzzle.get(0).length()) {
            System.out.println("Puzzle is not a square.");
        }
        
        scanner.close();
        return WSSolver.puzzle;

    }

    private static List<String> readWords(String line){ //ver palavras a procurar
        String[] words = line.split("[;,\\s]+");
                for (String word : words) {
                    if (!word.matches("[a-zA-Z]+")) { //alfabetico
                        throw new IllegalArgumentException("Palavras contêm caracteres não alfabéticos");
                    }
                    WSSolver.palavrasSearchFor.add(word.toUpperCase());
                }
        return WSSolver.palavrasSearchFor;
    }

    private static void printResults(List<String> foundWords) {

        final int MAXIMUM_RESULTS = 100; // Define your maximum threshold

        if (foundWords.size() > MAXIMUM_RESULTS) {
            throw new RuntimeException("Too many words found. Aborting to prevent excessive output.");
        }

        for (String foundWord : foundWords) {
            String[] parts = foundWord.split("\\s+");
            String word = parts[0];
            int row = Integer.parseInt(parts[1]);
            int col = Integer.parseInt(parts[2]);
            String direction = parts[3];

            // Calcula a posição inicial da palavra no formato "linha,coluna"
            String startPosition = String.format("%d,%d", row, col);

            System.out.printf("%-10s\t%-7d\t%-15s\t%s%n", word, word.length(), startPosition, direction);
        }
    }


    //função que verifica se as palavras existem apenas uma vez na sopa de letras
    private static boolean checkWordsOnce(List<String> foundWordsHorizontal, List<String> foundWordsVertical, List<String> foundWordsDiagonal) {
        List<String> allFoundWords = new ArrayList<>(foundWordsVertical);
        allFoundWords.addAll(foundWordsDiagonal);
        allFoundWords.addAll(foundWordsHorizontal);
        for (String word : WSSolver.palavrasSearchFor) {
            int count = 0;
            for (String foundWord : allFoundWords) {
                String[] parts = foundWord.split("\\s+");
                String word_only = parts[0];
                if (word_only.startsWith(word)) { //Ponto 8 dos requisitos de entrada (compara o prefixo)
                    count++;
                }
            }
            if (count == 0) {
                System.out.println("A palavra '" + word + "' não foi encontrada.");
                return false;
            } else if (count > 1) {
                System.out.println("Palavra" + word + "aparece mais de uma vez.");
                return false;
            }
        }

        return true;
    }
    private static List<String> printpuzzle(List<String> foundWordsHorizontal, List<String> foundWordsVertical, List<String> foundWordsDiagonal) {
        List<String> puzzlePrint = new ArrayList<>();
        int colunas = WSSolver.puzzle.size();
        int linhas = WSSolver.puzzle.get(0).length();

        for (int i = 0; i < linhas ; i++) {
            StringBuilder rowBuilder = new StringBuilder();
            for (int j = 0; j < colunas; j++) {
                rowBuilder.append('*');
            }
            puzzlePrint.add(rowBuilder.toString());
        }

        // Adicionando as palavras
        for (String foundWord : foundWordsHorizontal) {
            String[] parts = foundWord.split("\\s+");
            addWordToPrintPuzzle(parts[0], Integer.parseInt(parts[1])-1, Integer.parseInt(parts[2])-1, true, rowBuilder, puzzlePrint, parts[3]);  // horizontal
        }

        for (String foundWord : foundWordsVertical) {
            String[] parts = foundWord.split("\\s+");
            addWordToPrintPuzzle(parts[0], Integer.parseInt(parts[1])-1, Integer.parseInt(parts[2])-1, false, rowBuilder, puzzlePrint, parts[3]);  // horizontal
        }

            // Adicionando as palavras diagonais
        for (String foundWord : foundWordsDiagonal) {
            String[] parts = foundWord.split("\\s+");
            String word = parts[0];
            int row = Integer.parseInt(parts[1]);
            int col = Integer.parseInt(parts[2]);
            String direction = parts[3];
            addDiagonalWordToPrintPuzzle(word, row, col, direction, puzzlePrint);
        }

        return puzzlePrint;
    }

    private static void addWordToPrintPuzzle(String word, int row, int col, boolean horizontal, StringBuilder rowBuilder, List<String> puzzlePrint, String dir){

        if (horizontal) {
            if(dir.equals("Left")){
                StringBuilder rowBuilder1 = new StringBuilder(puzzlePrint.get(row));
                for (int i = word.length() - 1; i >= 0; i--) {
                    rowBuilder1.setCharAt(col - i-1, word.charAt(i));
                }
                puzzlePrint.set(row, rowBuilder1.toString());
            }
            else{
                StringBuilder rowBuilder1 = new StringBuilder(puzzlePrint.get(row));
                for (int i = 0; i < word.length(); i++) {
                    rowBuilder1.setCharAt(col + i, word.charAt(i));
                }
                puzzlePrint.set(row, rowBuilder1.toString());
            }
        } else if (!horizontal) {
            if(dir.equals("Up")){
                for (int i = 0; i < word.length(); i++) {
                    int rowIndex = row - i;  // Subtrai i para mover para cima
                    if (rowIndex >= 0 && rowIndex < puzzlePrint.size()) {
                        StringBuilder builder = new StringBuilder(puzzlePrint.get(rowIndex));
                        builder.setCharAt(col, word.charAt(i));
                        puzzlePrint.set(rowIndex, builder.toString());
                    }
                }
                
            }
            else{
                for (int i = 0; i < word.length(); i++) {
                    StringBuilder newRowBuilder = new StringBuilder(puzzlePrint.get(row + i));
                    newRowBuilder.setCharAt(col, word.charAt(i));
                    puzzlePrint.set(row + i, newRowBuilder.toString());
                }
            }

        }
    }
            
    private static void addDiagonalWordToPrintPuzzle(String word, int row, int col, String direction, List<String> puzzlePrint) {
        int len = word.length();
        int linhas = puzzlePrint.size();
        int colunas = puzzlePrint.get(0).length();
        int deltaRow = direction.equals("UP") ? -1 : 1;
        int deltaCol = direction.equals("LEFT") ? -1 : 1;
                        
        if(direction.equals("DownRight")){
           
            for (int i = 0; i < len; i++) {
                int newRow = row + i -1 * deltaRow;
                int newCol = col + i -1 * deltaCol;
                char currentChar = puzzlePrint.get(newRow).charAt(newCol);
                if (currentChar == '*' || currentChar == word.charAt(i)) {
                    String updatedRow = replaceCharAt(puzzlePrint.get(newRow), newCol, word.charAt(i));
                    puzzlePrint.set(newRow, updatedRow);
                }
            }
        }
        if(direction.equals("UpLeft")){
            for (int i = 0; i < len; i++) {
                int newRow = row - i -1 * deltaRow;  // Invertido para decrementar em vez de incrementar
                int newCol = col - i -1* deltaCol;  // Invertido para decrementar em vez de incrementar
                char currentChar = puzzlePrint.get(newRow).charAt(newCol);
                if (currentChar == '*' || currentChar == word.charAt(i)) {
                    String updatedRow = replaceCharAt(puzzlePrint.get(newRow), newCol, word.charAt(i));
                    puzzlePrint.set(newRow, updatedRow);
                }
            }
        }
        if(direction.equals("UpRight")){
            for (int i = 0; i < len; i++) {
                int newRowOpposite = row - i + 1* deltaRow;
                int newColOpposite = col + i +1* deltaCol;
                char currentCharOpposite = puzzlePrint.get(newRowOpposite).charAt(newColOpposite);
                if (currentCharOpposite == '*' || currentCharOpposite == word.charAt(i)) {
                    String updatedRowOpposite = replaceCharAt(puzzlePrint.get(newRowOpposite), newColOpposite, word.charAt(i));
                    puzzlePrint.set(newRowOpposite, updatedRowOpposite);
                }
            }
        }
        if(direction.equals("DownLeft")){
            for (int i = 0; i < len; i++) {
                int newRowOpposite = row + i-1* deltaRow;
                int newColOpposite = col - i -1* deltaCol;
                char currentCharOpposite = puzzlePrint.get(newRowOpposite).charAt(newColOpposite);
                if (currentCharOpposite == '*' || currentCharOpposite == word.charAt(i)) {
                    String updatedRowOpposite = replaceCharAt(puzzlePrint.get(newRowOpposite), newColOpposite, word.charAt(i));
                    puzzlePrint.set(newRowOpposite, updatedRowOpposite);
                }
            }
        }
        }
        
    private static String replaceCharAt(String str, int index, char replacement) {
        if (index < 0 || index >= str.length()) {
            return str;
        }
        return str.substring(0, index) + replacement + str.substring(index + 1);
    }
    

    public static void main(String[] args) throws FileNotFoundException {
        if (args.length != 1) {
            System.out.println("Usage: java WSSolver <input_file>");
            return;
        }
    
        String filename = args[0];
    
        try{
            
            WSSolver.puzzle = readFile(filename);
            List<String> foundWordsHorizontal = Horizontal.findWordsHorizontally(WSSolver.puzzle, WSSolver.palavrasSearchFor);
            printResults(foundWordsHorizontal);

            List<String> foundWordsVertical = Vertical.findWordsVertically(WSSolver.puzzle, WSSolver.palavrasSearchFor);
            printResults(foundWordsVertical);

            List<String> foundWordsDiagonal = Diagonal.findWordsDiagonally(WSSolver.puzzle, WSSolver.palavrasSearchFor);
            printResults(foundWordsDiagonal);
            List<String> puzzlePrint= printpuzzle(foundWordsHorizontal, foundWordsVertical, foundWordsDiagonal);
            System.out.println("\n");
            for (String linha:puzzlePrint){
                System.out.println(linha);
            }
        
            if (checkWordsOnce(foundWordsHorizontal, foundWordsVertical, foundWordsDiagonal)) {
                System.out.println("\nTodas as palavras encontradas apenas uma vez na sopa de letras.");
            } else {
                System.out.println("\nAlgumas palavras encontradas mais de uma vez na sopa de letras.");
            }
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado: " + filename);

        }
    }


}
