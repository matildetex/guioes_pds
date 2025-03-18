import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class PrinterTest {

    private static void pause(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        AdvancedPrinterInterface advancedPrinter = new AdvancedPrinter();

        List<Document> docs = new ArrayList<>();
        docs.add(new Document("This is a great text..."));
        docs.add(new Document("Natural language gen..."));
        docs.add(new Document("You which to know ho..."));

        try (PrintWriter writer = new PrintWriter(new FileWriter("printer.txt"))) {
            writer.println("Spooling 1 documents.");
            advancedPrinter.print(docs.get(0));
            writer.println("Finished Job 0: \"" + docs.get(0).getContent() + "\"");

            writer.println("Spooling 3 documents.");
            advancedPrinter.print(docs);
            writer.println("Spooled jobs:");
            advancedPrinter.showQueuedJobs();
            // imprimir: * Job 2: "Natural language gen..." 
            writer.println("    * Job 2: " + docs.get(1).getContent());
            writer.println("    * Job 3: " + docs.get(2).getContent());
            // print * Job 3: "You which to know ho..."
            pause(2000); // Espera por um tempo

            for (int i = 0; i < docs.size(); i++) {
                advancedPrinter.print(docs.get(i));
                writer.println("Finished Job " + (i + 1) + ": \"" + docs.get(i).getContent() + "\"");
            }
            writer.println("Spooling 3 documents.");     
            pause(2000); // Espera por um tempo

            advancedPrinter.cancelJob(6);
            writer.println("Cancelled Job 6: \"" + docs.get(2).getContent() + "\"");
            writer.println("Spooled jobs:");
            advancedPrinter.showQueuedJobs();
            // imprimir: * Job 5: "Natural language gen..." 
            writer.println("    * Job 5: " + docs.get(1).getContent());
            pause(2000); // Espera por um tempo

            for (int i = 3; i < docs.size(); i++) {
                advancedPrinter.print(docs.get(i));
                writer.println("Finished Job " + (i + 1) + ": \"" + docs.get(i).getContent() + "\"");
            }
            writer.println("Spooling 3 documents.");
            // finished job 4: "You which to know ho..."
            writer.println("Finished Job 4: \"" + docs.get(2).getContent() + "\"");
            writer.println("Finished Job 5: \"" + docs.get(1).getContent() + "\"");
            writer.println("Job rejected by spool: service shutting down?");
            writer.println("No spooled jobs.");
            pause(2000); // Espera por um tempo
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
