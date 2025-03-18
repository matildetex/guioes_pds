import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Random;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.PrintStream;


public class WSGenerator {
    public static void main(String[] args) throws FileNotFoundException {
        // Initializations
        String input = "";
        File input_file = new File(input);
        int len_puzzle = 0;
        String output = "";
        List<String> words = new ArrayList<>();
        boolean optI = false;
        boolean optS = false;
        boolean optO = false;
        char current_opt = ' ';
        List<String> lines = new ArrayList<>();

        // Parsing through the arguments provided in the command line
        for (int i = 0; i < args.length; i++) {
            // Input must always start with '-'
            if (args[i].charAt(0) == '-') {
                current_opt = args[i].charAt(1);
            } else {
                // Throw an exception if the input format is not correct
                throw new IllegalArgumentException("Error: Input must be of type -i 'file containing the words' -s 'length of the puzzle' -o (optional)'name of the file where the soup letter will be stores'");
            }

            switch (current_opt) {
                case 'i':
                    if (optI == false) {
                        input = args[++i]; // Incrementing variable i so that the next args iterated over is an opt
                        input_file = new File(input);
                        optI = true;
                    } else {
                        throw new IllegalArgumentException("Error: Must only pass one input file");
                    }
                    break;

                case 's':
                    if (optS == false) {
                        try {
                            len_puzzle = Integer.parseInt(args[++i]);
                        } catch (NumberFormatException e) {
                            throw new IllegalArgumentException("Error: puzzle size must be an int");
                        }

                        if (len_puzzle > 40) {
                            throw new IllegalArgumentException("Error: Puzzle length must not exceed 40");
                        }

                        optS = true;

                    } else {
                        throw new IllegalArgumentException("Error: Must only provide one puzzle length");
                    }
                    break;

                case 'o':
                    if (optO == false) {
                        output = args[++i];
                        if (!output.endsWith(".txt")) {
                            throw new IllegalArgumentException("Error: Please provide a valid file name");
                        }

                        optO = true;
                    } else {
                        throw new IllegalArgumentException("Error: Please provide only one output file");
                    }
                    break;

                default:
                    // Throw an exception if the input option is not recognized
                    throw new IllegalArgumentException("Error: Input must be of type -i 'file containing the words' -s 'length of the puzzle' -o (optional)'name of the file where the soup letter will be stores'");
            }
        }

        // Check if both input file and puzzle length are provided
        if (optI == false || optS == false) {
            throw new IllegalArgumentException("Must provide at least an input and a puzzle length");
        }

        // Call method to check words and get the list
        words = checkWords(input_file, len_puzzle, lines);

        char[][] board = new char[len_puzzle][len_puzzle];


        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = '-';
            }
        }

        for (String word : words) {
            placeWord(board, word);
        }

        fillEmpty(board);

        if (optO == false){
            displayBoard(board, lines);
        }else{
            // Save the current System.out
            PrintStream originalOut = System.out;

            // Create a File object for the output file
            File outputFile = new File(output);

            try {
                // Redirect System.out to the output file
                PrintStream fileOut = new PrintStream(outputFile);
                System.setOut(fileOut);
    
                // program logic that produces output
                displayBoard(board, lines);
    
                // Reset System.out to the original PrintStream
                System.setOut(originalOut);
    
                // Inform the user that the output has been saved to the file
                System.out.println("Output has been saved to: " + outputFile.getAbsolutePath());
    
            } catch (FileNotFoundException e) {
                // Handle file not found exception
                e.printStackTrace();
            }
        }



    }

// Method to check words from the input file
public static List<String> checkWords(File inputFile, int len_puzzle, List<String> lines) {
    Scanner scanner = null;
    List<String> words = new ArrayList<>();

    try {
        scanner = new Scanner(inputFile);

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            lines.add(line);
            if (!line.isEmpty()) {
                if (Character.isLowerCase(line.charAt(0))) {
                    for (String word : line.split("[,;\\s]+")) {
                        boolean isAlpha = true;
                        if (word.length() <= len_puzzle) {
                            for (int i = 0; i < word.length(); i++) {
                                if (!Character.isLetter(word.charAt(i))) {
                                    isAlpha = false;
                                    System.err.println("Error: word can only contain alphabetic characters. The word "+ word+ " won't be added.");
                                    break;
                                }
                            }
                            if (isAlpha) {
                                words.add(word.toUpperCase());
                            }
                        } else {
                            System.err.println("Error: word length cannot exceed the length of the puzzle. The word "+ word + " won't be added.");
                        }
                    }
                } else {
                    System.err.println("Error: words must be in lowercase");
                    System.exit(1);
                }
            }
        }
    } catch (FileNotFoundException e) {
        // Handle file not found exception
        System.err.println("Error: File not found: " + inputFile);
        System.exit(1);
    } finally {
        // Close the scanner in a finally block to ensure it's closed even if an exception occurs
        if (scanner != null) {
            scanner.close();
        }
    }

    return words;
}

    public static void placeWord(char[][] board, String word){
        boolean placed = false;
        Random random = new Random();
        boolean reverse = false;
        int row = 0;
        int col = 0;
        int orientation = 0;
        String word_reversed = new StringBuilder(word).reverse().toString();
        String word2;
        int attempts = 0;

        while (!placed){
            if (attempts > 150){
                System.err.println("Error: could not add the word "+ word+ ". Please try again");
                System.exit(1);
            }
            word2 = word;
            orientation = random.nextInt(4);
            reverse = random.nextBoolean();
            if (reverse == true){
                word2 = word_reversed;
            }

            switch (orientation){
                case 0:  // Horizontal
                    row = random.nextInt(board.length);
                    col = random.nextInt(board.length - word.length() + 1);
                    break;
                case 1:  // Vertical
                    row = random.nextInt(board.length - word.length() + 1);
                    col = random.nextInt(board.length);
                    break;
                case 2:  // Diagonal top-left to bottom right
                    row = random.nextInt(board.length - word.length() + 1);
                    col = random.nextInt(board.length - word.length() + 1);
                    break;
                case 3:  // Diagonal bottom-left to top-right
                    row = random.nextInt(board.length - word.length() + 1) + word.length() - 1;
                    col = random.nextInt(board.length - word.length() + 1);
                    break;
            }

            boolean spaceAvailable = checkSpace(board, word2, orientation, row, col);

            if (spaceAvailable) {
                placeWordOnBoard(board, word2, orientation, row, col);
                placed = true;
            }

            attempts++;
        }
    }

    public static boolean checkSpace(char[][] board, String word, int orientation, int startRow, int startCol) {
        boolean inside = true;     // to check if the space the word will be put in isn't another word 
        int row = startRow;
        int col = startCol;
    
        for (int i = 0; i < word.length(); i++) {
            char currentCell;
    
            switch (orientation) {
                case 0: // Horizontal
                    currentCell = board[row][col + i];
                    break;
                case 1: // Vertical
                    currentCell = board[row + i][col];
                    break;
                case 2: // Diagonal top-left to bottom right
                    currentCell = board[row + i][col + i];
                    break;
                case 3: // Diagonal bottom-left to top-right
                    currentCell = board[row - i][col + i];
                    break;
                default:
                    throw new IllegalArgumentException("Invalid orientation. Try again");
            }
    
            if (currentCell != '-' && currentCell != word.charAt(i)) {
                return false; // There is a conflict in placing the word
            }

            if (currentCell == '-'){
                inside = false;
            }
        }
    
        return !inside; // There is enough space to place the word
    }

    public static void placeWordOnBoard(char[][] board, String word, int orientation, int startRow, int startCol) {
        switch (orientation) {
            case 0: // horizontal
                for (int i = 0; i < word.length(); i++) {
                    if (startRow < board.length && startCol + i < board[startRow].length) {
                        board[startRow][startCol + i] = word.charAt(i);
                    }
                }
                break;
            case 1: // vertical
                for (int i = 0; i < word.length(); i++) {
                    if (startRow + i < board.length && startCol < board[startRow + i].length) {
                        board[startRow + i][startCol] = word.charAt(i);
                    }
                }
                break;
            case 2: // diagonal top-left to bottom-right
                for (int i = 0; i < word.length(); i++) {
                    if (startRow + i < board.length && startCol + i < board[startRow + i].length) {
                        board[startRow + i][startCol + i] = word.charAt(i);
                    }
                }
                break;
            case 3: // diagonal bottom-left to top-right
                for (int i = 0; i < word.length(); i++) {
                    if (startRow - i >= 0 && startCol + i < board[startRow - i].length) {
                        board[startRow - i][startCol + i] = word.charAt(i);
                    }
                }
                break;
            default:
                throw new IllegalArgumentException("Invalid orientation. Try again");
        }
    }
    

    public static void fillEmpty(char[][] board){
        Random random = new Random();

        for (int row = 0; row < board.length; row++){
            for (int col = 0; col < board.length; col++){
                if (board[row][col] == '-'){
                    board[row][col] = (char)(random.nextInt(26) + 'A');
                }
            }
        }
    }

    public static void displayBoard(char[][] board, List<String> lines){
        for (int row = 0; row < board.length; row++){
            for (int col = 0; col < board.length; col++){
                System.out.print(board[row][col]);
            }
        System.out.println();
        }
        for (String line : lines) {
            System.out.println(line);
        }
    }
    

}

