class Solution {
    public boolean canMakeArithmeticProgression(int[] arr) {        
        Arrays.sort(arr);
        int diff = arr[0] - arr[1];
        for (int i = 1; i < arr.length - 1; i++) 
            if (arr[i] - arr[i + 1] != diff)
                return false;
        return true;
    }
}
