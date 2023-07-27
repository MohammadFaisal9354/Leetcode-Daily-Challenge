class Solution {
    public boolean isPossibleToRun(int n, int[] batteries, long midTime)
    {
        long duration = 0;
        for(int element : batteries)
        {
            if(element< midTime)
            {
                duration += element;
            }
            else 
            {
                duration += midTime;
            }
        }
        return duration >= midTime * n;
    }

    public long maxRunTime(int n, int[] batteries) {
        long sum = 0;
        for(int element : batteries) sum += element;
        long startTime=0;
        long endTime = sum;
        long ans =0;
        while(startTime<=endTime)
        {
            long midTime = (startTime+endTime)/2;

            if(isPossibleToRun(n, batteries, midTime))
            {
                ans = midTime; 
                startTime = midTime + 1; 
            }
            else
            {
                endTime = midTime - 1;
            }
        }
        return ans;
    }
}
