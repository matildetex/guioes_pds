import java.io.File;
import java.io.FileNotFoundException; 
import java.io.PrintStream;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

public class WSGenerator {

    public static void main (String[] args) {
        String filename = "";
        int grideSize = 0;
        String outputFilename = "";

        // 2 parametros obrigatorios:
        // -i: input file name
        // -s: grid size
        if (args.length < 4) {
            System.err.println("Too few arguments");
            System.exit(1);
        } else if (args.length > 6) {
            System.err.println("Too many arguments");
            System.exit(1);
        }

        boolean iOption = false;
        boolean sOption = false;

        if (args[0].equals("-i")) {
            iOption = true;
            if (args[1].contains(".txt")) {
                filename = args[1];
            } else {
                System.err.println("File must be a .txt");
                System.exit(1);
            }
        }

        if (args[2].equals("-s")) {
            sOption = true;
            try {
                grideSize = Integer.parseInt(args[3]);
            } catch (NumberFormatException e) {
                System.err.println("Grid size must be a number");
                System.exit(1);
            }
        }

        if (args.length == 6) {
            if (args[4].equals("-o")) {
                if (args[5].contains(".txt")) {
                    outputFilename = args[5];
                } else {
                    System.err.println("File must be a .txt");
                    System.exit(1);
                }
            }
        }

        if (!iOption && !sOption) {
            System.err.println("-i and -s options are mandatory");
            System.exit(1);
        }

        SoupGenerator generator = new SoupGenerator();
        char[][] completedSoup = null;
        if (generator.readFile(filename)) {
            generator.createSoup(grideSize);
            completedSoup = generator.completeSoup(grideSize);
        } else {
            System.err.println("Error reading file");
            System.exit(1);
        }

        if (outputFilename.isEmpty()){
            for (int i = 0; i < grideSize; i++) {
                for (int j = 0; j < grideSize; j++) {
                    System.out.print(completedSoup[i][j]);
                }
                System.out.println();
            }

            ArrayList<String> words = generator.getWords();
            for (String word : words) {
                System.out.print(word + " ");
            }
        } else {
            PrintStream fileStream = null;
            try {
                fileStream = new PrintStream(new File(outputFilename));
            } catch (FileNotFoundException e) {
                System.err.println("Output file not found");
                System.exit(1);
            }

            System.setOut(fileStream);

            for (int i = 0; i < grideSize; i++) {
                for (int j = 0; j < grideSize; j++) {
                    System.out.print(completedSoup[i][j]);
                }
                System.out.println();
            }

            ArrayList<String> words = generator.getWords();
            for (String word : words) {
                System.out.print(word + " ");
            }
        }
    }
}

class SoupGenerator {
    private ArrayList<String> words = new ArrayList<String>();
    private char[][] soup;

    public boolean readFile(String filename) {
        boolean sucess = true;
        try {
            Scanner reader = new Scanner(new File(filename));

            while (sucess && reader.hasNextLine()) {
                String[] wordsData = reader.nextLine().split("[,; ]");
                for (int i = 0; i < wordsData.length; i++) {
                    if(!wordsData[i].matches("^(?=.*[a-z])[a-zA-Z]+$")) {
                        sucess = false;
                    } else {
                        words.add(wordsData[i]);
                    }
                }
            }
            reader.close();

        } catch (FileNotFoundException e) {
            System.err.println("File not found");
            return sucess;
        }
        return sucess;
    }

    public char[][] createSoup(int size) {
        soup = new char[size][size];
        ArrayList<String> insertedWords = new ArrayList<String>();
        int posx = 0, posy = 0;

        for (char[] row : soup) {
            Arrays.fill(row, '*');
        }

        for (String word : words) {
            char[] wordChars = word.toUpperCase().toCharArray(); // convert to uppercase
            word = String.copyValueOf(wordChars);

            if (word.length() > size) {
                System.err.println("Word bigger than grid size");
                System.exit(1);
            }

            while (!insertedWords.contains(word)) {
                Direction direction = Direction.values()[(int) (Math.random() * 7)];

                if (insideAnotherWord(word, words)) {
                    insertedWords.add(word); 
                    continue;
                } else {
                    boolean fits = true;

                    switch (direction) {
                        case UP:
                            posx = randomInt(0, size - 1);
                            posy = randomInt(word.length() - 1, size - 1);

                            for (int i = 0; i < word.length(); i++) {
                                if (soup[posx][posy - i] != '*' && soup[posx][posy - i] != word.charAt(i)) 
                                    fits = false;
                            }

                            if (fits) {
                                for (int i = 0; i < word.length(); i++) {
                                    soup[posx][posy--] = word.charAt(i);
                                }
                                insertedWords.add(word);
                            }
                            break;

                        case DOWN:
                            posx = randomInt(0, size - 1);
                            posy = randomInt(0, size - word.length());

                            for (int i = 0; i < word.length(); i++) {
                                if (soup[posx][posy + i] != '*' && soup[posx][posy + i] != word.charAt(i))
                                    fits = false;
                            }

                            if (fits) {
                                for (int i = 0; i < word.length(); i++) {
                                    soup[posx][posy++] = word.charAt(i);
                                }
                                insertedWords.add(word);
                            }
                            break;
                        
                        case LEFT:
                            posx = randomInt(word.length() - 1, size - 1);
                            posy = randomInt(0, size - 1);

                            for (int i = 0; i < word.length(); i++) {
                                if (soup[posx - i][posy] != '*' && soup[posx - i][posy] != word.charAt(i))
                                    fits = false;
                            }

                            if (fits) {
                                for (int i = 0; i < word.length(); i++) {
                                    soup[posx--][posy] = word.charAt(i);
                                }
                                insertedWords.add(word);
                            }
                            break;

                        case RIGHT:
                            posx = randomInt(0, size - word.length());
                            posy = randomInt(0, size - 1);

                            for (int i = 0; i < word.length(); i++) {
                                if (soup[posx + i][posy] != '*' && soup[posx + i][posy] != word.charAt(i))
                                    fits = false;
                            }

                            if (fits) {
                                for (int i = 0; i < word.length(); i++) {
                                    soup[posx++][posy] = word.charAt(i);
                                }
                                insertedWords.add(word);
                            }
                            break;

                        case UP_LEFT:
                            posx = randomInt(word.length() - 1, size - 1);
                            posy = randomInt(word.length() - 1, size - 1);

                            for (int i = 0; i < word.length(); i++) {
                                if (soup[posx - i][posy - i] != '*' && soup[posx - i][posy - i] != word.charAt(i))
                                    fits = false;
                            }

                            if (fits) {
                                for (int i = 0; i < word.length(); i++) {
                                    soup[posx--][posy--] = word.charAt(i);
                                }
                                insertedWords.add(word);
                            }
                            break;

                        case UP_RIGHT:
                            posx = randomInt(0, size - word.length());
                            posy = randomInt(word.length() - 1, size - 1);

                            for (int i = 0; i < word.length(); i++) {
                                if (soup[posx + i][posy - i] != '*' && soup[posx + i][posy - i] != word.charAt(i))
                                    fits = false;
                            }

                            if (fits) {
                                for (int i = 0; i < word.length(); i++) {
                                    soup[posx++][posy--] = word.charAt(i);
                                }
                                insertedWords.add(word);
                            }
                            break;
                        
                        case DOWN_LEFT:
                            posx = randomInt(word.length() - 1, size - 1);
                            posy = randomInt(0, size - word.length());

                            for (int i = 0; i < word.length(); i++) {
                                if (soup[posx - i][posy + i] != '*' && soup[posx - i][posy + i] != word.charAt(i))
                                    fits = false;
                            }

                            if (fits) {
                                for (int i = 0; i < word.length(); i++) {
                                    soup[posx--][posy++] = word.charAt(i);
                                }
                                insertedWords.add(word);
                            }
                            break;

                        case DOWN_RIGHT:
                            posx = randomInt(0, size - word.length());
                            posy = randomInt(0, size - word.length());

                            for (int i = 0; i < word.length(); i++) {
                                if (soup[posx + i][posy + i] != '*' && soup[posx + i][posy + i] != word.charAt(i))
                                    fits = false;
                            }

                            if (fits) {
                                for (int i = 0; i < word.length(); i++) {
                                    soup[posx++][posy++] = word.charAt(i);
                                }
                                insertedWords.add(word);
                            }
                            break;
                        
                        case NONE:
                            break;
                        
                    }
                }
            }
        } 
        
        /* 
           for (int r = 0; r < soup.length; r++) { 
            for (int c = 0; c < soup[r].length; c++) { 
            System.out.print(soup[r][c] + " ");
            }
            System.out.println();
        }
        System.out.println(); 
        */
        
        return soup;
    }

    public char[][] completeSoup(int size) {
        char[][] completedSoup = this.soup;

        String upperAlphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        for (int i = 0; i < size; i++) {
            for(int j = 0; j < size; j++) {
                if (completedSoup[i][j] == '*') {
                    int index = randomInt(0, 25);
                    completedSoup[i][j] = upperAlphabet.charAt(index);
                }
            }
        }
        return completedSoup;
    }

    public ArrayList<String> getWords() {
        return this.words;
    }

    private boolean insideAnotherWord (String word, ArrayList<String> wordList) {
        String reversed = new StringBuilder(word).reverse().toString();
        for (String s : wordList) {
            if (s.contains(word) || s.contains(reversed)) {
                return true;
            }
        }
        return false;
    }

    private int randomInt (int min, int max) {

        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }
        return (int) (Math.random() * ((max - min) + 1)) + min;
    }
}
