class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int col = matrix[0].length, row = matrix.length;
        int n = row * col;
        int[] array = new int[n];

        int r = 0, c = 0;
        for(int i = 0; i < n; i++){
            if(c == col){
                r++;
                c = 0;
            }
            array[i] = matrix[r][c];
            c++;
        }
        int l = 0, h = n - 1;
        while(l <= h){
            int m = (l + h) / 2;
                    
            if(array[m] == target){
                return true;
            }
            else if(array[m] < target){
                l = m + 1;
            }
            else{
                h = m - 1;
            }
        }
        return false;
 
    }
}
