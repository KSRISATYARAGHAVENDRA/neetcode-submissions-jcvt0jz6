class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        int rows = matrix.length , cols = matrix[0].length;
        int row = 0;
        int col = -1;
        char dir = 'r';

        for(int i = 0 ; i < rows*cols; i++){
            switch(dir){
                case 'r':{
                    col++;
                    list.add(matrix[row][col]);
                    matrix[row][col] = -1;
                    if(col == cols - 1 || matrix[row][col+1] == -1)
                        dir = 'd';
                    break;
                }
                case 'd':{
                    row++;
                    list.add(matrix[row][col]);
                    matrix[row][col] = -1;
                    if(row == rows - 1 || matrix[row+1][col] == -1)
                        dir = 'l';
                    break;
                }
                case 'l' :{
                    col--;
                    list.add(matrix[row][col]);
                    matrix[row][col] = -1;
                    if(col == 0 || matrix[row][col-1] == -1)
                        dir = 'u';
                    break;
                }
                case 'u':{
                    row--;
                    list.add(matrix[row][col]);
                    matrix[row][col] = -1;
                    if(row == 0 || matrix[row - 1][col] == -1)
                    dir = 'r';
                    break;
                }
            }
        }
        return list;  
    }
}
