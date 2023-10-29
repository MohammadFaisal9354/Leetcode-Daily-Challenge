class Solution {
    public int poorPigs(int buckets, int tdie, int ttest) {
        int i=0;
        int test = ttest/tdie;
        while(Math.pow(test+1,i)< buckets)
            i++;
        return i;
    }
}
