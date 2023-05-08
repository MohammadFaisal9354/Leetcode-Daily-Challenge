class Solution {
    public int diagonalSum(int[][] mat) {
        int i = 0;
        int sum = 0;
        while (i < mat.length)
        {
            sum += mat[i][i];
            mat[i][i++] = 0;
        }
        i = 0;
        while (i < mat.length)
            sum += mat[i][mat.length - 1 - i++];
        return sum;
    }
}v
