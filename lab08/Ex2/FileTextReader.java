import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileTextReader implements InterfaceTextReader {
    private Scanner scanner;

    public FileTextReader(File file) {
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean hasNext() {
        return scanner.hasNextLine();
    }

    @Override
    public String next() {
        if (!hasNext()) {
            return null;
        }
        return scanner.nextLine();
    }
}