class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int col = matrix[0].length;
        int row = matrix.length;

        int currow = 0;

        while(currow < row){
            int l = 0, h = col- 1;
            
            if(matrix[currow][l] <= target && target <= matrix[currow][h]){ 
        
                while(l <= h){
                    int m = (l + h) / 2;
                    
                    if(matrix[currow][m] == target){
                        return true;
                    }
                    else if(matrix[currow][m] < target){
                        l = m + 1;
                    }
                    else{
                        h = m - 1;
                    }
                }
                return false;
            }
            else{
                currow++;
            }
        }
        return false; 
    }
}
