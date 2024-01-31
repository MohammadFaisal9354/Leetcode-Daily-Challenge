class Solution {
    public int[] dailyTemperatures(int[] temp) {
        int[] res = new int[temp.length];
        for (int i = temp.length - 2; i >= 0; i--) {
            int next = i + 1;
            while (next < temp.length && temp[next] <= temp[i]) {
                if (res[next] == 0) {
                    next = temp.length;
                    break;
                }
                next += res[next];
            }
            if (next < temp.length) res[i] = next - i;
        }
        return res;
    }
}
