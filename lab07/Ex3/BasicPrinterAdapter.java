import java.util.ArrayList;
import java.util.List;

public class BasicPrinterAdapter implements InterfaceBasicPrinter {
    private BasicPrinter basicPrinter;

    public BasicPrinterAdapter(BasicPrinter basicPrinter) {
        this.basicPrinter = basicPrinter;
    }

    @Override
    public boolean print(String[] documents) {
        return basicPrinter.print(documents);
    }

    @Override
    public void refill() {
        basicPrinter.refill();
    }

    public int print(Document document) {
        String[] documents = {document.getContent()};
        if (basicPrinter.print(documents)) {
            return documents.length;
        } else {
            return 0;
        }
    }

    public List<Integer> print(List<Document> documents) {
        List<Integer> pagesPrinted = new ArrayList<>();
        for (Document document : documents) {
            pagesPrinted.add(print(document));
        }
        return pagesPrinted;
    }

    public void showQueuedJobs() {
        System.out.println("Não há jobs enfileirados.");
    }

    public boolean cancelJob(int jobId) {
        System.out.println("Não há jobs para cancelar.");
        return false;
    }

    public void cancelAll() {
        System.out.println("Não há jobs para cancelar.");
    }
}
