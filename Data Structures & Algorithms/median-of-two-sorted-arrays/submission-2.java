class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;

        

        int left = 0;
        int right = n;
        int half = (n + m + 1) / 2;

        while(left <= right){

            int i = (left + right) / 2;
            int j = half - i;

            int nums1left = (i == 0)? Integer.MIN_VALUE : nums1[i - 1];
            int nums1right = (i == n)? Integer.MAX_VALUE : nums1[i];
            int nums2left = (j == 0)? Integer.MIN_VALUE : nums2[j - 1];
            int nums2right = (j == m)? Integer.MAX_VALUE : nums2[j];

            if(nums1left <= nums2right && nums2left <= nums1right){
                if((n + m) % 2 == 0){
                    int median1 = Math.max(nums1left, nums2left);
                    int median2 = Math.min(nums1right, nums2right);
                    return (median1 + median2) / 2.0;
                }
                else{
                    return Math.max(nums1left, nums2left);
                }
            }
            else if(nums1left > nums2right){
                right = i - 1;
            }
            else{
                left = i + 1;
            }
        }
        return 0.0;
    }
}
