class Solution {
    public int maxWidthOfVerticalArea(int[][] points) {
        int[] arr = new int[points.length];
        for(int i=0; i<points.length; i++)
            arr[i] = points[i][0];
        Arrays.sort(arr);
        int res=0;
        for(int i=1; i<arr.length; i++)
            res = Math.max(res, arr[i]-arr[i-1]);
        return res;
    }
}
