class Solution {
    public int findSpecialInteger(int[] arr) {
        int i=arr.length/4;
        for(int j=0;j<arr.length-i;j++){            
            if(arr[j]==arr[j+i])return arr[j];
        }
        return -1;
    }
}
