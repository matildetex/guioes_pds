

public class PrintJob implements Runnable {
    private int jobId;
    private String[] content;
    private BasicPrinter basicPrinter;
    private static int nextId = 0;
    Document document;

    public PrintJob(int jobId, String[] content, BasicPrinter basicPrinter) {
        this.jobId = jobId;
        this.content = content;
        this.basicPrinter = basicPrinter;
    }
    public PrintJob(Document document) {
        this.jobId = nextId++;
        this.document = document;
    }
    
    @Override
    public void run() {
        basicPrinter.print(content);
    }

    public int getJobId() {
        return jobId;
    }
}