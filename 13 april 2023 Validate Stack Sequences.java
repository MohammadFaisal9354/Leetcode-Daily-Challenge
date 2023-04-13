class Solution {
   public boolean validateStackSequences(int[] pushed, int[] poped) {
      int k=0,j=0;    
      for( int x :pushed)
      {
           pushed[k++] = x ;            
           while( k!=0 && poped[j]== pushed[k-1] )
            {
                j++;
                k--; 
            }          
      }   
    return k==0;
  }
}
