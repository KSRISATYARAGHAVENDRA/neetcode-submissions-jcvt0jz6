class Solution {
    int INF = Integer.MAX_VALUE;
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
                    matrix[row][col] = INF;
                    if(col == cols - 1 || matrix[row][col+1] == INF)
                        dir = 'd';
                    break;
                }
                case 'd':{
                    row++;
                    list.add(matrix[row][col]);
                    matrix[row][col] = INF;
                    if(row == rows - 1 || matrix[row+1][col] == INF)
                        dir = 'l';
                    break;
                }
                case 'l' :{
                    col--;
                    list.add(matrix[row][col]);
                    matrix[row][col] = INF;
                    if(col == 0 || matrix[row][col-1] == INF)
                        dir = 'u';
                    break;
                }
                case 'u':{
                    row--;
                    list.add(matrix[row][col]);
                    matrix[row][col] = INF;
                    if(row == 0 || matrix[row - 1][col] == INF)
                    dir = 'r';
                    break;
                }
            }
        }
        return list;  
    }
}
