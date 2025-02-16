package threaded_list_adder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public class App2 {

    public static void main(String[] args) {
        // Create a synchronized list to ensure thread-safety
        List<Integer> sharedList = Collections.synchronizedList(new ArrayList<>());

         // Define the number of threads to create and the number of elements each thread will add
        int threadCount = 100;
        int addCount = 1000;

        // Generate a list of ListEditor threads using Java Streams
        // Each thread will add 'addCount' elements to the shared list
        List<ListEditor> counters = Stream.generate(() -> new ListEditor(sharedList, addCount)).limit(threadCount).toList();
        counters.forEach(c -> c.start());

         // Wait for all threads to finish before proceeding
        counters.forEach(c -> {
            try {
                c.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
         
        System.out.printf("Got %d, expected %d%n", sharedList.size(), threadCount*addCount);
    }
}


// Class representing a thread that will add elements to the shared list
class ListEditor extends Thread {

    List<Integer> l;
    private final int count;

    public ListEditor(List<Integer> l, int count) {
        this.l = l;
        this.count = count;
    }

    // Method executed when the thread starts
    public void run() {
        for (int i=0; i<count;i++) {
            l.add(123);
        }
    }
}