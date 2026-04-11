//boolean Matrix for each r , c , box
class Solution {
    public boolean isValidSudoku(char[][] board) {
        boolean[][] row = new boolean[9][9];
        boolean[][] col = new boolean[9][9];
        boolean[][] box = new boolean[9][9];

        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                
                if(board[i][j] == '.') continue;
                //convert char number  to int 
                int num = board[i][j] - '1';

                int boxnum = (i/3) * 3 + (j/3);

                if(row[i][num] == true || col[j][num] == true || box[boxnum][num] == true){
                    return false;
                }

                row[i][num] = true;
                col[j][num] = true;
                box[boxnum][num] = true;
            }
        
        }
        return true;
    }
}
