class Solution {
    int maxArea;
    int rows;
    int cols;
    public int maxAreaOfIsland(int[][] grid) {
        rows = grid.length;
        cols = grid[0].length;
    }
    void dfs(int r,int c,char[][] grid,int curArea){
        if(grid[r][c] == '0'){
           return;
        }

        grid[r][c] = '0';
        curArea++;

        if(r > 0) dfs(r-1,c,grid);
        if(r < rows - 1) dfs(r+1,c,grid);
        if(c > 0) dfs(r,c-1,grid);
        if(c < cols-1) dfs(r,c+1,grid);
        
    }
}
