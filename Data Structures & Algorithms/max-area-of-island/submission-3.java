class Solution {
    int res;
    int rows;
    int cols;
    public int maxAreaOfIsland(int[][] grid) {
        rows = grid.length;
        cols = grid[0].length;

        for(int i = 0; i < rows; i++)
            for(int j = 0; j < cols; j++)
                if(grid[i][j] == 1)
                    res = Math.max(res,dfs(i,j,grid));
        return res;
    }
    int dfs(int r,int c,int[][] grid){

        grid[r][c] = 0;
        int ans = 1;
        if(r > 0 && grid[r-1][c] == 1) ans += dfs(r-1,c,grid);
        if(r < rows - 1 && grid[r+1][c] == 1) ans += dfs(r+1,c,grid);
        if(c > 0 && grid[r][c-1] == 1) ans += dfs(r,c-1,grid);
        if(c < cols-1 && grid[r][c+1] == 1) ans += dfs(r,c+1,grid);

        return ans;
    }
}
