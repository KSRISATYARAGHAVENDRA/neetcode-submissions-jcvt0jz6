class Solution {
    final int INF = 2147483647;
    int[] rDir = {-1,1,0,0};
    int[] cDir = {0,0,-1,1};
    boolean[][] visited;

    public void islandsAndTreasure(int[][] grid) {
        visited = new boolean[grid.length][grid[0].length];
        for(int i = 0; i < grid.length; i++){
            for(int j = 0;j < grid[0].length; j++){
                if(!(grid[i][j] <= 0)){
                    grid[i][j] = dfs(i,j,grid);
                }
            }
        }
    }
    int dfs(int i, int j,int[][] grid){
        if(i < 0 || i == grid.length || j < 0 || j == grid[0].length ||
           visited[i][j] || grid[i][j] == -1 )
           return INF;
        
        if(grid[i][j] == 0){
            return 0;
        }
        visited[i][j] = true;
        int res = INF;

        for(int d = 0; d < rDir.length; d++){
            int cur = dfs(i+rDir[d],j+cDir[d],grid);
            if(cur != INF)
                res = Math.min(res,1+cur);
        }
        visited[i][j] = false;
        return res;
    }
}
