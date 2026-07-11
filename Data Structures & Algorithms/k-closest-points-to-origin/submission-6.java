class Solution {
    public int[][] kClosest(int[][] points, int k) {
        int[][] a = new int[points.length][3];

        int i = 0;
        for(int[] point : points){
            int x = point[0];
            int y = point[1];
            int dist = x*x + y*y;

            a[i++] = new int[]{dist, x ,y};
        }
        int[][] res = new int[k][2];
        quickSort(a , 0 ,points.length-1 , k);
        i = 0;
        while(i<k){
            res[i][0] = a[i][1];
            res[i][1] = a[i][2];
            i++;
        }
        return res;
    }
    void quickSort(int[][] a ,int l , int r ,int k){
        if(l>=r)
            return;
        
        int pivot = pivotIndex(a , l , r);
        if(pivot -1 == k)
            return;
        else if(pivot > k - 1)
            quickSort(a , l , pivot - 1 , k);
        else
            quickSort(a , pivot + 1 , r , k);
    }
    int pivotIndex(int[][] a, int l , int r){
        int low = l;
        int high = r;
        int pivot = a[l + rand.nextInt(r - l + 1)][0];

        while(low <= high){
            while(low <= high && a[low][0] <= pivot) low++;

            while(low <= high && pivot < a[high][0]) high--;

            if(low < high){
                int[] temp = a[low];
                a[low] = a[high];
                a[high] = temp;
            }
        }
        int[] temp = a[high];
        a[high] = a[(l+r)/2];
        a[(l+r)/2] = temp;
        return high;
    }
}
