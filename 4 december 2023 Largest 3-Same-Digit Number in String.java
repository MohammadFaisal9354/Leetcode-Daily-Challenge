class Solution {
    public String largestGoodInteger(String num) {
        
        String[] arr = {"000", "111", "222", "333", "444", "555", "666", "777", "888", "999"};
         
        for(int i = arr.length-1;i >=0;--i){
            if(num.contains(arr[i])){
                return arr[i];
            }
        }
        return "";
    }
}
