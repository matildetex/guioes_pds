import java.io.File;

public class Main {
    public static void main(String[] args) {
        File f = new File("Ex2/file.txt");

        InterfaceTextReader r1 = new FileTextReader(f);
        InterfaceTextReader r2 = new CapitalizationFilter(new FileTextReader(f));
        InterfaceTextReader r3 = new NormalizationFilter(new TermFilter(new FileTextReader(f))); 
        InterfaceTextReader r4 = new VowelFilter(new NormalizationFilter(new FileTextReader(f)));
        InterfaceTextReader r5 = new VowelFilter(new TermFilter(new FileTextReader(f)));
        InterfaceTextReader r6 = new CapitalizationFilter(new TermFilter(new FileTextReader(f))); 
        InterfaceTextReader r7 = new NormalizationFilter(new VowelFilter(new CapitalizationFilter(new TermFilter(new FileTextReader(f))))); 
        
        InterfaceTextReader InterfaceTextReaderList[] = {r1, r2, r3, r4, r5, r6, r7};
        
        System.out.println("\n");
        
        for (InterfaceTextReader reader : InterfaceTextReaderList) {
            String result;
            while ((result = reader.next()) != null) {
                System.out.println(result);
            }
            System.out.println();
        }
    }
}
