class Solution {
    public int minSpeedOnTime(int[] dist, double hour) {
       int lo = 1;
       int hi = 10000000;
       while(lo < hi){
           int mid = (lo + hi) / 2;           
           if(isValid(dist, hour, mid))
               hi = mid;           
           else
               lo = mid + 1;
       }     
       if(isValid(dist, hour, lo))           
           return lo;       
        return -1;
    }
    boolean isValid(int[] dist, double hours, int speed){
        double time = 0;
            for(int i = 0; i < dist.length; i++){
                if(i == dist.length - 1)
                    time += ((double) dist[i] / (double) speed);                
                else
                time += Math.ceil(( (double)dist[i] /  (double) speed));
            }
        if(time <= hours)
            return true;
        return false;
    }
}
