package src;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class WSSolver {

    public static ArrayList<String> words = new ArrayList<>();

    public static void main(String[] args) {
        
        String fileName = args[0];
        File file = new File(fileName);

        char[][] linesArray = readLinesToArray(file);
        
        if(Functions.verifyLen(linesArray) == false){
            System.out.println("O tamanho da sopa de letras não é válido.");
            System.exit(1);
        }

        if(Functions.verifyUpper(linesArray) == false){
            System.out.println("As letras da sopa de letras não são todas maiúsculas.");
            System.exit(1);
        }

        boolean[][] marked = new boolean[linesArray.length][linesArray[0].length];

        Functions.findWords(linesArray, words, marked);
        Functions.replaceUnmarked(linesArray, marked);
        Functions.printWordSoup(linesArray);
    
    }

    // Leitura de ficheiros e criação de estruturas de dados

    static char[][] readLinesToArray(File file) {
        ArrayList<char[]> linesList = new ArrayList<>();

        try {        
            Scanner reader = new Scanner(file);

            while(reader.hasNextLine()){
                String line = reader.nextLine();

                if (line.contains(" ") || line.contains(";") || line.contains(",")){
                    wordsToSearch(line, words);
                    continue;  
                }

                linesList.add(line.toCharArray());
            }

            reader.close();
        } catch(IOException e) {
            System.err.printf("Erro na abertura do ficheiro: %s.\n", e.getMessage());
            System.exit(1);
        }

        
        char[][] linesArray = new char[linesList.size()][];
        for (int i = 0; i < linesList.size(); i++) {
            linesArray[i] = linesList.get(i);
        }

        return linesArray;
    }

    static ArrayList<String> wordsToSearch(String line, ArrayList<String> words) {
        String[] wordsInLine = line.split(",|;|\\s+");
        for(String word : wordsInLine) {
            if(Functions.verifyWord(word)) {
                words.add(word.toUpperCase());
            }
        }
        return words;
    }

    
}
