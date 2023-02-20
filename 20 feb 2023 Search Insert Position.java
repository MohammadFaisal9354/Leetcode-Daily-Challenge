class Solution {
    public int searchInsert(int[] a, int target) {
        if(a[0]==target||a[0]>target)
        return 0;
        for(int i=1;i<a.length;i++)
        {
            if(a[i]==target)
            return i;
            else if(a[i]>target)
            {
                if(a[i-1]<target)
                return i;
            }

        }
        return a.length;
    }
}
