class Solution {
    public int search(int[] arr, int t) {
        int l=0;
        int b=0;
        int h=arr.length-1;
        Map<Integer,Integer> fdfs=new HashMap<Integer,Integer>();
       for(int i=0;i<arr.length;i++){
           fdfs.put(arr[i],i);
       } 
       if(fdfs.containsKey(t)){
         b=b+fdfs.get(t);
          return b;
       }
      return -1;
    }
}
