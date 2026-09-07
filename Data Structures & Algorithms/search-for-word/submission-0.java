class Solution {
    public boolean exist(char[][] board, String word) {
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                if(dfs(i, j, board, 0, word)){
                    return true;
                }
            }
        }
        return false;
    }
    boolean dfs(int i, int j, char[][] board, int n , String word){
        if(n == word.length())
            return true;
        
        if(i < 0 || i == board.length ||
         j < 0 || j == board[0].length || 
         board[i][j] != word.charAt(n) || board[i][j] == '#') 
            return false; 

        board[i][j] = '#';
        boolean res = (dfs(i, j - 1, board, n + 1, word)||
                       dfs(i + 1, j, board, n + 1, word)||
                       dfs(i, j + 1, board, n + 1, word)||
                       dfs(i - 1, j, board, n + 1, word));
        board[i][j] = word.charAt(n);

        return res;     
    }
}
