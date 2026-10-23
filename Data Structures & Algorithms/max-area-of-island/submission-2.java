class Solution {
    int maxArea;
    int rows;
    int cols;
    public int maxAreaOfIsland(int[][] grid) {
        rows = grid.length;
        cols = grid[0].length;

        for(int i = 0; i < rows; i++)
            for(int j = 0; j < cols; j++)
                if(grid[i][j] == 1)
                    dfs(i,j,grid,1);
        return maxArea;
    }
    void dfs(int r,int c,int[][] grid,Integer curArea){

        grid[r][c] = 0;
        maxArea = Math.max(maxArea,curArea);

        if(r > 0 && grid[r-1][c] == 1){ 
            curArea++;
            dfs(r-1,c,grid,curArea);
        }
        if(r < rows - 1 && grid[r+1][c] == 1)
        {
            curArea++;
            dfs(r+1,c,grid,curArea);
        } 
        if(c > 0 && grid[r][c-1] == 1)
        { 
            curArea++;
            dfs(r,c-1,grid,curArea);
        }
        if(c < cols-1 && grid[r][c+1] == 1) {
            curArea++;
            dfs(r,c+1,grid,curArea);
        }
    }
}
