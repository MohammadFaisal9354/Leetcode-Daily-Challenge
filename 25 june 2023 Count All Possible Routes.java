class Solution {
    public int memo(int locations[], int curr, int finish, int remainfuel, int dp[][]){
        if(remainfuel < 0){
            return 0;
        }

        if(dp[curr][remainfuel] != -1){
            return dp[curr][remainfuel];
        }

        int ans = curr == finish ? 1 : 0;

        for(int i = 0; i < locations.length; i++){
            if(i != curr){
                ans = (ans + memo(locations, i, finish, remainfuel - Math.abs(locations[i] - locations[curr]), dp)) % 1000000007;
            }
        }
        
        return dp[curr][remainfuel] = ans;
    }
    public int countRoutes(int[] locations, int start, int finish, int fuel) {
        int n = locations.length;
        int dp[][] = new int[n][fuel + 1];
        for(int i = 0; i < n; i++){
            Arrays.fill(dp[i], -1);
        }

        return memo(locations, start, finish, fuel, dp);
    }
}
