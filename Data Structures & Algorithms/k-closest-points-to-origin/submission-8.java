class Solution {
    public int[][] kClosest(int[][] points, int k) {
        
        int l = 0 , r = points.length - 1;
        int pivot = points.length;

        while(pivot != k-1){
            pivot = partition(points ,l , r);

            if(pivot > k - 1){
                r = pivot - 1;
            }else{
                l = pivot + 1;
            }
        }
        int[][] res = new int[k][2];
        System.arraycopy(points , 0 , res , 0 , k);

        return res;
    }
    int partition(int[][] points, int l , int r){
        
        int pivotDist = Euclidian(points[r]);
        int left = l;
        
        for(int i = l; i < r; i++){
            if(Euclidian(points[i]) < pivotDist){
                int[] temp = points[i];
                points[i] = points[left];
                points[left] = temp;
                left++;
            }
        }
        int[] temp = points[r];
        points[r] = points[left];
        points[left] = temp;

        return left;
    }
    int Euclidian(int[] point){
        return point[0]*point[0] + point[1]*point[1];
    }
}
