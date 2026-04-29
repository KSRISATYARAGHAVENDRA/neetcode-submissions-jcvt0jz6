class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int col = matrix[0].length, row = matrix.length;
        int n = row * col;
        
        int l = 0, h = n - 1;
        while(l <= h){
            int m = (l + h) / 2;
            int currow = m / col, curcol = m % col;
                    
            if(matrix[currow][curcol] == target){
                return true;
            }
            else if(matrix[currow][curcol] < target){
                l = m + 1;
            }
            else{
                h = m - 1;
            }
        }
        return false;
 
    }
}
