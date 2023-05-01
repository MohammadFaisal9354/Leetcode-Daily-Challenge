class Solution {
    public double average(int[] salary) {
        int n = salary.length;
        if(n == 0) return 0;
        int min = salary[0];
        int max = salary[0];
        double sum = 0L;
        for(int i : salary){
            min = Math.min(i,min);
            max = Math.max(i,max);
            sum+=i;
        }
        sum-=min;
        sum-=max;
        return sum/(n-2);

    }
}
