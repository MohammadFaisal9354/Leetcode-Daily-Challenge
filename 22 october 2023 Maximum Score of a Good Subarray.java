class Solution {
      public int maximumScore(int[] arr, int k) {
        int[][] minima = new int[2][arr.length];
        Stack<Integer> stack = new Stack<>();
        for (int[] a : minima) 
            Arrays.fill(a, -1);        
        for (int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) 
                minima[0][stack.pop()] = i;            
            if (!stack.isEmpty()) 
                minima[1][i] = stack.peek();
            stack.push(i);
        }
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            int right = minima[0][i] != -1 ? minima[0][i] -1 : arr.length - 1;
            int left = minima[1][i] != -1 ? minima[1][i] + 1 : 0;
            ans = (left <= k) && (k <= right) ? Math.max(ans, arr[i] * (right - left + 1)) : ans;
        }
        return ans;
    }
}
