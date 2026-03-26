public class RiskThresholds {
    public static void findRange(int[] sortedRisks, int threshold) {
        int low = 0, high = sortedRisks.length - 1;
        int floor = -1, ceiling = -1;
        int comps = 0;

        while (low <= high) {
            comps++;
            int mid = low + (high - low) / 2;
            if (sortedRisks[mid] == threshold) {
                floor = ceiling = sortedRisks[mid];
                break;
            } else if (sortedRisks[mid] < threshold) {
                floor = sortedRisks[mid]; // Potential floor
                low = mid + 1;
            } else {
                ceiling = sortedRisks[mid]; // Potential ceiling
                high = mid - 1;
            }
        }
        System.out.println("Floor: " + floor + ", Ceiling: " + ceiling + " (Comps: " + comps + ")");
    }

    // Binary search for insertion point
    public static int findInsertionPoint(int[] sortedRisks, int newRisk) {
        int low = 0, high = sortedRisks.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (sortedRisks[mid] < newRisk) low = mid + 1;
            else high = mid - 1;
        }
        return low; // Index where newRisk should be inserted
    }
}
