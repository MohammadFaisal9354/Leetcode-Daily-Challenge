class Solution {
    public boolean isPathCrossing(String dir) {
        Set<String> unqPoints = new HashSet<>();
        char path[] = dir.toCharArray();
        int xCord = 0, yCord = 0, sz = path.length;
        String orgKey = Integer.toString(xCord) + " " +  Integer.toString(yCord);
        unqPoints.add(orgKey);
        for(int indx = 0; indx < sz; indx++){
            if(path[indx] == 'N')
                yCord++;
            else if(path[indx] == 'S')
                yCord--;
            else if(path[indx] == 'E')
                xCord++;      
            else
                xCord--;
            String cordKey = Integer.toString(xCord) + " " +  Integer.toString(yCord);
            if(unqPoints.contains(cordKey))return true;
            unqPoints.add(cordKey); 
        }    
        return false;
    }
}
