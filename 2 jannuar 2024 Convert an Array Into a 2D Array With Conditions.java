class Solution {
    public List<List<Integer>> findMatrix(int[] nums) {
        List<List<Integer>> lol = new ArrayList<>();
        Arrays.sort(nums);
        int count = 1, max = 1;
        int a = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) 
                count++;
            else 
                count = 1;
            max = Math.max(count, max);
        }
        for (int j = 0; j < max; j++) 
            lol.add(new ArrayList<>());
        lol.get(0).add(nums[0]);
        for (int k = 1; k < nums.length; k++) {
            if (nums[k] == nums[k - 1]) 
                a = a + 1;
            else
                a = 0;
            if (a < max) 
                lol.get(a).add(nums[k]);
        }
        return lol;
    }
}
