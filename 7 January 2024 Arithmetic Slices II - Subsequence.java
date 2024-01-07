class Solution {    
    static int helper(int arr[]){
        int n = arr.length;
        ArrayList<HashMap<Long,Long>> dp = new ArrayList<>();
        long ans = 0;
        for(int i=0; i<n; i++){
            HashMap<Long,Long> hpi = new HashMap<>();
            dp.add(hpi);
            for(int j=0; j<i; j++){
                long diff = ((long)arr[i]-(long)arr[j]);
                HashMap<Long,Long> hpj = dp.get(j);
                if(hpj.containsKey(diff))
                    ans = ans+hpj.get(diff);
                hpi.put(diff,hpi.getOrDefault(diff,(long)0)+hpj.getOrDefault(diff,(long)0)+1);
            }
        }
        return (int)ans;
    }
 
    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        if(n<3) return 0;
        return helper(nums);
    }
}
