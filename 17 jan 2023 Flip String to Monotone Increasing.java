class Solution {
    public int minFlipsMonoIncr(String s) {
        int n = s.length();
        int[] a = new int[n];        
        int totalzeroes=0, ones=0, zeroes=0;
        for(int i=0;i<n;i++)
        {
            if(s.charAt(i)=='0')
                totalzeroes++;
        }
        int min=Integer.MAX_VALUE;
        for(int i=0;i<n;i++)
        {
            if(s.charAt(i)=='0')
              zeroes++;
            a[i]=ones+(totalzeroes-zeroes);
            if(s.charAt(i)=='1')
               ones++;
            if(a[i]<min) 
                min=a[i]; 
        }
        return min;
    }
}
