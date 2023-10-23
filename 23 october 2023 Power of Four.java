class Solution {
    public boolean isPowerOfFour(int n) {        
        while(n>1){
            if(n%4!=0) return false;
            n=n/4;
        }
        if(n==1) return true;
        return false;
    }
}
