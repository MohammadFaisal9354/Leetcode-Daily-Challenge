class Solution {
    public List<Integer> addToArrayForm(int[] num, int k) {
        List<Integer> ans = new ArrayList<>();
        int n = num.length;
        int carry = 0, i = n-1;
        while (k > 0 || i >= 0 || carry > 0) {
            int sum = carry;
            if (k > 0) {
                int remainder = k % 10;
                sum += remainder;
                k = k / 10;
            }
            if (i >= 0) {
                sum += num[i];
                i--;
            }
            carry = sum / 10;
            ans.add(0, sum % 10);
        }
        return ans;
    }
}
