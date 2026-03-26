public class AccountLookup {
    // Linear Search: Find first occurrence
    public static int linearSearch(String[] logs, String target) {
        int comps = 0;
        for (int i = 0; i < logs.length; i++) {
            comps++;
            if (logs[i].equals(target)) {
                System.out.println("Linear Comps: " + comps);
                return i;
            }
        }
        return -1;
    }

    // Binary Search: Find index and count duplicates (Requires Sorted Input)
    public static void binarySearchWithCount(String[] sortedLogs, String target) {
        int low = 0, high = sortedLogs.length - 1, comps = 0;
        int foundIdx = -1;

        while (low <= high) {
            comps++;
            int mid = low + (high - low) / 2;
            int res = target.compareTo(sortedLogs[mid]);
            if (res == 0) {
                foundIdx = mid;
                break;
            } else if (res > 0) low = mid + 1;
            else high = mid - 1;
        }

        if (foundIdx != -1) {
            // Count occurrences by expanding from foundIdx
            int count = 0;
            int temp = foundIdx;
            while (temp >= 0 && sortedLogs[temp].equals(target)) { count++; temp--; }
            temp = foundIdx + 1;
            while (temp < sortedLogs.length && sortedLogs[temp].equals(target)) { count++; temp++; }
            System.out.println("Binary Index: " + foundIdx + ", Comps: " + comps + ", Count: " + count);
        }
    }
}
