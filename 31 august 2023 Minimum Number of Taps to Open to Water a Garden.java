class Solution {
    public int minTaps(int n, int[] ranges) {
        int r=ranges.length, ar[][]=new int[r][2];
        for(int i=0;i<r;i++) {
            ar[i][0]=Math.max(0, i-ranges[i]);
            ar[i][1]=Math.min(n, i+ranges[i]);
        }
        Arrays.sort(ar, (a,b)->a[0]-b[0]);
        int start=0, res=0;
        for(int i=0;i<r;) {
            int farthest = -1;
            for(;i<r && ar[i][0]<=start;i++) 
                farthest = Math.max(farthest, ar[i][1]);
            if(farthest<=start) return -1;
            start=farthest;
            res++;
            if(farthest==n) return res;
        }
        return res;
    }
}
