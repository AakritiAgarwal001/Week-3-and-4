import java.util.*;

class Transaction {
    String id;
    double fee;
    String ts; // Timestamp

    Transaction(String id, double fee, String ts) {
        this.id = id; this.fee = fee; this.ts = ts;
    }
    public String toString() { return id + ":" + fee + "@" + ts; }
}

public class Questions {
    // Bubble Sort for small batches (<= 100)
    public static void bubbleSort(List<Transaction> txs) {
        int n = txs.size();
        int swaps = 0, passes = 0;
        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;
            passes++;
            for (int j = 0; j < n - i - 1; j++) {
                if (txs.get(j).fee > txs.get(j + 1).fee) {
                    Collections.swap(txs, j, j + 1);
                    swapped = true;
                    swaps++;
                }
            }
            if (!swapped) break; // Early termination
        }
        System.out.println("BubbleSort: " + txs + " // " + passes + " passes, " + swaps + " swaps");
    }

    // Insertion Sort for medium batches (100-1000)
    public static void insertionSort(List<Transaction> txs) {
        for (int i = 1; i < txs.size(); i++) {
            Transaction key = txs.get(i);
            int j = i - 1;
            // Sort by fee, then by timestamp for stability/detail
            while (j >= 0 && (txs.get(j).fee > key.fee ||
                    (txs.get(j).fee == key.fee && txs.get(j).ts.compareTo(key.ts) > 0))) {
                txs.set(j + 1, txs.get(j));
                j--;
            }
            txs.set(j + 1, key);
        }
        System.out.println("InsertionSort (Fee+TS): " + txs);
    }
}
