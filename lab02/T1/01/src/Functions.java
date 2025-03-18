
import java.util.ArrayList;

public class Functions {


    // Verificações
   
    static boolean verifyUpper(char[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) { 
                if (!Character.isUpperCase(arr[i][j])) {
                    return false;
                }
            }
        }
        return true;
    }
    

    static boolean verifyWord(String word) {
        for (int i = 0; i >= word.length(); i++) {
            char c = word.charAt(i);
            if(Character.isLowerCase(c)) {
                return false;
            }
        }
        return true;
    }

    static boolean verifyLen(char[][] array) {
        if (array.length > 40) {
            return false;
        }
    
        if (array.length != array[0].length || array[0].length > 40) {
            return false;
        }
    
        for (int i = 1; i < array.length; i++) {
            if (array[i].length != array[0].length) {
                return false;
            }
        }
    
        return true;
    }


    // Procura de palavras

    static Direction verifyDirection(char[][]wordSoup, String word, int col, int row){
        Direction direction = Direction.NONE;

        if (col + word.length() <= wordSoup[row].length) {
            boolean found = true; 
            for (int i = 0; i < word.length(); i++) {
                if (wordSoup[row][col + i] != word.charAt(i)) {
                    found = false; 
                    break; 
                }
            }
            if (found) {
                return Direction.RIGHT;
            }
        }

        if (row + word.length() <= wordSoup.length) {
            boolean found = true; 
            for (int i = 0; i < word.length(); i++) {
                if (wordSoup[row + i][col] != word.charAt(i)) {
                    found = false; 
                    break; 
                }
            }
            if (found) {
                return Direction.DOWN;
            }
        }

        if (col - word.length() + 1 >= 0) {
            boolean found = true;
            for (int i = 0; i < word.length(); i++) {
                if (wordSoup[row][col - i] != word.charAt(i)) {
                    found = false;
                    break;
                }
            }
            if (found) {
                return Direction.LEFT;
            }
        }

        if (row - word.length() + 1 >= 0) {
            boolean found = true;
            for (int i = 0; i < word.length(); i++) {
                if (wordSoup[row - i][col] != word.charAt(i)) {
                    found = false;
                    break;
                }
            }
            if (found) {
                return Direction.UP;
            }
        }
        

        if (col + word.length() <= wordSoup[row].length && row + word.length() <= wordSoup.length) {
            boolean found = true; 
            for (int i = 0; i < word.length(); i++) {
                if (wordSoup[row + i][col + i] != word.charAt(i)) {
                    found = false; 
                    break; 
                }
            }
            if (found) {
                return Direction.DOWN_RIGHT;
            }
        }

        if (col - word.length() + 1 >= 0 && row + word.length() <= wordSoup.length) {
            boolean found = true; 
            for (int i = 0; i < word.length(); i++) {
                if (wordSoup[row + i][col - i] != word.charAt(i)) {
                    found = false; 
                    break; 
                }
            }
            if (found) {
                return Direction.DOWN_LEFT;
            }
        }

        if (col - word.length() + 1 >= 0 && row - word.length() + 1 >= 0) {
            boolean found = true;
            for (int i = 0; i < word.length(); i++) {
                if (wordSoup[row - i][col - i] != word.charAt(i)) {
                    found = false;
                    break;
                }
            }
            if (found) {
                return Direction.UP_LEFT;
            }
        }
        

        if (col + word.length() <= wordSoup[row].length && row - word.length() >= 0) {
            boolean found = true; 
            for (int i = 0; i < word.length(); i++) {
                if (wordSoup[row - i][col + i] != word.charAt(i)) {
                    found = false; 
                    break; 
                }
            }
            if (found) {
                return Direction.UP_RIGHT;
            }
        }        

        return direction;
    }

    static void findWords(char[][] wordSoup, ArrayList<String> words, boolean[][] marked) {
        for (String word : words) {
            for (int row = 0; row < wordSoup.length; row++) {
                for (int col = 0; col < wordSoup[row].length; col++) {
                    if (wordSoup[row][col] == word.charAt(0)) {
                        Direction direction = verifyDirection(wordSoup, word, col, row);
                        if (direction != Direction.NONE) {
                            System.out.println(String.format("%-12s %-2d      %2d,%-2d    %-7s",
                                word.toLowerCase(),
                                word.length(),
                                row + 1,
                                col + 1,
                                direction));
    
                            
                            markWordPositions(wordSoup, marked, row, col, direction, word.length());
                        }
                    }
                }
            }
        }
    }



    // Marcação de posições e substituição de caracteres na sopa de letras para output

    static void markWordPositions(char[][] wordSoup, boolean[][] marked, int row, int col, Direction direction, int length) {
        for (int i = 0; i < length; i++) {
            // Marcar a posição atual baseada na direção
            marked[row][col] = true;
            
            switch (direction) {
                case RIGHT:
                    col++;
                    break;
                case DOWN:
                    row++;
                    break;
                case LEFT:
                    col--;
                    break;
                case UP:
                    row--;
                    break;
                case DOWN_RIGHT:
                    row++;
                    col++;
                    break;
                case DOWN_LEFT:
                    row++;
                    col--;
                    break;
                case UP_LEFT:
                    row--;
                    col--;
                    break;
                case UP_RIGHT:
                    row--;
                    col++;
                    break;
                default:
                    break;
            }
        }
    }
    
    
    static void replaceUnmarked(char[][] wordSoup, boolean[][] marked) {
        for (int row = 0; row < wordSoup.length; row++) {
            for (int col = 0; col < wordSoup[row].length; col++) {
                if (!marked[row][col]) {
                    wordSoup[row][col] = '.';
                }
            }
        }
    }




    // Output

    static void printWordSoup(char[][] wordSoup) {
        for (int row = 0; row < wordSoup.length; row++) {
            for (int col = 0; col < wordSoup[row].length; col++) {
                System.out.print(wordSoup[row][col] + " ");
            }
            System.out.println();
        }
    }
    

}
