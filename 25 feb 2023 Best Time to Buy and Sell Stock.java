class Solution {
    public int maxProfit(int[] a) {
        int buy=a[0];        
        int p=0;
        for(int i=1;i<a.length;i++)
        {
            if(a[i]-buy>p)
            p=a[i]-buy;
            if(buy>a[i])
            buy=a[i];

        }
        return p;
    }
}
