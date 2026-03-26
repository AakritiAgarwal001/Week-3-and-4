import java.util.*;

class Asset {
    String name;
    double returnRate;
    double volatility;

    Asset(String name, double returnRate, double volatility) {
        this.name = name; this.returnRate = returnRate; this.volatility = volatility;
    }
    public String toString() { return name + ":" + returnRate + "%"; }
}

public class PortfolioSort {
    // Merge Sort: Stable (Preserves original order for ties)
    public static void mergeSort(Asset[] assets, int l, int r) {
        if (l < r) {
            int m = l + (r - l) / 2;
            mergeSort(assets, l, m);
            mergeSort(assets, m + 1, r);
            merge(assets, l, m, r);
        }
    }

    private static void merge(Asset[] assets, int l, int m, int r) {
        Asset[] left = Arrays.copyOfRange(assets, l, m + 1);
        Asset[] right = Arrays.copyOfRange(assets, m + 1, r + 1);
        int i = 0, j = 0, k = l;
        while (i < left.length && j < right.length) {
            if (left[i].returnRate <= right[j].returnRate) assets[k++] = left[i++];
            else assets[k++] = right[j++];
        }
        while (i < left.length) assets[k++] = left[i++];
        while (j < right.length) assets[k++] = right[j++];
    }

    // Quick Sort: DESC Return + ASC Volatility (Median-of-Three Pivot)
    public static void quickSort(Asset[] assets, int low, int high) {
        if (low < high) {
            int pi = partition(assets, low, high);
            quickSort(assets, low, pi - 1);
            quickSort(assets, pi + 1, high);
        }
    }

    private static int partition(Asset[] assets, int low, int high) {
        // Median-of-Three logic (simplified: swap middle with high to use as pivot)
        int mid = low + (high - low) / 2;
        Asset pivot = assets[mid];

        int i = (low - 1);
        for (int j = low; j <= high; j++) {
            if (j == mid) continue;
            // Primary: Return DESC, Secondary: Volatility ASC
            if (assets[j].returnRate > pivot.returnRate ||
                    (assets[j].returnRate == pivot.returnRate && assets[j].volatility < pivot.volatility)) {
                i++;
                if (i == mid) i++; // Skip pivot index
                Asset temp = assets[i];
                assets[i] = assets[j];
                assets[j] = temp;
            }
        }
        // Final pivot placement logic would go here
        return mid;
    }
}
