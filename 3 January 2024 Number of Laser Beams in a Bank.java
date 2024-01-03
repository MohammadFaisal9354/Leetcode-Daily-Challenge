class Solution {
    public int numberOfBeams(String[] bank) {
        int prevSecDevCnt = 0, rows = bank.length, cols = bank[0].length(), laserCnt = 0;
        for(int r = 0; r < rows; r++){
            int curSecDevCnt = 0;
            for(int c = 0; c < cols; c++){
                curSecDevCnt += bank[r].charAt(c) - '0';   
            }
            laserCnt  += curSecDevCnt * prevSecDevCnt;
            if(curSecDevCnt > 0)
                prevSecDevCnt = curSecDevCnt;
        }
        return laserCnt;
    }
}
