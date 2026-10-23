class Solution {

    public int numIslands(char[][] grid) {
        int res = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == '1'){
                    res++;
                    dfs(i,j,grid);
                }
            }
        }
        return res;
    }

    void dfs(int r,int c,char[][] grid){
        if(grid[r][c] == '0'){
           return;
        }

        grid[r][c] = '0';

        if(r > 0) dfs(r-1,c,grid);
        if(r < grid.length - 1) dfs(r+1,c,grid);
        if(c > 0) dfs(r,c-1,grid);
        if(c < grid[0].length-1) dfs(r,c+1,grid);
        
    }
}
