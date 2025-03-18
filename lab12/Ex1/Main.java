package Ex1;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<MobilePhone> phones = new ArrayList<>();
        phones.add(new MobilePhone("Processor A", 999.99, 8, 12.0));
        phones.add(new MobilePhone("Processor B", 799.99, 6, 8.0));
        phones.add(new MobilePhone("Processor C", 499.99, 4, 16.0));
        phones.add(new MobilePhone("Processor D", 299.99, 3, 5.0));

        StrategySetter context = new StrategySetter(phones);

        // BubbleSort
        context.setStrategy(new BubbleSort());
        System.out.println("BubbleSort: " + context.sort());

        // QuickSort
        context.setStrategy(new QuickSort());
        System.out.println("QuickSort: " + context.sort());

        // MergeSort
        context.setStrategy(new MergeSort());
        System.out.println("MergeSort: " + context.sort());
    }
}