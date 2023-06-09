class Solution {
    public char nextGreatestLetter(char[] l, char t) 
    {
        char ans=l[0];
        for(int i=0;i<l.length;i++)
        {
            if(l[i]>t)
            {
                ans=l[i];
                break;
            }
         }
        return ans;
    }
}
