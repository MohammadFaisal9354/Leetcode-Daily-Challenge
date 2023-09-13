class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] left = new int[n];
        int[] right = new int[n];
        Arrays.fill(left, 1);
        Arrays.fill(right, 1);
        for(int i=0; i<n-1; i++){
            if(ratings[i+1] > ratings[i]){
                left[i+1] = left[i] + 1;
            }
        }
        for(int i=n-1; i>0; i--){
            if(ratings[i-1] > ratings[i]){
                right[i-1] = right[i] + 1;
            }
        }
        int[] finalCandy = new int[n];
        for(int i=0; i<n; i++){
            finalCandy[i] = Math.max(left[i], right[i]);
        }
        int sumOfCandies=0;
        for(int i=0; i<finalCandy.length; i++){
            sumOfCandies = sumOfCandies + finalCandy[i];
        }
        return sumOfCandies;
    }
}
