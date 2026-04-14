// binary search

class Solution {
    public int[] twoSum(int[] numbers, int target) {
       int n = numbers.length;
       for(int i = 0; i < n; i++){
        int l = i + 1, r = n - 1;
        int needed = target - numbers[i];
        while(l <= r){
            int mid = (l + r) / 2;
            
            if(needed == numbers[mid]){
                return new int[]{i + 1, mid + 1};
            }
            else if(needed < numbers[mid]){
                r = mid - 1;
            }
            else{
                l = mid + 1;
            }
        }
       }
       return new int[0]; 
    }
}
