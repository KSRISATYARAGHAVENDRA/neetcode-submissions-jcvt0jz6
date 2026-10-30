class Solution {
    int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};
    int rows;
    int cols;
    int INF = 2147483647;
    public void islandsAndTreasure(int[][] grid) {
        rows = grid.length;
        cols = grid[0].length;
        Queue<int[]> q = new LinkedList<>();

        for(int row = 0; row < rows; row++){
            for(int col = 0; col < cols; col++){
                if(grid[row][col] == 0){
                    q.add(new int[]{row,col});
                }
            }
        }
        
        bfs(q,grid);
    }
    
    public void bfs(Queue<int[]> q,int[][] grid){
        int steps = 1;

        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                int[] dims = q.poll();
                int r = dims[0];
                int c = dims[1];
                for(int[] dir : dirs){
                    int nr = r + dir[0];
                    int nc = c + dir[1];

                    if(nr < 0 || nr == rows || nc < 0 || nc == cols || grid[nr][nc] != INF || grid[nr][nc] == -1)
                        continue;
                    grid[nr][nc] = steps;
        
                    q.add(new int[]{nr,nc});
                }
            }
            steps++;
        }    
    }
}
