class Solution {
    public boolean halvesAreAlike(String s) {
        int n= s.length();
        int lw=0,rw=0;
        for(int i=0,j=(n/2);i<n/2&&j<n;i++,j++)
        {   
            char c= Character.toLowerCase(s.charAt(i));
            if(c=='a'||c=='e'||c=='i'||c=='o'||c=='u')
            lw++;
            char d= Character.toLowerCase(s.charAt(j));
            if(d=='a'||d=='e'||d=='i'||d=='o'||d=='u')
            rw++;
        }
        if(lw==rw)
            return true;
        return false;
    }
}
