class Solution {
        int ans;
    public void islandsAndTreasure(int[][] grid) {
        for(int i = 0; i < grid.length; i++){
            for(int j = 0;j < grid[0].length; j++){
                if(!(grid[i][j] <= 0)){
                    ans = Integer.MAX_VALUE;
                    grid[i][j] = dfs(i,j,new boolean[grid.length][grid[0].length],grid,0);
                }
            }
        }
    }
    int dfs(int i, int j, boolean[][] visited,int[][] grid,int curDist){
        if(i < 0 || i == grid.length || j < 0 || j == grid[0].length ||
           visited[i][j] == true || grid[i][j] == -1 || curDist >= ans)
           return 0;
        
        if(grid[i][j] == 0){
            ans = Math.min(ans,curDist);
            return 0;
        }
        visited[i][j] = true;
        dfs(i+1,j,visited,grid,curDist+1);
        dfs(i-1,j,visited,grid,curDist+1);
        dfs(i,j+1,visited,grid,curDist+1);
        dfs(i,j-1,visited,grid,curDist+1);
        visited[i][j] = false;
        return ans;
    }
}
