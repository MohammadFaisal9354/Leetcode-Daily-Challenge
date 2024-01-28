class Solution {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int result = 0;
        for(int i=0;i<matrix.length;i++){
            for(int j=1;j<matrix[0].length;j++){
                matrix[i][j] = matrix[i][j-1] + matrix[i][j]; 
            }
        }
        for(int i=0;i<matrix.length;i++){
            int[] arr = new int[matrix[0].length+1];
            for(int j = i;j<matrix.length;j++){
                for(int k=0;k<matrix[0].length;k++)
                    arr[k+1] = arr[k+1] + matrix[j][k];
                result += targetSum(arr,target);
            }
        }
        return result;
    }
    private int targetSum(int[] arr,int k){
        int result = 0;
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<arr.length;i++){
            if(map.containsKey(arr[i]-k))
                result += map.get(arr[i]-k);
                map.put(arr[i],map.getOrDefault(arr[i],0) + 1);
        }
        return result;
    }
}
