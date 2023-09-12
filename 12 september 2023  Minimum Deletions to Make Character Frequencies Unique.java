class Solution {
    static int isPerfectNumber(long N) {
        if(N <= 1)return 0;
        long sum = 1;
        for(int i=2; i<=Math.sqrt(N); i++){
           if(N%i == 0)
               sum = sum+i+(N/i);
        }
        if(sum == N)
           return 1;
        else
           return 0;
    }
}
