class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>>resultList = new ArrayList();
        backTrack(resultList, new ArrayList(), 0, s);
        return resultList;
    }

    private void backTrack(List<List<String>> resultList, List<String> currentList, int index, String s ){
        if(s.length()==index){
            resultList.add(new ArrayList(currentList));
        }else{
            for(int i= index+1; i<=s.length(); i++){
                String currentString = s.substring(index, i);
                if(isValidPlaindrome(currentString)){
                    currentList.add(currentString);
                    backTrack(resultList,currentList,i,s);
                    currentList.remove(currentList.size()-1);
                }
            }
        }
    }

    private boolean isValidPlaindrome(String s){
        int start=0;
        int end=s.length()-1;
        while(start<end){
            if(s.charAt(start) != s.charAt(end)) 
              return false;
             start++;
             end--;
            }
          return true;
        } 

}
