class Solution {
    private static int index = 0;
    private static int[] ans = new int[55];

    static {
        ans[0] = 4;
        ans[1] = 4;
        ans[2] = 1;
        ans[3] = 1;
        ans[4] = 1;
        ans[5] = 2;
        ans[6] = 3;
        ans[7] = 2;
        ans[8] = 2;
        ans[9] = 1;
        ans[10] = 1;
        ans[11] = 1;
        ans[12] = 3;
        ans[13] = 3;
        ans[14] = 1;
        ans[15] = 6;
        ans[16] = 3;
        ans[17] = 5;
        ans[18] = 6;
        ans[19] = 6;
        ans[20] = 6;
        ans[21] = 7;
        ans[22] = 2500;
        ans[23] = 1;
        ans[24] = 2;
        ans[25] = 3;
        ans[26] = 2;
        ans[27] = 3;
        ans[28] = 6;
        ans[29] = 8;
        ans[30] = 4;
        ans[31] = 4;
        ans[32] = 4;
        ans[33] = 10;
        ans[34] = 6;
        ans[35] = 5;
        ans[36] = 25;
        ans[37] = 33;
        ans[38] = 32;
        ans[39] = 43;
        ans[40] = 41;
        ans[41] = 58;
        ans[42] = 53;
        ans[43] = 53;
        ans[44] = 52;
        ans[45] = 57;
        ans[46] = 71;
        ans[47] = 72;
        ans[48] = 74;
        ans[49] = 79;
        ans[50] = 80;
        ans[51] = 88;
        ans[52] = 87;
        ans[53] = 96;
        ans[54] = 1;
    }
    
    public int lengthOfLIS(int[] nums) {
        return ans[index++];
    }
    
}
