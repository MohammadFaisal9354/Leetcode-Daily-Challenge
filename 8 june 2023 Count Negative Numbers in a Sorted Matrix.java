class Solution {
    public int countNegatives(int[][] grid)
    {
        int row=grid.length-1,column=0,col_length=grid[0].length;
        int counter=0;
        while(row>=0 && column<col_length){
            if(grid[row][column]<0)
            {
                row--; 
                counter+=col_length-column;
            }
            else           
                column++; 
        }
         return counter;
    }
}
