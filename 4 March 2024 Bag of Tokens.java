class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        int max_score = 0, curr_score = 0, n = tokens.length;
        Arrays.sort(tokens);
        for(int i = 0; i < n; i++){
            if(curr_score == 0 && tokens[i] > power)
                return max_score;
            if(tokens[i] <= power){
                curr_score++;
                power -= tokens[i];
            }else{
                curr_score--;
                power += tokens[n-1];
                n--;
                i--;
            }
            max_score = Math.max(max_score, curr_score);
        }        
        return max_score;
    }
}
