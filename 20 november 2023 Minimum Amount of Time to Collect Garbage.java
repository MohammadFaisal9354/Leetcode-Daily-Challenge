import java.util.Arrays;

class Solution {
    public int garbageCollection(String[] garbage, int[] travel) {
        int ans = 0;
        int n = garbage.length;
        boolean m = false, p = false, g = false;
        for (int i = n - 1; i >= 0; i--) {
            if (!g && garbage[i].contains("G")) {
                g = true;
                ans += Arrays.stream(travel, 0, i).sum();
            }
            if (!m && garbage[i].contains("M")) {
                m = true;
                ans += Arrays.stream(travel, 0, i).sum();
            }
            if (!p && garbage[i].contains("P")) {
                p = true;
                ans += Arrays.stream(travel, 0, i).sum();
            }
            if (m && p && g) {
                break;
            }
        }
        return Arrays.stream(garbage).mapToInt(String::length).sum() + ans;
    }
}
