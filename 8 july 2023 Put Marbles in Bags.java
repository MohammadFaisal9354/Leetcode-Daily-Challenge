class Solution {
    public long putMarbles(int[] weights, int k) {
    ArrayList<Integer> a=new ArrayList<>();
    for(int i=1;i<weights.length;i++)    
        a.add(weights[i]+weights[i-1]);    
    Collections.sort(a);
    long min=0,max=0;
    int x=a.size()-1;
    for(int i=1;i<k;i++)
    {
       min+=a.get(i-1);
       max+=a.get(x);
        x--;
    }
    return max-min;
}
}
