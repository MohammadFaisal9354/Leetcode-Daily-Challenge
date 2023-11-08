class Solution {    
    public boolean isReachableAtTime(int sx, int sy, int fx, int fy, int t) {
        if(sx==fx && sy==fy) 
            return (t==1)?false:true;        
        else if(sx==fx) 
            return Math.abs(fy-sy)<=t;
        else if(sy==fy)
            return Math.abs(sx-fx)<=t ;
        else {
            int xdiff = Math.abs(sx-fx);
            int ydiff = Math.abs(sy-fy);
            ydiff -= (xdiff);
            boolean b1 = (t>=Math.abs(xdiff)+Math.abs(ydiff));
            ydiff = Math.abs(sy-fy);
            xdiff -= ydiff; 
            boolean b2 = (t>=Math.abs(xdiff)+Math.abs(ydiff));
            return (b1||b2);
        }
    }
}
