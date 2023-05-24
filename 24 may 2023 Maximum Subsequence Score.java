class Solution {
    public long maxScore(int[] nums1, int[] nums2, int k) {
        int n = nums1.length; 
        int[][] aug = new int[n][2]; 
        for (int i = 0; i < n; ++i) {
            aug[i][0] = nums1[i]; 
            aug[i][1] = nums2[i]; 
        }
        Arrays.sort(aug, new Comparator<int[]>(){
            public int compare(int[] lhs, int[] rhs) {
                return -Integer.compare(lhs[1], rhs[1]); 
            }
        }); 
        PriorityQueue<Integer> pq = new PriorityQueue(); 
        long ans = 0, total = 0; 
        for (int i = 0; i < aug.length; ++i) {
            total += aug[i][0]; 
            pq.add(aug[i][0]); 
            if (i >= k) total -= pq.poll(); 
            if (i >= k-1) ans = Math.max(ans, total * aug[i][1]); 
        }
        return ans; 
    }
}
