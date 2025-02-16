# Threaded List Adder

This project demonstrates the use of multi-threading in Java to concurrently add elements to a shared list. The program utilizes a synchronized list to ensure thread-safety while multiple threads
simultaneously modify the list.

## Description

The program creates a specified number of threads (`threadCount`), and each thread adds a fixed number of elements (`addCount`) to a shared list. The list is synchronized to prevent concurrency issues
like data races or inconsistencies when multiple threads modify it at the same time. After all threads have finished adding elements, the program outputs the size of the list and compares it to the expected value.

### How it works:
- **Synchronized List**: The list is wrapped in `Collections.synchronizedList()` to ensure safe concurrent modifications.
- **Threads**: A `ListEditor` thread class is used to perform the task of adding elements to the list. Each thread adds a predefined number of elements (in this case, the integer `123`).
- **Thread Management**: The threads are started using `start()`, and the main thread waits for all threads to finish using `join()`.
- **Expected Output**: The program calculates the expected size of the list (`threadCount * addCount`) and compares it with the actual size of the list after all threads have completed their work.
