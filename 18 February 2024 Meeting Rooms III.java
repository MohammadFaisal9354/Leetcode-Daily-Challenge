class Solution {
    public int mostBooked(int n, int[][] meetings) {
        Arrays.sort(meetings, (a, b) -> a[0] - b[0]);
		long[] rooms = new long[n];
        int[] cnt = new int[n];
        for(int[] meet: meetings){
            int start = meet[0]; int end = meet[1];
            int pos = 0;
            for(int i=0; i<n; i++){
                if(rooms[i] <= start){
                    pos = i;
                    break;
                }
                if(rooms[i] < rooms[pos])
                    pos = i;
            }
                if(rooms[pos] <= start){
                    rooms[pos] = end;
                }
                else{
                    rooms[pos] += ((long)end-start);
                }
                cnt[pos]++ ;
        }
        int mx = 0;
        for(int i=0; i<n; i++){
            if(cnt[i] > cnt[mx])
            mx = i;
        }
        return mx;
    }
}
