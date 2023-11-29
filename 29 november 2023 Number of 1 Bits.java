public class Solution {
    // you need to treat n as an unsigned value
    int count = 0;
    public int hammingWeight(int n) {
    for(int i = 0; i< 32;i++){ 
         if((n&1)==1)count++;        
         n= n>>1;
        }
        return count;
    }
}
