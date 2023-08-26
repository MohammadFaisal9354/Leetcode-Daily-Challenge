class Solution {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, Comparator.comparingInt(o->o[1]));
        int i=0,j=1,c=1;
        while(i<pairs.length){
            if(j==pairs.length){i++;j=i+1;continue;}
            if(pairs[i][1]<pairs[j][0]){c++;i=j;j++;continue;}
            else{j++;}
        }
        return c;
    }
}
