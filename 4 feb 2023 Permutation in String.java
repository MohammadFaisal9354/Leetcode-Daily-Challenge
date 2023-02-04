class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int l1 = s1.length();
        int l2 = s2.length();
        if(l1>l2) return false;
     int[] arr = new int[26];
     
     for(int i=0;i<l1;i++)
     {
         arr[s1.charAt(i)-'a']++;
     }

     for(int i = 0;i<l2;i++)
     {
         arr[s2.charAt(i)-'a']--;
         if(i-l1 >= 0)
         arr[s2.charAt(i-l1)-'a']++;

         if(totalZero(arr)) return true;
     }
     return false;
    }
    
    private boolean totalZero(int[] arr)
    {
       for(int i =0 ;i<26;i++)
       {
           if(arr[i] != 0) return false;
       }
       return true;
    }
}
