class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length, cols = matrix[0].length;

        int top = 0, botm = rows - 1;
        while(top <= botm){
            int m = (top + botm) / 2;

            if(target > matrix[m][cols - 1]){
                top = m + 1;
            }
            else if(target < matrix[m][0]){
                botm = m - 1;
            }
            else{
                break;
            }
        }
        if(!(top <= botm)){
            return false;
        }
        int row = (top + botm) / 2;
        int l = 0, h = cols - 1;
        while(l <= h){
            int m = l + ((h - l) / 2);

            if(matrix[row][m] == target){
                return true;
            }
            else if(matrix[row][m] > target){
                h = m - 1;
            }
            else{
                l = m + 1;
            }
        }
        return false;
    }
}
