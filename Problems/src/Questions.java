class Trade {
    int volume;
    Trade(int v) { this.volume = v; }
}

public class TradeAnalysis {
    // Merge Sort (Stable, Ascending)
    public static void mergeSort(Trade[] trades, int l, int r) {
        if (l < r) {
            int m = l + (r - l) / 2;
            mergeSort(trades, l, m);
            mergeSort(trades, m + 1, r);
            merge(trades, l, m, r);
        }
    }

    private static void merge(Trade[] trades, int l, int m, int r) {
        Trade[] left = Arrays.copyOfRange(trades, l, m + 1);
        Trade[] right = Arrays.copyOfRange(trades, m + 1, r + 1);
        int i = 0, j = 0, k = l;
        while (i < left.length && j < right.length) {
            if (left[i].volume <= right[j].volume) trades[k++] = left[i++];
            else trades[k++] = right[j++];
        }
        while (i < left.length) trades[k++] = left[i++];
        while (j < right.length) trades[k++] = right[j++];
    }

    // Quick Sort (In-place, Descending)
    public static void quickSort(Trade[] trades, int low, int high) {
        if (low < high) {
            int pi = partition(trades, low, high);
            quickSort(trades, low, pi - 1);
            quickSort(trades, pi + 1, high);
        }
    }

    private static int partition(Trade[] trades, int low, int high) {
        int pivot = trades[high].volume;
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (trades[j].volume > pivot) { // Descending
                i++;
                Trade temp = trades[i];
                trades[i] = trades[j];
                trades[j] = temp;
            }
        }
        Trade temp = trades[i + 1];
        trades[i + 1] = trades[high];
        trades[high] = temp;
        return i + 1;
    }
}
